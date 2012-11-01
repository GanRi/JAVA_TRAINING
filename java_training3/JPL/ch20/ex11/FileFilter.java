package ch20.ex11;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {
	private String suffix;

	public void setPrefix(String prefix) {
		this.suffix = prefix;
	}

	public boolean accept(File dir, String name) {
		if (new File(dir, name).getName().endsWith(suffix)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		File dir = new File("JPL/ch20/ex11");
		FileFilter filter = new FileFilter();
		filter.setPrefix("java");
		String[] files = dir.list(filter);
		System.out.println(files.length + " file(s)");
		for (String file : files)
			System.out.println(file);
	}
}
