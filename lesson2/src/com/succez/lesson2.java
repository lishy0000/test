package com.succez;

import java.util.InputMismatchException;
import java.util.Scanner;

//16����ת��Ϊ�ַ���

public class lesson2 {
	public static void main(String[] args) {

		System.out.println("������һ��������");
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			intToHex t = new intToHex(n);
			System.out.println(t.reresult);

			sc.close();
		} catch (InputMismatchException In) {
			System.out.println("�������������");
		}

	}

}
