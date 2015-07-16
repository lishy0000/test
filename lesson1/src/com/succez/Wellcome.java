package com.succez;

import java.io.*;

public class Wellcome {

	public Wellcome() {
	}

	/** * 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null 
	 * @throws IOException */
	public static byte[] file2buf(File fobj) throws IOException {
	byte[] result = new byte[(int) fobj.length()];
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(fobj));
		try{
			int p = -1;
			while((p = input.read(result))!=-1){
				
			}
			if(p == -1){
				throw new RuntimeException("错误");
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
//			byte[] b = new byte[10000]; // 如果不知道文件有多大，最好设置大一点。
//			try {
//				int length = input.read(b); // length表示此文件实际有多少字节。
//				System.out.println("uuuuuuuuuuuu" + length);
//				for (int i = 0; i < length; i++) { // 把文件的实际字节量都打印出来。
//					System.out.println(b[i]);
//
//				}

				// 还有是把数组里的字节以文件的形式读出来，并保存在电脑上。

//				File fileOut = new File("F:\\b.txt");
//				if (fileOut.exists()) { // 如果F盘有相同的文件名字就把它删除。没有的话就新建。
//					fileOut.delete();
//				}
//				FileOutputStream output = null;
//				output = new FileOutputStream(fileOut);
//				output.write(b, 0, length); // 把字节数组里的实际有效字节写入流里。
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
		// 任意的文件读到字节数组里面。
		File file = new File("F:\\A.txt");
		byte[] bytes = file2buf(file);
		
		System.out.println(bytes);

		
} catch (Exception e) {

	e.printStackTrace();
}

	

}
	
}	
