package com.yatish.springBootStart;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Student;

@RestController
public class S7_PUT_Method_Mapping {

	/*
	 * Same as 'S6_POST_Method_Mapping.java' only method replaced to PUT
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/postMethod")  // we can give property for the request mapping. If properties are not given, but only string is given, then GET will be considered implicitly d
	public String postMethodHandleExample(@RequestBody Student student) {		// we can access the body of the POST call using the '@RequestBody' annotation
		System.out.println(student.toString());
		return "Success";
	}

}
