package et.song.value;

public final class Value {
	public static int HEADER = 0x99;

	public static class DeviceType {
		public static int TYPE_TV = 0x2000;
		public static int TYPE_STB = 0x4000;
		public static int TYPE_DVD = 0x6000;
		public static int TYPE_FANS = 0x8000;
		public static int TYPE_AIR = 0xA000;
		public static int TYPE_LIGHT = 0xC000;
		public static int TYPE_PJT = 0xE000;
	}

	public static class TV {
		private static int TVValue = 0x2000;
		public static int VOLSUB = TVValue | 0x01;
		public static int CHADD = TVValue | 0x03;
		public static int MENU = TVValue | 0x05;
		public static int CHSUB = TVValue | 0x07;
		public static int VOLADD = TVValue | 0x09;
		public static int POWER = TVValue | 0x0B;
		public static int MUTE = TVValue | 0x0D;
		public static int KEY1 = TVValue | 0x0F;
		public static int KEY2 = TVValue | 0x11;
		public static int KEY3 = TVValue | 0x13;
		public static int KEY4 = TVValue | 0x15;
		public static int KEY5 = TVValue | 0x17;
		public static int KEY6 = TVValue | 0x19;
		public static int KEY7 = TVValue | 0x1B;
		public static int KEY8 = TVValue | 0x1D;
		public static int KEY9 = TVValue | 0x1F;
		public static int KEY10 = TVValue | 0x21;
		public static int KEY0 = TVValue | 0x23;
		public static int AV = TVValue | 0x25;
		public static int BACK = TVValue | 0x27;
		public static int OK = TVValue | 0x29;
	}

	public static class STB {
		private static int STBValue = 0x4000;
		public static int WAIT = STBValue | 0x01;
		public static int KEY1 = STBValue | 0x03;
		public static int KEY2 = STBValue | 0x05;
		public static int KEY3 = STBValue | 0x07;
		public static int KEY4 = STBValue | 0x09;
		public static int KEY5 = STBValue | 0x0B;
		public static int KEY6 = STBValue | 0x0D;
		public static int KEY7 = STBValue | 0x0F;
		public static int KEY8 = STBValue | 0x11;
		public static int KEY9 = STBValue | 0x13;
		public static int WATCH = STBValue | 0x15;
		public static int KEY0 = STBValue | 0x17;
		public static int BACK = STBValue | 0x19;
		public static int UP = STBValue | 0x1B;
		public static int LEFT = STBValue | 0x1D;
		public static int OK = STBValue | 0x1F;
		public static int RIGHT = STBValue | 0x21;
		public static int DOWN = STBValue | 0x23;
		public static int VOLADD = STBValue | 0x25;
		public static int VOLSUB = STBValue | 0x27;
		public static int CHADD = STBValue | 0x29;
		public static int CHSUB = STBValue | 0x2B;
		public static int MENU = STBValue | 0x2D;
	}

	public static class DVD {
		private static int DVDValue = 0x6000;
		public static int LEFT = DVDValue | 0x01;
		public static int UP = DVDValue | 0x03;
		public static int OK = DVDValue | 0x05;
		public static int DOWN = DVDValue | 0x07;
		public static int RIGHT = DVDValue | 0x09;

		public static int POWER = DVDValue | 0x0B;
		public static int MUTE = DVDValue | 0x0D;
		public static int QUICKBACK = DVDValue | 0x0F;
		public static int PLAY = DVDValue | 0x11;
		public static int QUICKFORWARD = DVDValue | 0x13;

		public static int UPSONG = DVDValue | 0x15;
		public static int STOP = DVDValue | 0x17;
		public static int DOWNSONG = DVDValue | 0x19;
		public static int AV = DVDValue | 0x1B;
		public static int PAUSE = DVDValue | 0x1D;

		public static int TITLE = DVDValue | 0x1F;
		public static int OPEN = DVDValue | 0x21;
		public static int MENU = DVDValue | 0x23;
		public static int BACK = DVDValue | 0x25;

	}

