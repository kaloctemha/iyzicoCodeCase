package com.iyzico.challenge.exception;

public class InsufficientStockException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5111843369232613799L;
	
	public InsufficientStockException(String msg) {
		super(msg);
	}

}
