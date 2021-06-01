package com.cg.oss.serviceexception;


public class ICartServiceException extends Exception{
    private static final long serialVersionUID = -470180507998010368L;

 

    public ICartServiceException() {
        super();
    }

 

    public ICartServiceException(final String message) {
        super(message);
    }
}
 
