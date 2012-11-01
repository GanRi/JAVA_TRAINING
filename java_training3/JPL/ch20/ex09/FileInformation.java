package ch20.ex09;

import java.io.File;
import java.io.IOException;

public class FileInformation {

	static void showFileInformation(String path) {
		try {
			File file = new File(path);
			System.out.println("absolute path:" + file.getAbsolutePath());
			System.out.println("canonical path:" + file.getCanonicalPath());
			System.out.println("name:" + file.getName());
			System.out.println("can read:" + file.canRead());
			System.out.println("can write:" + file.canWrite());
			System.out.println("freespace:" + file.getFreeSpace());
			System.out.println("parent:" + file.getParent());
			System.out.println("path:" + file.getPath());
			System.out.println("total space:" + file.getTotalSpace());
			System.out.println("usable space:" + file.getUsableSpace());
			System.out.println("last modified:" + file.lastModified());
			System.out.println("path separator:" + file.pathSeparator);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		showFileInformation("JPL/ch20/ex05/testfile.txt");
	}

}
