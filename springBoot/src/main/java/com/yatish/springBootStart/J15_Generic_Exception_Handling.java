package com.yatish.springBootStart;

import java.io.FileNotFoundException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 *  What is Generic Exception Handling?
 *  Usually, if there is any exception occurring from the rest handler which is not handled, then that exception will be sent to the UI.
 *  eg: Consider UI makes a REST call '/getAbc' and in the REST handler of '/getAbc' if nullPointer exception occurs which is not catched by us due to poor programming, in this case the same exception
 *  		will be sent to the UI, the UI will show 'NullPointerException' how bad is it for user so we have give proper error message like 'Internal Server Error' etc.
 *  In Spring Boot, It provides default exception handler. If there is any exception thrown in any REST handler which is not catched by us. then that will be catched by springboot and it will throw
 *  standard Error message instead of throwing 'NullPointerException' etc. when there is an exception thrown by REST handler.
 *  
 *  So SpringBoot give some standard error message if there is a exception thrown but consider you want to configure it manually, can that be done?
 *  Yes!!!
 *  spring/Springboot provides one more annotation called @ControllerAdvice, we have to give this at class level and the class should extend 'ResponseEntityExceptionHandler' class and inside it,
 *  we have to define the methods with @ExceptionHandler annotation and the type of annotation that will occur within this annotation so that whenever this kind of annotation occurs, then the
 *  method will be executed and whatever the method returned will be returned to the UI.
 *  
 *  
 */

@ControllerAdvice
@RestController
public class J15_Generic_Exception_Handling extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception e,WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	public final ResponseEntity<Object> handleFileNotFoundExceptions(Exception e,WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
}
