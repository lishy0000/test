package com.succez;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

public class Tool extends UserManager{
 public byte[] filetobyte(File file)throws Exception {
		
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int len = (int) file.length();
		byte buf[] = new byte[len];
			in.readFully(buf);
		
			in.close();
			return buf;
}
public String roadtoroad(String f)throws Exception{
	
	if (f.endsWith("txt.png"))
		return "web\\txt.png";
	if (f.endsWith("ioc.png"))
		return "web\\ioc.png";
	if (f.endsWith("dir.png"))
		return "web\\dir.png";
	if (f.equals("") || f.equalsIgnoreCase("index.html"))
		return "web\\index.html";

	File file = new File(f);
	if (file.exists())
		return f;
	else
		return "web\\error.html";

}

}
