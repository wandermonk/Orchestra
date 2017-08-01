package com.orchestra.interfaces;

/**
 * Interface to perform file operations on HDFS.
 * 
 * Provides public methods as below
 * 
 * methods to create,delete files and directories.
 * methods to read,write,move,copy files and directories. 
 * 
 */

public interface HDFSClient {

	/**
	 * The method creates a directory.
	 * @param dir the Directory to be created.
	 * @return void
	 * @throws Exception
	 * 
	 */
	public void createDir(String dir) throws Exception;

	/**
	 * The method deletes a directory.
	 * @param dir the directory to be deleted.
	 * @return void
	 * @throws Exception
	 */
	public void deleteDir(String dir) throws Exception;

	/**
	 * The method checks if the argument is a directory.
	 * @param dirPath the path of the directory.
	 * @return boolean
	 * @throws 
	 */
	public boolean isDir(String dirPath);

	/**
	 * The method checks if the argument is a file.
	 * @param filePath the path of the file.
	 * @return boolean
	 * @throws 
	 */

	public boolean isFile(String filePath);

	/**
	 * The method checks copies the file or data from local to hdfs.
	 * @param localpath the path of the file in the local.
	 * @param hdfspath the path or location in the hdfs.
	 * @return void
	 * @throws Exception
	 */
	public void copyFromLocal(String localpath, String hdfspath) throws Exception;

	/**
	 * The method checks copies the file or data from hdfs to local.
	 * @param hdfspath the path or location in the hdfs.
	 * @param localpath the path of the file in the local.
	 * @return void
	 * @throws Exception
	 */
	public void copyToLocal(String hdfspath, String localpath) throws Exception;
	
	/**
	 * The method checks moves the file or data from source to destination.
	 * @param source the source location 
	 * @param destination the destination location
	 * 
	 * @return void
	 * @throws Exception
	 */
	public void move(String source, String destination) throws Exception;

}
