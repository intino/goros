package org.monet.space.kernel.bpi.java.locator;

import io.intino.alexandria.logger.Logger;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PackageReader {

	private String packagePath;
	private Set<String> classnames;

	public PackageReader(String classpathRoot) {
		this.packagePath = classpathRoot;
	}

	public Set<String> read() {
		Logger.info("Reading classes in businessmodel");
		this.loadClassNames(packagePath);
		Logger.info("Number of classes found: " + classnames.size());
		return classnames;
	}

	private void loadClassNames(String packagePath) {
		this.classnames = new HashSet<>();
		File directory = new File(packagePath);
		readDirectory(directory);
	}

	private void readDirectory(File dir) {
		File[] filenames = dir.listFiles(file -> (file.isDirectory() && !file.getName().startsWith(".")) || file.getName().endsWith(".class"));

		if (filenames == null) {
			Logger.error("Could not read directory " + dir.getAbsolutePath());
			return;
		}

		for (File filename : filenames) {
			if (filename.isFile())
				this.classnames.add(toPackageName(filename.getAbsolutePath(), this.packagePath));
			else
				readDirectory(filename);
		}
	}

	private static String toPackageName(String absolutePath, String packagePath) {
		String result = absolutePath.replace(packagePath, "");
		result = result.replace("\\", "##").replace("/", "##").replace(".class", "").replace("##", ".");
		return result.startsWith(".") ? result.substring(1) : result;
	}

//	public static void main(String[] args) {
//		String packagePath = "C:\\Users\\sfalcon\\projects\\modelos\\ViasyObras\\Coordinacion\\bin\\classes";
//		String className = "C:\\Users\\sfalcon\\projects\\modelos\\ViasyObras\\Coordinacion\\bin\\classes\\coordinacion\\analytics\\dashboardincidencias\\$Definition$.class";
//		System.out.println(toPackageName(className, packagePath));
//	}
}
