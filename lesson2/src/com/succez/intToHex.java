package com.succez;

//16进制转换为字符串
public class intToHex {

	static final char o[] = new char[] { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	String reresult;

	// 16进制转换为字符串
	intToHex(int n) {
		boolean exp = true;
		int s[] = new int[9];
		if (n != Integer.MIN_VALUE) {
			int i = 0;
			StringBuilder k = new StringBuilder();
			if (n < 0) {
				n = -n;
				k.append("-");
			}
			while (exp) { /* 数组化为16进制 */
				s[i] = n % 16;
				n = n / 16;
				i++;
				if (n == 0)
					exp = false;
			}
			for (int j1 = 0; j1 < i; j1++) {
				k.append(o[s[i - j1 - 1]]);
			}
			reresult = k.toString();
		} else
			reresult = "80000000";
	}

}