	public static class FANS {
		private static int FANSValue = 0x8000;                     	
		public static int POWER = FANSValue | 0x01;
		public static int KEY0 = FANSValue | 0x03;
		public static int FREQ = FANSValue | 0x05;
		public static int MODE = FANSValue | 0x07;
		public static int TIMER = FANSValue | 0x09;
		public static int LIGHT = FANSValue | 0x0B;
		public static int LI = FANSValue | 0x0D;
		public static int KEY1 = FANSValue | 0x0F;
		public static int KEY2 = FANSValue | 0x11;
		public static int KEY3 = FANSValue | 0x13;
		public static int KEY4 = FANSValue | 0x15;
		public static int KEY5 = FANSValue | 0x17;
		public static int KEY6 = FANSValue | 0x19;
		public static int KEY7 = FANSValue | 0x1B;
		public static int KEY8 = FANSValue | 0x1D;
		public static int KEY9 = FANSValue | 0x1F;
		public static int SLEEP = FANSValue | 0x21;	
		public static int COOL = FANSValue | 0x23;		
		public static int SPEED = FANSValue | 0x25;		
		public static int SPEEDLOW = FANSValue | 0x27;	
		public static int SPEEDMIDDLE = FANSValue | 0x29;
		public static int SPEEDHIGHT = FANSValue | 0x2B;
	}

	public static class PJT {																				
		private static int PJTValue = 0xE000;
		public static int POWER_ON = PJTValue | 0x01;
		public static int POWER_OFF = PJTValue | 0x03;
		public static int COMPUTER = PJTValue | 0x05;
		public static int VIDEO = PJTValue | 0x07;
		public static int SIGN = PJTValue | 0x09;
		public static int ZOOMADD = PJTValue | 0x0B;
		public static int ZOOMSUB = PJTValue | 0x0D;
		public static int PICTUREADD = PJTValue | 0x0F;
		public static int PICTURESUB = PJTValue | 0x11;
		public static int MENU = PJTValue | 0x13;
		public static int OK = PJTValue | 0x15;
		public static int UP = PJTValue | 0x17;
		public static int LEFT = PJTValue | 0x19;
		public static int RIGHT = PJTValue | 0x1B;
		public static int DOWN = PJTValue | 0x1D;
		public static int EXIT = PJTValue | 0x1F;
		public static int VOLADD = PJTValue | 0x21;
		public static int VOLSUB = PJTValue | 0x23;
		public static int MUTE = PJTValue | 0x25;
		public static int AUTO = PJTValue | 0x27;
		public static int PAUSE = PJTValue | 0x29;
		public static int BRIGHTNESS = PJTValue | 0x2B;
	}

	public static class LIGHT {
		private static int LIGHTValue = 0xC000;
		public static int POWERALLON = LIGHTValue | 0x01;
		public static int POWERALLOFF = LIGHTValue | 0x02;
		public static int POWERON = LIGHTValue | 0x03;
		public static int POWEROFF = LIGHTValue | 0x04;
		public static int LIGHT = LIGHTValue | 0x05;
		public static int DARK = LIGHTValue | 0x06;
		public static int LOST = LIGHTValue | 0x07;
		public static int KEY1 = LIGHTValue | 0x08;
		public static int KEY2 = LIGHTValue | 0x09;
		public static int KEY3 = LIGHTValue | 0x0A;
		public static int KEY4 = LIGHTValue | 0x0B;
		public static int KEY5 = LIGHTValue | 0x0C;
		public static int KEY6 = LIGHTValue | 0x0D;
		public static int KEYA = LIGHTValue | 0x0E;
		public static int KEYB = LIGHTValue | 0x0F;
		public static int KEYC = LIGHTValue | 0x10;
		public static int KEYD = LIGHTValue | 0x11;
		public static int SETTING = LIGHTValue | 0x12;
		public static int STUDY = LIGHTValue | 0x13;
		public static int TIMER1 = LIGHTValue | 0x14;
		public static int TIMER2 = LIGHTValue | 0x15;
		public static int TIMER3 = LIGHTValue | 0x16;
		public static int TIMER4 = LIGHTValue | 0x17;
	}

	public static class AIR {
		private static int AIRValue = 0xA000;
		public static int POWER = AIRValue | 0x01;
		public static int MODE = AIRValue | 0x02;
		public static int WIND_COUNT = AIRValue | 0x03;
		public static int WIND_DIR = AIRValue | 0x04;
		public static int WIND_AUTO_DIR = AIRValue | 0x05;
		public static int TEMPADD = AIRValue | 0x06;
		public static int TEMPSUB = AIRValue | 0x07;
	}

	public static class NotifyType {
		private static int NotifyValue = 0xF000;
		public static int CLOSE_DIALOG = NotifyValue | 0x01;
	}
}
