package com.succez;

import java.io.*;

//将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null 
public class lesson1 {

	public static byte[] file2buf(File fobj) throws IOException {
		// 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
		// byte[] result = new byte[(int) fobj.length()];
		// BufferedInputStream input = new BufferedInputStream(new
		// FileInputStream(fobj));
		// try{
		// int p = -1;
		// while((p = input.read(result))!=-1){
		//
		// throw new Exception("错误");
		// }
		// }
		// catch (Exception In)
		// {
		// System.out.println("发生错误");
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
			// length表示此文件实际有多少字节
			// System.out.println("uuuuu" + (int) fobj.length());
			// for (int i = 0; i < (int) fobj.length(); i++) { //
			// 把文件的实际字节量都打印出来。
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

	// 还有是把数组里的字节以文件的形式读出来，并保存在电脑上。
	public static void bytefile(byte[] b) throws IOException {
		File file3 = new File("test1file3.txt");
		if (file3.exists()) { // 如果F盘有相同的文件名字就把它删除。没有的话就新建。
			file3.delete();
		}
		FileOutputStream output = null;
		output = new FileOutputStream(file3);
		output.write(b, 0, b.length); // 把字节数组里的实际有效字节写入流里。
		if (output != null)
			output.close();
	}

	public static void main(String[] args) {

		try {
			// 任意的文件读到字节数组里面。
			File file = new File("test1file3.txt");
			byte[] bytes = file2buf(file);
			bytefile(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
