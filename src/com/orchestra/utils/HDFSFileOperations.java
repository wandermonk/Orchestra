package com.orchestra.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

import com.orchestra.interfaces.HDFSClient;

/**
 * Class to support HDFS File operations.
 * 
 */

public class HDFSFileOperations implements HDFSClient {

	private static final Logger LOGGER = Logger.getLogger(HDFSFileOperations.class);
	private static Configuration conf = new Configuration();

	/**
	 * The method creates a directory.
	 * @param dir the Directory to be created.
	 * @return void
	 * @throws Exception
	 */
	
	public void createDir(String dir) throws Exception {
		boolean res = FileSystem.get(conf).mkdirs(new Path(dir));
		if (!res) {
			LOGGER.info("Could not create the directory : " + dir);
		} else {
			LOGGER.error("Created the directory : " + dir);
		}

	}
	
	/**
	 * The method deletes a directory.
	 * @param dir the directory to be deleted.
	 * @return void
	 * @throws Exception
	 */

	public void deleteDir(String dir) throws Exception {
		boolean res = FileSystem.get(conf).delete(new Path(dir), true);
		if (!res) {
			LOGGER.info("Could not delete the file : " + dir);
		} else {
			LOGGER.error("Deleted the directory : " + dir);
		}
	}
	
	/**
	 * The method checks if the argument is a directory.
	 * @param dirPath the path of the directory.
	 * @return boolean
	 * @throws 
	 */

	public boolean isDir(String dirPath) {
		try {
			return FileSystem.get(conf).isDirectory(new Path(dirPath));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * The method checks if the argument is a file.
	 * @param filePath the path of the file.
	 * @return boolean
	 * @throws 
	 */

	public boolean isFile(String filePath) {
		try {
			return FileSystem.get(conf).isFile(new Path(filePath));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	/**
	 * The method checks copies the file or data from local to hdfs.
	 * @param localpath the path of the file in the local.
	 * @param hdfspath the path or location in the hdfs.
	 * @return void
	 * @throws Exception
	 */
	
	public void copyFromLocal(String localpath, String hdfspath) throws Exception {
		Path localPath = new Path(localpath);
		Path hdfsPath = new Path(hdfspath);
		FileSystem.get(conf).copyFromLocalFile(localPath, hdfsPath);

	}
	
	/**
	 * The method checks copies the file or data from hdfs to local.
	 * @param hdfspath the path or location in the hdfs.
	 * @param localpath the path of the file in the local.
	 * @return void
	 * @throws Exception
	 */

	public void copyToLocal(String hdfspath, String localpath) throws Exception {
		Path hdfsPath = new Path(hdfspath);
		Path localPath = new Path(localpath);
		FileSystem.get(conf).copyToLocalFile(hdfsPath, localPath);

	}
	
	/**
	 * The method checks moves the file or data from source to destination.
	 * @param source the source location 
	 * @param destination the destination location
	 * 
	 * @return void
	 * @throws Exception
	 */

	public void move(String source, String destination) throws Exception {
		Path sourcePath = new Path(source);
		Path destinationPath = new Path(destination);
		FileSystem.get(conf).moveFromLocalFile(sourcePath, destinationPath);
	}
}