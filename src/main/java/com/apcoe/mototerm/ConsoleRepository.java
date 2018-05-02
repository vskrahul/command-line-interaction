/**
 * 
 */
package com.apcoe.mototerm;

/**
 * @author Rahul Vishvakarma
 *
 * @created May 1, 2018
 */
public class ConsoleRepository implements Repository {

	@Override
	public void write(String log) {
		System.out.println(log);
	}

}