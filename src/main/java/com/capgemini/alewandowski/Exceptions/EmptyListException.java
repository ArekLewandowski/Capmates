package com.capgemini.alewandowski.Exceptions;

public class EmptyListException extends Exception {


		/**
	 * 
	 */
	private static final long serialVersionUID = 774719231281573670L;

		public EmptyListException() {

		}
		
		public EmptyListException(String message) {
			super("No data! " + message);
		}

}
