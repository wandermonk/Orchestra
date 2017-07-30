package com.orchestra.utils;

import static java.nio.file.StandardCopyOption.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	public boolean isDir(String dirPath) {
		Path path = Paths.get(dirPath);
		return Files.isDirectory(path);
	}

	public boolean isFile(String filePath) {
		Path path = Paths.get(filePath);
		return Files.isRegularFile(path);
	}

	public String readFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public void copy(String sourcePath, String destinationPath) throws IOException {
		Path source = Paths.get(sourcePath);
		Path destination = Paths.get(destinationPath);
		Files.copy(source, destination, REPLACE_EXISTING);
	}

	public void move(String sourcePath, String destinationPath) throws IOException {
		Path source = Paths.get(sourcePath);
		Path destination = Paths.get(destinationPath);
		Files.move(source, destination, REPLACE_EXISTING);
	}

	public void createDir(String dir) throws IOException {
		Path path = Paths.get(dir);
		Files.createDirectory(path);
	}

	public void deleteFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		Files.delete(path);
	}

	public void deleteDir(String dir) throws IOException {
		Path path = Paths.get(dir);
		Files.delete(path);
	}

}
