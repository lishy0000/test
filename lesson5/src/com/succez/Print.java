package com.succez;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Print extends Tool {
	public File file;

	public Print(File file) {
		this.file = file;
	}

	public Print() {

	}

	public static String m(File file) throws IOException {

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
		for (int i = 0; i < arrlist(file).size(); i++) {
			outstream.println("<p><a href=\"");
			outstream.print("http://localhost:8080/");
			outstream.print(road((File) arrlist(file).get(i)));
			outstream.print("\"</a><img src=\"");
			String f = road((File) arrlist(file).get(i));
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
			outstream.print(arrlist(file).get(i).getName());
			outstream.println("</a></p>");
		}
		outstream.println("<p><a href=\"");
		outstream.print("http://localhost:8080/");
		outstream.print("web/LoginOut.html");
		outstream.print("\">注销");
		outstream.println("</a></p>");
		outstream.println("</body></html>");

		if (outstream != null)
			outstream.close();

		byte[] k = file2buf(file3); // 简单转码
		String k1 = new String(k, "UTF-8");
		return k1;
	}

	private static byte[] file2buf(File fobj) throws IOException {
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
	private static String road(File file) {
		String k = file.getAbsolutePath();
		k = k.replace('\\', '/');
		k = k.replaceAll("//", "/");
		String t = k.substring(k.indexOf('/') + 1);
		k = k.substring(0, k.indexOf('/'));
		k = k.concat(t);
		return k;
	}

	private static ArrayList<File> arrlist(File file) {
		ArrayList<File> list = new ArrayList<File>();

		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				list.add(files[i]);
			}
			return list;
		} else
			return null;
	}

	public static String Printm() throws Exception {

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
		for (int i = 0; i < getAllUser().size(); i++) {
			outstream.println("<p><a href=\"");
			outstream.print("http://localhost:8080/");
			outstream.print("web/Chang.html?name=");
			User user = getAllUser().get(i);
			outstream.print(user.getName());
			outstream.print("\">修改");
			outstream.println("</a>");
			outstream.println("<br><a href=\"");
			outstream.print("http://localhost:8080/");
			outstream.print("web/Drop.html?name=");
			outstream.print(user.getName());
			outstream.print("\">删除");
			outstream.println("</a>");
			outstream.println("<br>name:");
			outstream.print(user.getName());
			outstream.println("<br>password:");
			outstream.print(user.getPassword());
			outstream.println("<br>age:");
			outstream.print(user.getAge());
			outstream.println("<br>sex:");
			outstream.print(user.getSex());
			outstream.println("<br>email:");
			outstream.print(user.getEmail());
			outstream.println("<br>phone:");
			outstream.print(user.getPhone());
		}
		outstream.println("</body></html>");

		if (outstream != null)
			outstream.close();
		byte[] k = file2buf(file3); // 简单转码
		String k1 = new String(k, "UTF-8");
		return k1;
	}

	public static String Printindex(String fiter) throws Exception {

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
		outstream
				.println("<body><h1 align=\"center\">My web </h1><p align=\"center\"> 主页 </p>");

		outstream.println("<p><a href=\"");
		outstream.print("http://localhost:8080/");
		outstream.print("web/Chang.html");
		outstream.print("\">修改");
		outstream.println("</a></p>");
		outstream.println("<p>name:");
		User user1 = getUser(fiter);
		outstream.print(user1.getName());
		outstream.println("<br>age:");
		outstream.print(user1.getAge());
		outstream.println("<br>sex:");
		outstream.print(user1.getSex());
		outstream.println("<br>email:");
		outstream.print(user1.getEmail());
		outstream.println("<br>phone:");
		outstream.print(user1.getPhone());
		outstream.println("<p><a href=\"");
		outstream.print("http://localhost:8080/");
		outstream.print("web/LoginOut.html");
		outstream.print("\">注销");
		outstream.println("</a></p>");
		if (getUser(fiter).getisAdmin()) {
			outstream.println("<p><a href=\"");
			outstream.print("http://localhost:8080/");
			outstream.print("web/Print.html");
			outstream.print("\">管理所有用户");
			outstream.println("</a></p>");
		}
		outstream
				.println("<p><a href=\"http://localhost:8080/F:\"</a><img src=\"dir.png\" width=\"26\" ,height=\"26\"/>");
		outstream
				.println("F盘</a> </p><p><a href=\"http://localhost:8080/E:\"</a><img src=\"dir.png\" width=\"26\" ,height=\"26\"/>");
		outstream
				.println("E盘</a> </p><p><a href=\"http://localhost:8080/C:\"</a><img src=\"dir.png\" width=\"26\" ,height=\"26\"/>");
		outstream.println("C盘</a></p><p>D盘暂时不可访问。</p>");

		outstream.println("</body></html>");

		if (outstream != null)
			outstream.close();
		byte[] k = file2buf(file3); // 简单转码
		String k1 = new String(k, "UTF-8");
		return k1;
	}
}
