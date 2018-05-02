/**
 * 
 */
package com.apcoe.mototerm;

import org.apache.log4j.Logger;

/**
 * @author Rahul Vishvakarma
 *
 * @created May 2, 2018
 */
public class LoggerRepository implements Repository {

	final Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void write(String log) {
		logger.info(log);
	}

}