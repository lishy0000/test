package com.succez;

import java.io.*;

//���ļ�����ת����byte���鷵��,����ļ������ڻ��߶�����󷵻�null 
public class lesson1 {

	public static byte[] file2buf(File fobj) throws IOException {
		// ���ļ�����ת����byte���鷵��,����ļ������ڻ��߶�����󷵻�null
		// byte[] result = new byte[(int) fobj.length()];
		// BufferedInputStream input = new BufferedInputStream(new
		// FileInputStream(fobj));
		// try{
		// int p = -1;
		// while((p = input.read(result))!=-1){
		//
		// throw new Exception("����");
		// }
		// }
		// catch (Exception In)
		// {
		// System.out.println("��������");
		// }
		// finally{
		//
		// input.close();
		// }return result;
		// }
		// ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
		// try {
		// BufferedInputStream input = new BufferedInputStream(
		// new FileInputStream(fobj));
		// try {
		// byte[] buff = new byte[1024];
		// int len = -1;
		// while((len = input.read(buff,len,1024))!=-1){
		// bos.write(buff, 0, len);
		// }
		// return bos.toByteArray();
		// } finally {
		// input.close();
		// }
		// } finally {
		// }
		// }
		byte[] b = new byte[(int) fobj.length()];
		try {
			BufferedInputStream input = new BufferedInputStream(
					new FileInputStream(fobj));
			input.read(b);
			// length��ʾ���ļ�ʵ���ж����ֽ�
			// System.out.println("uuuuu" + (int) fobj.length());
			// for (int i = 0; i < (int) fobj.length(); i++) { //
			// ���ļ���ʵ���ֽ�������ӡ������
			// System.out.println(b[i]);
			// }
			if (input != null)
				input.close();
		} catch (FileNotFoundException j) {
			b = null;
			j.printStackTrace();

		} finally {
		}
		return b;
	}

	// �����ǰ���������ֽ����ļ�����ʽ���������������ڵ����ϡ�
	public static void bytefile(byte[] b) throws IOException {
		File file3 = new File("test1file3.txt");
		if (file3.exists()) { // ���F������ͬ���ļ����־Ͱ���ɾ����û�еĻ����½���
			file3.delete();
		}
		FileOutputStream output = null;
		output = new FileOutputStream(file3);
		output.write(b, 0, b.length); // ���ֽ��������ʵ����Ч�ֽ�д�����
		if (output != null)
			output.close();
	}

	public static void main(String[] args) {

		try {
			// ������ļ������ֽ��������档
			File file = new File("test1file3.txt");
			byte[] bytes = file2buf(file);
			bytefile(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
