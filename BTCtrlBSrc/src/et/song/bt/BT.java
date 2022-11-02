/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package et.song.bt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import et.song.ctrl.R;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class BT {
	private int mState;
	private BluetoothAdapter mAdapter;
	private Handler mHandler;
	private Context mContext;

	private AcceptThread mAcceptThread = null;
	private ConnectThread mConnectThread = null;
	private ConnectedThread mConnectedThread = null;
	public static final int STATE_NONE = 0;
	public static final int STATE_LISTEN = 1;
	public static final int STATE_CONNECTING = 2;
	public static final int STATE_CONNECTED = 3;

	private static BT mBT = null;

	private BT() {
		mAdapter = BluetoothAdapter.getDefaultAdapter();
		mState = STATE_NONE;
	}

	public static BT getInstance() {
		if (mBT == null) {
			mBT = new BT();
		}
		return mBT;
	}

	public void setContext(Context _context) {
		mContext = _context;
	}

	public void setHandler(Handler _handler) {
		mHandler = _handler;
	}

	private synchronized void setState(int state) {
		mState = state;
		if (mHandler == null)
			return;
		mHandler.obtainMessage(R.id.MESSAGE_STATE_CHANGE, state, -1)
				.sendToTarget();
	}

	public synchronized int getState() {
		return mState;
	}

	public synchronized void start() {
		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}
		if (mAcceptThread == null) {
			mAcceptThread = new AcceptThread();
			mAcceptThread.start();
		}
		setState(STATE_LISTEN);
	}

	public synchronized void connect(BluetoothDevice device) {
		if (mState == STATE_CONNECTING) {
			if (mConnectThread != null) {
				mConnectThread.cancel();
				mConnectThread = null;
			}
		}
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}
		mConnectThread = new ConnectThread(device);
		mConnectThread.start();
		setState(STATE_CONNECTING);
	}

	public synchronized void connected(BluetoothSocket socket,
			BluetoothDevice device) {

		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}
		if (mAcceptThread != null) {
			mAcceptThread.cancel();
			mAcceptThread = null;
		}

		mConnectedThread = new ConnectedThread(socket);
		mConnectedThread.start();
		setState(STATE_CONNECTED);
	}

	public synchronized void stop() {
		if (mConnectThread != null) {
			mConnectThread.cancel();
			mConnectThread = null;
		}
		if (mConnectedThread != null) {
			mConnectedThread.cancel();
			mConnectedThread = null;
		}
		if (mAcceptThread != null) {
			mAcceptThread.cancel();
			mAcceptThread = null;
		}
		setState(STATE_NONE);
	}

	public void write(byte[] out) {

		ConnectedThread r;
		synchronized (this) {
			if (mState != STATE_CONNECTED)
				return;
			r = mConnectedThread;
		}
		r.write(out);
	}

	private void connectionFailed() {
		setState(STATE_LISTEN);
		if (mContext == null || mHandler == null)
			return;
		Message msg = mHandler.obtainMessage(R.id.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(mContext.getString(R.string.toast),
				mContext.getString(R.string.bt_not_connect));
		msg.setData(bundle);
		mHandler.sendMessage(msg);
	}

	private void connectionLost() {
		setState(STATE_LISTEN);
		if (mContext == null || mHandler == null)
			return;
		Message msg = mHandler.obtainMessage(R.id.MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(mContext.getString(R.string.toast),
				mContext.getString(R.string.bt_lost_connect));
		msg.setData(bundle);
		mHandler.sendMessage(msg);
	}

	private class AcceptThread extends Thread {
		private final BluetoothServerSocket mmServerSocket;

		public AcceptThread() {
			BluetoothServerSocket tmp = null;
			try {
				if (mContext == null || mHandler == null) {
					tmp = mAdapter.listenUsingRfcommWithServiceRecord("BT", UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"));
				} else {
					tmp = mAdapter.listenUsingRfcommWithServiceRecord(mContext
							.getString(R.string.bt_name), UUID
							.fromString(mContext.getString(R.string.bt_uuid)));
				}
			} catch (IOException e) {

			}
			mmServerSocket = tmp;
		}

		public void run() {
			setName("AcceptThread");
			BluetoothSocket socket = null;

			// Listen to the server socket if we're not connected
			while (mState != STATE_CONNECTED) {
				try {
					if (mmServerSocket == null) {
						break;
					}
					socket = mmServerSocket.accept();
				} catch (IOException e) {
					break;
				}
				if (socket != null) {
					synchronized (BT.this) {
						switch (mState) {
						case STATE_LISTEN:
						case STATE_CONNECTING:
							connected(socket, socket.getRemoteDevice());
							break;
						case STATE_NONE:
						case STATE_CONNECTED:
							try {
								socket.close();
							} catch (IOException e) {

							}
							break;
						}
					}
				}
			}
		}

		public void cancel() {
			try {
				if (mmServerSocket != null) {
					mmServerSocket.close();
				}
			} catch (IOException e) {
			}
		}
	}

	private class ConnectThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final BluetoothDevice mmDevice;

		public ConnectThread(BluetoothDevice device) {
			mmDevice = device;
			BluetoothSocket tmp = null;
			try {
				tmp = device.createRfcommSocketToServiceRecord(UUID
						.fromString(mContext.getString(R.string.bt_uuid)));
				// Method m = device.getClass().getMethod("createRfcommSocket",
				// new Class[] { int.class });
				// tmp = (BluetoothSocket) m.invoke(device, Integer.valueOf(1));
			} catch (Exception e) {

			}
			mmSocket = tmp;
		}

		public void run() {
			setName("ConnectThread");
			mAdapter.cancelDiscovery();
			try {
				mmSocket.connect();
			} catch (IOException e) {
				connectionFailed();
				try {
					mmSocket.close();
				} catch (IOException e2) {

				}
				BT.this.start();
				return;
			}
			synchronized (BT.this) {
				mConnectThread = null;
			}
			connected(mmSocket, mmDevice);
		}

		public void cancel() {
			try {
				if (mmSocket != null) {
					mmSocket.close();
				}
			} catch (IOException e) {

			}
		}
	}

	private class ConnectedThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final InputStream mmInStream;
		private final OutputStream mmOutStream;

		public ConnectedThread(BluetoothSocket socket) {
			mmSocket = socket;
			InputStream tmpIn = null;
			OutputStream tmpOut = null;
			try {
				tmpIn = socket.getInputStream();
				tmpOut = socket.getOutputStream();
			} catch (IOException e) {
			}
			mmInStream = tmpIn;
			mmOutStream = tmpOut;
		}

		public void run() {
			byte[] buffer = new byte[110];
			int bytes;
			while (true) {
				try {
					bytes = mmInStream.read(buffer);
					mHandler.obtainMessage(R.id.MESSAGE_READ, bytes, -1, buffer)
							.sendToTarget();
				} catch (IOException e) {
					connectionLost();
					break;
				}
			}
		}

		public void write(byte[] buffer) {
			try {
				mmOutStream.write(buffer);
				mHandler.obtainMessage(R.id.MESSAGE_WRITE, -1, -1, buffer)
						.sendToTarget();
			} catch (IOException e) {
			}
		}

		public void cancel() {
			try {
				if (mmSocket != null) {
					mmSocket.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
