package com.cg.oss.serviceexception;



public class ICustomerServiceException extends Exception {

	 private static final long serialVersionUID = -470180507998010368L;

	 public ICustomerServiceException() {
	super();
	}

	 public ICustomerServiceException(final String message) {
	super(message);
	}
	}
