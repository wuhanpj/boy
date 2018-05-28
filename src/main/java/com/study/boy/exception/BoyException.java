package com.study.boy.exception;

import enums.ResultEnums;

public class BoyException extends RuntimeException{
	
	private String code;

	public BoyException(ResultEnums enums) {
		super(enums.getMessage());
		this.code = enums.getCode();
	}
	
	public BoyException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
