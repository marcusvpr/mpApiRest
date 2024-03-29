package com.mpxds.apirest.controller.exception;

import java.io.Serializable;

public class MpFieldMessage implements Serializable {
	//
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	public MpFieldMessage() { } 

	public MpFieldMessage(String fieldName, String message) {
		//
		super();
		
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() { return fieldName; }
	public void setFieldName(String fieldName) { this.fieldName = fieldName; }

	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

}
