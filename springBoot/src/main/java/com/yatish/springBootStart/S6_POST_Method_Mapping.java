package com.yatish.springBootStart;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Student;


@RestController		//'RestController' annotation tells the spring application context, that The URL handlers are being written here in this class as methods
public class S6_POST_Method_Mapping {
	
	@RequestMapping(method=RequestMethod.POST,value="/postMethod")  // we can give property for the request mapping. If properties are not given, but only string is given, then GET will be considered implicitly d
	public String postMethodHandleExample(@RequestBody Student student) {		// we can access the body of the POST call using the '@RequestBody' annotation
		System.out.println(student.toString());
		return "Success";
	}

}
