package com.succez;

import java.util.InputMismatchException;
import java.util.Scanner;

class intToHex {
	boolean exp = true;
	int s[] = new int[9];
	int j = 0;
	static char o[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };
	String reresult;

	intToHex(int n) {
		if(n!=Integer.MIN_VALUE){
		int i = 0;
		StringBuffer k = new StringBuffer();
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
		for (int j = 0; j < i; j++) {
			k.append(o[s[i - j - 1]]);
		}
		reresult = k.toString();
	}
	else reresult="80000000";
}
}
public class lesson2 {
	public static void main(String[] args) {

		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			intToHex t = new intToHex(n);
			System.out.println(t.reresult);
		
			sc.close();
		} catch (InputMismatchException In) {
			System.out.println("你输入的数有误！");
		}

	}

}