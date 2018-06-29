package com.yatish.springBootStart;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S8_GET_Method_Mapping_With_Parameter {

	/*
	 * If we want to send a parameter in the URL, then use {} for them
	 */
	@RequestMapping("/hi/{name}")		
	/*
	 * @PathVariable("parameter_present_in_url") annotation will map the parameter send in the URL, 
	 * to a variable. 
	 * 
	 * Here, it is mapping 'name' parameter to a variable 'myName'
	 * 
	 */
	public String getGreetingsMessage(@PathVariable("name") String myName) {	 
		return "hi " + myName;
		
	}
	
	
	
	/*
	 * So we have to specify URL parameter in @PathVariable() annotation compulsory?
	 * 
	 * No. If we would like to use the variable name, as same as that of the URL parameter, then
	 * No need of it see the example below
	 */
	
	@RequestMapping("/hello/{name}")
	/*
	 * we didnt write @PathVariable("name") here, but still it works, because the variable name is same
	 * as that of parameter name
	 */
	public String getHelloGreetingsMessage(@PathVariable String name) {	 
		return "hi " + name;
		
	}

}
