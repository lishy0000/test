package com.succez;

import java.io.File;
import java.util.ArrayList;

public class Contents {
	File file;

	Contents(File file) {
		this.file = file;
	}

	ArrayList<File> arrlist() {
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

}