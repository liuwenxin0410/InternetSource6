package et.song.data;

import java.util.ArrayList;
import java.util.List;

public final class KnownLibTV {
	private static int[][] mTVTables = new int[][] {
			{ 1065, 1, 70, 125, 284, 350, 57, 65, 305, 122, 51, 53, 346, 109,
					35, 73, 293, 17, 86, 177, 45, 19, 276, 194, 186, 253, 288,
					358, 328, 6, 283, 377, 21, 231, 334, 254, 316, 268, 20,
					298, 292, 40, 221, 841, 842, 843, 844, 845, 1038, 1039,
					1040, 1041, 1042, 1043, 1001, 1002, 1022, 1031, 556, 558,
					559, 560, 561, 562, 563, 564, 565, 566, 567, 621, 623, 624,
					625, 661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853,
					854, 855, 856, 921, 922, 923, 924, 925, 926, 927, 928, 929,
					930, 931, 932, 933, 934, 935, 712, 713, 714, 715, 716, 717,
					718, 719, 720, 721, 722, 723, 724, 726, 727, 728, 729, 730,
					731, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799,
					800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811,
					812, 813, 814, 815, 816, 817, 818, 820, 821, 822, 823, 825,
					826, 827, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838,
					839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850,
					851, 857, 858, 859, 860, 861, 862, 863, 864, 867, 868, 869,
					870, 871, 872, 873, 874, 875, 876, 878, 879, 879 },// 长虹1
																		// 42+1=43+(+
																		// 119

			{ 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094,
					1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104,
					1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114,
					1115, 1116, 1117, 1118, 1119, 1120, 1121, 1122, 1123, 1124,
					1125, 1126, 1127, 1128, 1129, 1130, 1131, 1132, 1133, 1134,
					1135, 1136, 1137, 1138, 1139, 1140, 1141, 1142, 1143, 1144,
					1145, 1146, 1147, 1148, 1149, 1150, 1151, 1152, 1153, 1154,
					1155, 1156, 2, 246, 297, 53, 99, 205, 106, 131, 159, 19,
					193, 276, 105, 145, 187, 170, 233, 148, 146, 66, 332, 247,
					368, 84, 317, 72, 275, 301, 140, 39, 93, 176, 18, 229, 356,
					314, 119, 272, 208, 230, 320, 173, 357, 326, 789, 790, 791,
					792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803,
					804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815,
					816, 817, 818, 820, 821, 822, 823, 825, 826, 827, 829, 830,
					831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842,
					843, 844, 845, 846, 847, 848, 849, 850, 851, 857, 858, 859,
					860, 861, 862, 863, 864, 867, 868, 869, 870, 871, 872, 873,
					874, 875, 876, 878, 879, 879 },// 康佳2 44+(+80

			{ 4, 371, 298, 17, 134, 218, 276, 263, 342, 181, 3, 150, 360, 285,
					62, 199, 257, 206, 132, 207, 239, 42, 212, 200, 30, 12,
					379, 312, 318, 259, 143, 270, 180, 101, 161, 581, 582, 583,
					584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 594,
					595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606,
					607, 608, 609, 610, 611, 612, 613, 619, 620, 622, 626, 627,
					628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 641, 642,
					643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654,
					655, 656, 659, 659, 660, 661, 662, 663, 664, 665, 666, 667,
					668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679,
					680, 681, 682, 683, 685, 685, 686, 687, 688, 689, 690, 691,
					692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703,
					704 },// TCL 4 35+(+112

			{ 5, 19, 52, 53, 109, 174, 295, 91, 293, 134, 159, 359, 335, 167,
					354, 148, 16, 233, 263, 206, 38, 245, 120, 97, 361, 343, 0,
					77, 96, 108, 142, 144, 155, 191, 192, 198, 210, 216, 222,
					228, 234, 246, 282, 294, 366, 430, 431, 546, 553, 554, 555,
					557, 614, 615, 616, 618, 621, 623, 624, 625, 661, 662, 663,
					664, 725, 749, 819, 824, 828, 852, 853, 854, 855, 856, 865,
					866, 877, 882, 895, 908, 929, 930, 931, 932 },// 厦华5 28+(+56

			{ 1157, 1158, 1159, 1160, 1161, 1162, 1163, 1164, 1165, 1166, 1167,
					1168, 1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1177,
					1178, 1179, 1180, 1181, 1182, 1183, 1184, 1185, 1186, 1187,
					1188, 1189, 1190, 1191, 1192, 1193, 1194, 1195, 1196, 1197,
					1198, 1199, 1200, 1201, 1202, 1203, 1204, 1205, 1206, 1207,
					1208, 1209, 1210, 1211, 1212, 1213, 1214, 1215, 1216, 1217,
					1218, 1219, 1220, 1221, 1222, 1223, 1224, 1225, 1226, 1227,
					1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236, 1237,
					1238, 1239, 1240, 1241, 1242, 1243, 1244, 1245, 1246, 1247,
					1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255, 1256, 1257,
					1258, 1259, 1260, 1261, 1262, 1263, 1264, 1265, 1266, 1267,
					1268, 1269, 1270, 1271,
					1272,
					1273,
					1274,
					1275,
					1276,
					1277,
					1278,
					1279,
					1280,
					1281,
					1282,
					1283,
					1284,
					1285,
					1286,
					1287,
					1288 //
					, 3, 126, 233, 53, 91, 293, 195, 261, 167, 252, 276, 129,
					263, 5, 233, 181, 190, 66, 299, 78, 370, 256, 327, 60, 344,
					303, 244, 353, 149, 197, 204, 198, 192, 257, 182, 158, 308,
					68, 286, 333, 92, 201, 262,
					55,
					74,
					54,
					188,
					215,
					258,
					306,
					341,
					44,
					255,
					117,
					164, //
					880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891,
					892, 893, 894, 896, 897, 898, 899, 900, 901, 902, 903, 904,
					905, 906, 907, 909, 910, 911, 912, 913, 914, 915, 916, 917,
					918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929,
					930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941,
					942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953,
					954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965,
					966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977,
					978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989,
					990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000,
					1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012,
					1013, 1014 },// 创维3 55+(+131

			{ 1289, 1290, 1291, 1292, 1293, 1294, 1295, 1296, 1297, 1298, 1299,
					1300, 1301, 1302, 1303, 1304, 1305, 1306, 1307, 1308, 1309,
					1310, 1311, 1312, 1313, 1314, 1315, 1316, 1317, 1318, 1319,
					1320, 1321, 1322, 1323, 1324, 1325, 1326, 1327, 1328, 1329,
					1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339,
					1340, 1341, 1342, 1343, 1344, 1345, 1346, 1347, 1348, 1349,
					1350, 1351, 1352, 1353, 1354, 1355, 1356, 1357, 1358, 1359,
					1360, 1361, 1362, 1363, 1364, 1365, 1366, 1367, 1368, 1369,
					1370, 1371, 1372, 1373, 1374, 1375, 1376, 1377, 1378, 1379,
					1380, 1381, 1382, 1383, 1384, 1385, 1386, 6, 579, 639, 284,
					183, 374, 350, 51, 346, 249, 91, 195, 261, 177, 136, 69,
					302, 66, 269, 237, 340, 278, 365, 88, 366, 294, 37, 369,
					287, 24, 168, 228, 213, 63, 110, 50, 98, 111, 144, 83, 47,
					225, 25, 104, 349, 133, 243, 152, 130, 330,
					296,
					274,
					240,
					58,
					304,
					196,
					363,
					331,
					291,
					172, //
					29, 658, 684, 90, 217, 177, 263, 187, 171, 190, 136, 69,
					147, 82, 311, 202, 290, 220, 264, 32, 338, 70, 123, 107,
					95, 18, 24, 66, 72, 84, 96, 108, 142, 144, 155, 191, 192,
					198, 210, 216, 222, 228, 234, 246, 282, 294, 366, 430, 431,
					546, 553, 554, 555, 557, 614, 615, 616, 618, 621, 623, 624,
					625, 661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853,
					854, 855, 856, 865, 866, 877, 882, 895, 908, 929, 930, 931,
					932, 944, 1001, 1002, 1022, 1031, 556, 558, 559, 560, 561,
					562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573,
					574, 575, 576, 577, 580 },// 海信 6 60+(+113

			{ 1387, 1388, 1389, 1390, 1391, 1392, 1393, 1394, 1395, 1396, 1397,
					1398, 1399, 1400, 1401, 1402, 1403, 1404 },//清华同方
			{ 7, 640, 657, 69, 302, 372, 2, 9, 29, 202, 6, 228, 213, 63, 59,
					14, 234, 120, 250, 841, 842, 843, 844, 845, 1038, 1039,
					1040, 1041, 1042, 1043, 1001, 1002, 1022, 1031, 556, 558,
					559, 560, 561, 562, 563, 564, 565, 566, 567, 621, 623, 624,
					625, 661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853,
					854, 855, 856, 921, 922, 923, 924, 925, 926, 927, 928, 929,
					930, 931, 932, 933, 934, 935, 712, 713, 714, 715, 716, 717,
					718, 719, 720, 721, 722, 723, 724, 726, 727, 728, 729, 730,
					731 },// 海尔 7 19+(+39

			{ 8, 473, 506, 374, 350, 53, 108, 174, 91, 106, 293, 96, 17, 177,
					103, 276,
					263,
					233,
					65,
					171,
					136,
					66,
					366,
					144,
					28, //
					581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592,
					593, 594, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603,
					604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 619, 620,
					622, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636,
					637, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651,
					652, 653, 654, 655, 656, 659, 659, 660, 661, 662, 663, 664,
					665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676,
					677, 678, 679, 680, 681, 682, 683, 685, 685, 686, 687, 688,
					689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700,
					701, 702, 703, 704 },// 金星8 25+(+112

			{ 9, 418, 444, 142, 53, 109, 155, 166, 114, 174, 91, 35, 73, 293,
					102, 300, 134, 335, 57, 177, 45, 17, 241, 263, 233, 322,
					65, 179, 223, 127, 353, 135, 157, 156, 48, 251, 128, 190,
					880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891,
					892, 893, 894, 896, 897, 898, 899, 900, 901, 902, 903, 904,
					905, 906, 907, 909, 910, 911, 912, 913, 914, 915, 916, 917,
					918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929,
					930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941,
					942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953,
					954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965,
					966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977,
					978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989,
					990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000,
					1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012,
					1013, 1014 },// 熊猫9 38+(+131

			{ 10, 453, 472, 248, 351, 94, 46, 82, 266, 100, 280, 71, 64, 1073,
					1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 96,
					108, 142, 144, 155, 191, 192, 198, 210, 216, 222, 228, 234,
					246, 282, 294, 366, 430, 431, 546, 553, 554, 555, 557, 614,
					615, 616, 618, 621, 623, 624, 625, 661, 662, 663, 664, 725,
					749, 819, 824, 828, 852, 853, 854, 855, 856, 865, 866, 877,
					882, 895, 908, 929, 930, 931, 932 },// 索尼sony 2013-3-10
														// 21:44;加了10组 /
														// 13+10+(+56

			{ 11, 399, 417, 41, 142, 10, 346, 249, 155, 166, 23, 34, 789, 790,
					791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802,
					803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814,
					815, 816, 817, 818, 820, 821, 822, 823, 825, 826, 827, 829,
					830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841,
					842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 857, 858,
					859, 860, 861, 862, 863, 864, 867, 868, 869, 870, 871, 872,
					873, 874, 875, 876, 878, 879, 879 },// 松下(乐声) 11 12+(+80

			{ 0, 14, 18, 284, 346, 109, 295, 293, 134, 335, 374, 350, 249, 73,
					226, 322, 11, 65, 233, 358, 352, 371, 310, 96, 108, 142,
					144, 155, 191, 192, 198, 210, 216, 222, 228, 234, 246, 282,
					294, 366, 430, 431, 546, 553, 554, 555, 557, 614, 615, 616,
					618, 621, 623, 624, 625, 661, 662, 663, 664, 725, 749, 819,
					824, 828, 852, 853, 854, 855, 856, 865, 866, 877, 882, 895,
					908, 929, 930, 931, 932, 750, 751, 752, 753, 754, 755, 756,
					757 },// 东芝14 23+(+64

			{ 12, 382, 398, 374, 249, 346, 295, 284, 183, 350, 51, 351, 362,
					321, 841, 842, 843, 844, 845, 1038, 1039, 1040, 1041, 1042,
					1043, 1001, 1002, 1022, 1031, 556, 558, 559, 560, 561, 562,
					563, 564, 565, 566, 567, 621, 623, 624, 625, 661, 662, 663,
					664, 725, 749, 819, 824, 828, 852, 853, 854, 855, 856, 921,
					922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933,
					934, 935, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721,
					722, 723, 724, 726, 727, 728, 729, 730, 731 },// 日立12
																	// 14+(+39

			{ 13, 445, 452, 373, 238, 109, 91, 178, 307, 191, 841, 842, 843,
					844, 845, 1038, 1039, 1040, 1041, 1042, 1043, 1001, 1002,
					1022, 1031, 556, 558, 559, 560, 561, 562, 563, 564, 565,
					566, 567, 621, 623, 624, 625, 661, 662, 663, 664, 725, 749,
					819, 824, 828, 852, 853, 854, 855, 856, 921, 922, 923, 924,
					925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 712,
					713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724,
					726, 727, 728, 729, 730, 731 },// 夏普(声宝) 13 10+(+39

			{ 15, 234, 245, 108, 114, 174, 96, 102, 300, 246, 210, 216, 10,
					453, 472, 248, 351, 94, 46, 82, 266, 100, 280, 71, 64,
					1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082,
					96, 108, 142, 144, 155, 191, 192, 198, 210, 216, 222, 228,
					234, 246, 282, 294, 366, 430, 431, 546, 553, 554, 555, 557,
					614, 615, 616, 618, 621, 623, 624, 625, 661, 662, 663, 664,
					725, 749, 819, 824, 828, 852, 853, 854, 855, 856, 865, 866,
					877, 882, 895, 908, 929, 930, 931, 932 },// 飞利蒲 15 12+(+79

			{ 16, 530, 553, 350, 53, 109, 155, 174, 91, 293, 185, 96, 102, 300,
					355, 17, 65, 332, 67, 581, 582, 583, 584, 585, 586, 587,
					588, 589, 590, 591, 592, 593, 594, 594, 595, 596, 597, 598,
					599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610,
					611, 612, 613, 619, 620, 622, 626, 627, 628, 629, 630, 631,
					632, 633, 634, 635, 636, 637, 641, 642, 643, 644, 645, 646,
					647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 659, 659,
					660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671,
					672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683,
					685, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695,
					696, 697, 698, 699, 700, 701, 702, 703, 704 },// 三星16
																	// 19+(+112

			{ 17, 53, 69, 350, 284, 374, 346, 249, 293, 189, 134, 335, 233,
					302, 141, 273, 125, 315, 56, 96, 108, 142, 144, 155, 191,
					192, 198, 210, 216, 222, 228, 234, 246, 282, 294, 366, 430,
					431, 546, 553, 554, 555, 557, 614, 615, 616, 618, 621, 623,
					624, 625, 661, 662, 663, 664, 725, 749, 819, 824, 828, 852,
					853, 854, 855, 856, 865, 866, 877, 882, 895, 908, 929, 930,
					931, 932 },// 三洋17 19+(+56

			{ 183, 53, 109, 309, 91, 293, 134, 335, 174, 233, 841, 842, 843,
					844, 845, 1038, 1039, 1040, 1041, 1042, 1043, 1001, 1002,
					1022, 1031, 556, 558, 559, 560, 561, 562, 563, 564, 565,
					566, 567, 621, 623, 624, 625, 661, 662, 663, 664, 725, 749,
					819, 824, 828, 852, 853, 854, 855, 856, 921, 922, 923, 924,
					925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 712,
					713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724,
					726, 727, 728, 729, 730, 731 },// 日电18 10+(+39

			{ 19, 507, 529, 53, 114, 174, 293, 227, 102, 300, 134, 233, 354,
					88, 157, 209, 203, 367, 113, 789, 790, 791, 792, 793, 794,
					795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806,
					807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818,
					820, 821, 822, 823, 825, 826, 827, 829, 830, 831, 832, 833,
					834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845,
					846, 847, 848, 849, 850, 851, 857, 858, 859, 860, 861, 862,
					863, 864, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876,
					878, 879, 879 },// 西湖19 19+(+80

			{ 350, 49, 53, 43, 109, 114, 174, 91, 295, 73, 205, 226, 85, 293,
					102, 300, 355, 134, 335, 35, 233, 65, 96, 31, 17, 155, 1,
					163, 83, 47, 8, 118, 96, 108, 142, 144, 155, 191, 192, 198,
					210, 216, 222, 228, 234, 246, 282, 294, 366, 430, 431, 546,
					553, 554, 555, 557, 614, 615, 616, 618, 621, 623, 624, 625,
					661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853, 854,
					855, 856, 865, 866, 877, 882, 895, 908, 929, 930, 931, 932 },// 北京
																					// 20
																					// 32+(+56

			{ 21, 554, 578, 284, 183, 374, 350, 51, 109, 91, 293, 134, 359,
					335, 195, 261, 224, 263, 153, 88, 157, 116, 789, 790, 791,
					792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803,
					804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815,
					816, 817, 818, 820, 821, 822, 823, 825, 826, 827, 829, 830,
					831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842,
					843, 844, 845, 846, 847, 848, 849, 850, 851, 857, 858, 859,
					860, 861, 862, 863, 864, 867, 868, 869, 870, 871, 872, 873,
					874, 875, 876, 878, 879, 879 },// 高路华21 22+(+80
			{ 22, 554, 578, 53, 108, 109, 114, 174, 91, 102, 300, 165, 265, 30,
					222, 271, 841, 842, 843, 844, 845, 1038, 1039, 1040, 1041,
					1042, 1043, 1001, 1002, 1022, 1031, 556, 558, 559, 560,
					561, 562, 563, 564, 565, 566, 567, 621, 623, 624, 625, 661,
					662, 663, 664, 725, 749, 819, 824, 828, 852, 853, 854, 855,
					856, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931,
					932, 933, 934, 935, 712, 713, 714, 715, 716, 717, 718, 719,
					720, 721, 722, 723, 724, 726, 727, 728, 729, 730, 731 },// 乐华
																			// 22
																			// 16+(+39

			{ 109, 91, 293, 134, 335, 187, 233, 190, 69, 789, 790, 791, 792,
					793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804,
					805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816,
					817, 818, 820, 821, 822, 823, 825, 826, 827, 829, 830, 831,
					832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843,
					844, 845, 846, 847, 848, 849, 850, 851, 857, 858, 859, 860,
					861, 862, 863, 864, 867, 868, 869, 870, 871, 872, 873, 874,
					875, 876, 878, 879, 879 },// TCBO东宝 TOS东凌23 9+(+80

			{ 374, 53, 249, 114, 174, 73, 293, 131, 102, 300, 134, 335, 167,
					179, 103, 233, 136, 96, 108, 142, 144, 155, 191, 192, 198,
					210, 216, 222, 228, 234, 246, 282, 294, 366, 430, 431, 546,
					553, 554, 555, 557, 614, 615, 616, 618, 621, 623, 624, 625,
					661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853, 854,
					855, 856, 865, 866, 877, 882, 895, 908, 929, 930, 931, 932 },// 福日
																					// 24
																					// 17+(+56

			{ 25, 372, 381, 174, 102, 354, 300, 325, 364, 345, 36, 841, 842,
					843, 844, 845, 1038, 1039, 1040, 1041, 1042, 1043, 1001,
					1002, 1022, 1031, 556, 558, 559, 560, 561, 562, 563, 564,
					565, 566, 567, 621, 623, 624, 625, 661, 662, 663, 664, 725,
					749, 819, 824, 828, 852, 853, 854, 855, 856, 921, 922, 923,
					924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935,
					712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723,
					724, 726, 727, 728, 729, 730, 731 },// LG 25 11+(+39

			{ 109, 91, 49, 43, 35, 295, 73, 205, 226, 31, 85, 96, 108, 142,
					144, 155, 191, 192, 198, 210, 216, 222, 228, 234, 246, 282,
					294, 366, 430, 431, 546, 553, 554, 555, 557, 614, 615, 616,
					618, 621, 623, 624, 625, 661, 662, 663, 664, 725, 749, 819,
					824, 828, 852, 853, 854, 855, 856, 865, 866, 877, 882, 895,
					908, 929, 930, 931, 932 },// 百乐26 11+(+56

			{ 53, 109, 99, 114, 174, 91, 293, 102, 300, 134, 335, 142, 49, 43,
					295, 35, 73, 205, 226, 85, 31, 233, 789, 790, 791, 792,
					793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804,
					805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816,
					817, 818, 820, 821, 822, 823, 825, 826, 827, 829, 830, 831,
					832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843,
					844, 845, 846, 847, 848, 849, 850, 851, 857, 858, 859, 860,
					861, 862, 863, 864, 867, 868, 869, 870, 871, 872, 873, 874,
					875, 876, 878, 879, 879 },// 长城27 22+(+80

			{ 53, 109, 114, 174, 91, 102, 300, 17, 69, 127, 13, 96, 108, 142,
					144, 155, 191, 192, 198, 210, 216, 222, 228, 234, 246, 282,
					294, 366, 430, 431, 546, 553, 554, 555, 557, 614, 615, 616,
					618, 621, 623, 624, 625, 661, 662, 663, 664, 725, 749, 819,
					824, 828, 852, 853, 854, 855, 856, 865, 866, 877, 882, 895,
					908, 929, 932 },// 黄河28 11+(+54

			{ 53, 109, 114, 174, 91, 106, 293, 102, 300, 134, 335, 233, 789,
					790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801,
					802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813,
					814, 815, 816, 817, 818, 820, 821, 822, 823, 825, 826, 827,
					829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840,
					841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 857,
					858, 859, 860, 861, 862, 863, 864, 867, 868, 869, 870, 871,
					872, 873, 874, 875, 876, 878, 879, 879 },// 黄山30 12+(+80 //
																// 66+619=685>>>685+66=751

			{ 1072, 1019, 1020, 1021, 1023, 1024, 1029, 1025, 831, 832, 833,
					98, 111, 144, 83, 47, 225, 25, 104, 349, 133, 243, 152,
					130, 330, 296,
					274,
					240,
					58,
					304,
					196,
					363,
					331,
					291,
					172, //
					29, 658, 684, 90, 217, 177, 263, 187, 171, 190, 136, 69,
					147, 82, 311, 202, 290, 220, 264, 32, 338, 70, 123, 107,
					95, 18, 24, 66, 72, 84, 96, 108, 142, 144, 155, 191, 192,
					198, 210, 216, 222, 228, 234, 246, 282, 294, 366, 430, 431,
					546, 553, 554, 555, 557, 614, 615, 616, 618, 621, 623, 624,
					625, 661, 662, 663, 664, 725, 749, 819, 824, 828, 852, 853,
					854, 855, 856, 865, 866, 877, 882, 895, 908, 929, 930, 931,
					932, 944, 1001, 1002, 1022, 1031, 556, 558, 559, 560, 561,
					562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573,
					574, 575, 576, 577, 580 },// 日本三垦，sanken 11+(+113
			{ 1083, 1069, 1070, 1071, 986, 987, 988, 989, 992, 993, 994, 789,
					790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801,
					802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813,
					814, 815, 816, 817, 818, 820, 821, 822, 823, 825, 826, 827,
					829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840,
					841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 857,
					858, 859, 860, 861, 862, 863, 864, 867, 868, 869, 870, 871,
					872, 873, 874, 875, 876, 878, 879, 879 }, // 宝创，Polytron
																// 10+(+80
			{ 1066, 1067, 1068, 770, 1071, 790, 791, 792, 988, 989, 992, 1043,
					1044, 1045, 30, 96, 108, 142, 144, 155, 191, 192, 198, 210,
					216, 222, 228, 234, 246, 282, 294, 366, 430, 431, 546, 553,
					554, 555, 557, 614, 615, 616, 618, 621, 623, 624, 625, 661,
					662, 663, 664, 725, 749, 819, 824, 828, 852, 853, 854, 855,
					856, 865, 866, 877, 882, 895, 908, 929, 930, 931, 932 }, // 爱华，Aiwa
																				// 15+(+56
			{ // 25+66=91 (91+388+63=542) (567）
			29, 658, 684, 90, 217, 177, 263, 187, 171, 190, 136, 69, 147, 82,
					311, 202, 290, 220, 264, 32, 338, 70, 123, 107, 95, 18, 24,
					66, 72, 84, 96, 108, 142, 144, 155, 191, 192, 198, 210,
					216, 222, 228, 234, 246, 282, 294, 366, 430, 431, 546, 553,
					554, 555, 557, 614, 615, 616, 618, 621, 623, 624, 625, 661,
					662, 663, 664, 725, 749, 819, 824, 828, 852, 853, 854, 855,
					856, 865, 866, 877, 882, 895, 908, 929, 930, 931, 932, 944,
					1001, 1002, 1022, 1031, 556, 558, 559, 560, 561, 562, 563,
					564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575,
					576, 577, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589,
					590, 591, 592, 593, 594, 594, 595, 596, 597, 598, 599, 600,
					601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612,
					613, 619, 620, 622, 626, 627, 628, 629, 630, 631, 632, 633,
					634, 635, 636, 637, 641, 642, 643, 644, 645, 646, 647, 648,
					649, 650, 651, 652, 653, 654, 655, 656, 659, 659, 660, 661,
					662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673,
					674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 685, 685,
					686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697,
					698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709,
					710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721,
					722, 723, 724, 726, 727, 728, 729, 730, 731, 732, 733, 734,
					735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746,
					747, 748, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759,
					760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771,
					772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783,
					784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795,
					796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807,
					808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 820,
					821, 822, 823, 825, 826, 827, 829, 830, 831, 832, 833, 834,
					835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846,
					847, 848, 849, 850, 851, 857, 858, 859, 860, 861, 862, 863,
					864, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 878,
					879, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889,
					890, 891, 892, 893, 894, 896, 897, 898, 899, 900, 901, 902,
					903, 904, 905, 906, 907, 909, 910, 911, 912, 913, 914, 915,
					916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927,
					928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939,
					940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951,
					952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963,
					964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975,
					976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987,
					988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999,
					1000, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011,
					1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021,
					1023, 1024, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1032,
					1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042,
					1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052,
					1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062,
					1063 }, // 其它品牌;29 //4位部分：63

	};
	private static List<int[]> mTVList = new ArrayList<int[]>();

	public static void Init() {
		for (int i = 0; i < mTVTables.length; i++) {
			mTVList.add(mTVTables[i]);
		}
	}

	public static int GetTVCount(int _index) throws Exception {
		return mTVList.get(_index).length;
	}

	public static List<int[]> GetTV() {
		return mTVList;
	}

	public static int GetData(int _row, int _col) throws Exception {
		return mTVList.get(_row)[_col];
	}
}
