/**
 * 
 */
package com.apcoe.mototerm;

/**
 * Repository interface containing write method to persist the logs in impemented repository.
 * 
 * Implemented repository could be Database, File, Console, web service post call etc.
 * 
 * @author Rahul
 */
public interface Repository {

	/**
	 * To write the specified logs on implemented repository.
	 * 
	 * @param log Log fetched from mototerm.exe utility
	 */
	public void write(String log);
	
}