package com.succez;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Print {
	static File file;

	public Print(File file) {
		Print.file = file;
	}

	public static String m() throws IOException {

		File file3 = new File("File Cache");

		if (file3.exists())
			file3.delete();
		PrintStream outstream = null;
		outstream = new PrintStream(file3);
		outstream.println("<html>");
		outstream.println("<head>");
		outstream
				.println("<meta http-equiv=\"Content-Type\" content=\"text/html\";charset=utf-8/>");
		outstream.println("<title>webserver</title></head>");
		outstream.println("<body>");
		outstream.println("<h1 align=\"center\">My web </h1>");
		outstream.println("<p><a href=\"/index.html\">返回主页</a></p>");
		Contents ct = new Contents(file);
		for (int i = 0; i < ct.arrlist().size(); i++) {
			System.out.println(ct.arrlist().size() + "jlsdhf" + i);
			outstream.println("<p><a href=\"");
			outstream.print("http://localhost:8080/");
			outstream.print(road((File) ct.arrlist().get(i)));
			outstream.print("\"</a><img src=\"");
			String f = road((File) ct.arrlist().get(i));
			File k = new File(f);
			String[] filenames = k.list();
			if (f.endsWith(".txt"))
				f = "txt.png";
			else if (filenames != null)
				f = "dir.png";
			else
				f = "ioc.png";
			outstream.print(f);
			outstream.print("\" width=\"26\" ,height=\"26\"/>");
			outstream.print(ct.arrlist().get(i).getName());
			outstream.println("</a></p>");
			
		}
		outstream.println("</body></html>");

		if (outstream != null)
			outstream.close();

		byte[] k = file2buf(file3); // 简单转码
		String k1 = new String(k, "UTF-8");
		return k1;
	}

	public static byte[] file2buf(File fobj) throws IOException {
		// 文件转换为字节数组以便转码
		byte[] b = new byte[(int) (fobj.length() * 1.1)];
		BufferedInputStream input = null;
		try {
			input = new BufferedInputStream(new FileInputStream(fobj));
			input.read(b);
		} catch (FileNotFoundException j) {
			b = null;
			j.printStackTrace();

		} finally {
			if (input != null)
				input.close();
		}
		return b;
	}

	// 路径修改
	static String road(File file) {
		String k = file.getAbsolutePath();
		k = k.replace('\\', '/');
		k = k.replaceAll("//", "/");
		String t = k.substring(k.indexOf('/') + 1);
		k = k.substring(0, k.indexOf('/'));
		k = k.concat(t);
		System.out.println(k);
		return k;
	}
}