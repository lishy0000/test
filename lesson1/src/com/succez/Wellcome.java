package com.succez;

import java.io.*;

public class Wellcome {

	public Wellcome() {
	}

	/** * ���ļ�����ת����byte���鷵��,����ļ������ڻ��߶�����󷵻�null 
	 * @throws IOException */
	public static byte[] file2buf(File fobj) throws IOException {
	byte[] result = new byte[(int) fobj.length()];
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(fobj));
		try{
			int p = -1;
			while((p = input.read(result))!=-1){
				
			}
			if(p == -1){
				throw new RuntimeException("����");
			}
			return result;
		}finally{
			input.close();
		}
	}
//		ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
//		try {
//			BufferedInputStream input = new BufferedInputStream(
//					new FileInputStream(fobj));
//			try {
//				byte[] buff = new byte[1024];
//				int len = -1;
//				while((len = input.read(buff,len,1024))!=-1){
//					bos.write(buff, 0, len);
//				}
//				return bos.toByteArray();
//			} finally {
//				input.close();
//			}
//		} finally {
//			bos.close();
//		}
//	}
//		
//	FileInputStream input = null;
//		try {
//			fobj.length();
//			input = new FileInputStream(fobj);
//			byte[] b = new byte[10000]; // �����֪���ļ��ж��������ô�һ�㡣
//			try {
//				int length = input.read(b); // length��ʾ���ļ�ʵ���ж����ֽڡ�
//				System.out.println("uuuuuuuuuuuu" + length);
//				for (int i = 0; i < length; i++) { // ���ļ���ʵ���ֽ�������ӡ������
//					System.out.println(b[i]);
//
//				}

				// �����ǰ���������ֽ����ļ�����ʽ���������������ڵ����ϡ�

//				File fileOut = new File("F:\\b.txt");
//				if (fileOut.exists()) { // ���F������ͬ���ļ����־Ͱ���ɾ����û�еĻ����½���
//					fileOut.delete();
//				}
//				FileOutputStream output = null;
//				output = new FileOutputStream(fileOut);
//				output.write(b, 0, length); // ���ֽ��������ʵ����Ч�ֽ�д�����
//				output.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();




	public static void main(String[] args) 
{
	
try {
		// ������ļ������ֽ��������档
		File file = new File("F:\\A.txt");
		byte[] bytes = file2buf(file);
		
		System.out.println(bytes);

		
} catch (Exception e) {

	e.printStackTrace();
}

	

}
	
}	
