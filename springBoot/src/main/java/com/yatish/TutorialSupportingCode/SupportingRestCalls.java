package com.yatish.TutorialSupportingCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportingRestCalls {

	@Autowired
	ExceptionAndNoException obj;
	
	@RequestMapping("/noException")
	public String noExceptionMethodCall() {
		obj.executesWithoutException();
		return "There was not exception thrown. you are seeing succesful response";
	}
	
	@RequestMapping("/Exception")
	public String ExceptionMethodCall() throws Exception {
		obj.executesWithThrowingException();
		return "There was exception thrown. you are seeing non-succesful response";
	}

}

@Component
class ExceptionAndNoException {
	
	public void executesWithoutException() {
		
	}
	
	public void executesWithThrowingException() throws Exception {
		throw new Exception();
	}
}
