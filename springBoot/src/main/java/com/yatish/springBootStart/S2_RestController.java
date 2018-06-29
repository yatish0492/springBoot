package com.yatish.springBootStart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController			//'RestController' annotation tells the spring application context, that The URL handlers are being written here in this class as methods
public class S2_RestController {

	/*
	 * Running this program doesnt help, you need to run the 'S1_SpringBootApplication.java' file as it has got the 'SpringApplication.run()', that will scan this class and registers the
	 * RestController. 
	 */
	
	
	/*
	 * 'RequestMapping' annotation, will say to sping application context that, if there is an URL with '/hello', then execute this function
	 * 
	 * By Default, it takes 'GET' as the method
	 */
	@RequestMapping("/hi")
	public String sayHi() {				//The function name can be anything, nothing like it should be same as the request map
		return "Hi";
	}
	
}
