package com.pms.usermanagement.model;

public class Responses<T> {
	
	
	    private int statusCode;
	    private T data;
	    private String message;

	    public Responses(int statusCode, T data, String message) {
	        this.statusCode = statusCode;
	        this.data = data;
	        this.message = message;
	    }

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	    
	}



