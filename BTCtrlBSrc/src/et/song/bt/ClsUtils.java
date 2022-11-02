package et.song.bt;

import java.lang.reflect.Method;
import java.lang.reflect.Field;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

public class ClsUtils 
{

    static public boolean createBond(Class btClass, BluetoothDevice btDevice)
    throws Exception
    {
        Method createBondMethod = btClass.getMethod("createBond");
        Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }

    static public boolean removeBond(Class btClass, BluetoothDevice btDevice)
            throws Exception
    {
        Method removeBondMethod = btClass.getMethod("removeBond");
        Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }
 
    static public boolean setPin(Class btClass, BluetoothDevice btDevice,
            byte[] pwd) throws Exception
    {
        try
        {
            Method removeBondMethod = btClass.getDeclaredMethod("setPin",
                    new Class[]
                    {byte[].class});
            Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice,
                    new Object[]
                    {pwd});
            Log.e("returnValue", "" + returnValue);
        }
        catch (SecurityException e)
        {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
 
    }
 
    // 鍙栨秷鐢ㄦ埛杈撳叆
    static public boolean cancelPairingUserInput(Class btClass,
            BluetoothDevice device)
 
    throws Exception
    {
        Method createBondMethod = btClass.getMethod("cancelPairingUserInput");
        //cancelBondProcess(btClass, device);
        Boolean returnValue = (Boolean) createBondMethod.invoke(device);
        return returnValue.booleanValue();
    }
 
    // 鍙栨秷閰嶅
    static public boolean cancelBondProcess(Class btClass,
            BluetoothDevice device)
 
    throws Exception
    {
        Method createBondMethod = btClass.getMethod("cancelBondProcess");
        Boolean returnValue = (Boolean) createBondMethod.invoke(device);
        return returnValue.booleanValue();
    }
 
    /**
     *
     * @param clsShow
     */
    static public void printAllInform(Class clsShow)
    {
        try
        {
            // 鍙栧緱鎵�湁鏂规硶
            Method[] hideMethod = clsShow.getMethods();
            int i = 0;
            for (; i < hideMethod.length; i++)
            {
                Log.e("method name", hideMethod[i].getName() + ";and the i is:"
                        + i);
            }
            // 鍙栧緱鎵�湁甯搁噺
            Field[] allFields = clsShow.getFields();
            for (i = 0; i < allFields.length; i++)
            {
                Log.e("Field name", allFields[i].getName());
            }
        }
        catch (SecurityException e)
        {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // throw new RuntimeException(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	    
    
    static public boolean pair(String strAddr, String strPsw)
    {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter
                .getDefaultAdapter();
 
        bluetoothAdapter.cancelDiscovery();
 
        if (!bluetoothAdapter.isEnabled())
        {
            bluetoothAdapter.enable();
        }
 
        if (!BluetoothAdapter.checkBluetoothAddress(strAddr))
        { // 妫�煡钃濈墮鍦板潃鏄惁鏈夋晥
 
            Log.d("mylog", "devAdd un effient!");
        }
 
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(strAddr);
 
        if (device.getBondState() != BluetoothDevice.BOND_BONDED)
        {
            try
            {
                Log.d("mylog", "NOT BOND_BONDED");
                ClsUtils.setPin(device.getClass(), device, strPsw.getBytes()); // 鎵嬫満鍜岃摑鐗欓噰闆嗗櫒閰嶅
                ClsUtils.createBond(device.getClass(), device);
                //remoteDevice = device; // 閰嶅瀹屾瘯灏辨妸杩欎釜璁惧瀵硅薄浼犵粰鍏ㄥ眬鐨剅emoteDevice
                result = true;
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
 
                Log.d("mylog", "setPiN failed!");
                e.printStackTrace();
            } //
 
        }
        else
        {
            Log.d("mylog", "HAS BOND_BONDED");
            try
            {
                ClsUtils.createBond(device.getClass(), device);
                ClsUtils.setPin(device.getClass(), device, strPsw.getBytes()); // 鎵嬫満鍜岃摑鐗欓噰闆嗗櫒閰嶅
                ClsUtils.createBond(device.getClass(), device);
//                remoteDevice = device; // 濡傛灉缁戝畾鎴愬姛锛屽氨鐩存帴鎶婅繖涓澶囧璞′紶缁欏叏灞�殑remoteDevice
                result = true;
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                Log.d("mylog", "setPiN failed!");
                e.printStackTrace();
            }
        }
        return result;
    }
}
