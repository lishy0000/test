package com.succez;

import java.util.InputMismatchException;
import java.util.Scanner;

//16进制转换为字符串

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
