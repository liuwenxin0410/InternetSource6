package et.song.data;

import java.util.ArrayList;
import java.util.List;

public final class KnownLibPJT {
	private static int[][] mPJTTables = new int[][] {
			{ 0, 1, 2, 45, 46, 47, 48, 49, 3, 4, 6, 7, 8, 9, 10, 11 }, // ������,��֥,����
																		// 3+(+13
			{ 3, 4, 6, 14, 15, 16, 17, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
					32, 33, 34 }, // ����,����,��ʿͨ3+(+13
			{ 7, 8, 9, 10, 11, 26, 27, 28, 29, 30, 31, 32, 33, 34, 18, 19, 20,
					21 }, // ����,���� 5+(+13
			{ 12, 13, 14, 15, 16, 21, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44 }, // ����,��ͼ��
																				// 5+(+11
			{ 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 }, // NEC.����.������
																				// 6+(+10
			{ 23, 24, 25, 26, 27, 28, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, // �б�,���,some
																				// 6+(+11
			{ 29, 30, 31, 32, 12, 13, 14, 15, 16, 17, 22, 23, 24 }, // ����,����,����,�б�
																	// 4+(+9
			{ 33, 34, 35, 36, 37, 38, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, // ���,����
																			// 6+(+9
			{ 39, 40, 41, 42, 16, 17, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
					32, 33, 34, 18, 19, 20, 21, 35 }, // �ȷ�,����,������ 4+(+20
			{ 43, 44, 45, 47, 48, 49, 3, 4, 6, 7, 8, 9, 10, 11, 12 }, // ����,LG,�ĵ���
																		// 3+(+12
			{ 46, 47, 48, 49, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 18,
					19, 20, 21, 35, 36 } // ������,���� 4+(+17

	};
	private static List<int[]> mPJTList = new ArrayList<int[]>();

	public static void Init() {
		for (int i = 0; i < mPJTTables.length; i++) {
			mPJTList.add(mPJTTables[i]);
		}
	}

	public static int GetPJTCount(int _index) throws Exception {
		return mPJTList.get(_index).length;
	}

	public static List<int[]> GetPJT() {
		return mPJTList;
	}

	public static int GetData(int _row, int _col) throws Exception {
		return mPJTList.get(_row)[_col];
	}
}
