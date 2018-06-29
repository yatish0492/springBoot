package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_10_Bean {

	/*
	 * @Bean is used to declare a bean for spring to instantiate. like it does the same thing as that of @Component/@Service or using configuration xml file.
	 * 
	 * we had @Component/@Scan and configuration xml file, whey the hell was @Bean introduced?
	 * This was not introduced by java as part of JSR-250, not by spring. brfore spring let annotaion support, java thought it would be tough for user to configure everything in xml file 
	 * and they only released @Bean annotation then in later releases spring released annotaions like @Component etc.
	 * 
	 * here, we have not given @Bean on the 'Nail' class how is it working. how did spring create a bean of 'Nail'?
	 * Actually, the bean creation should be done in the main configuration class file. i.e. the class file with @Configuration file.
	 * 
	 * Refer to 'S1_SpringBootApplication.java', search for '@Bean' annotation.
	 * 
	 */
	@Autowired
	Nail obj;
	
	@RequestMapping("/getBeanAnnotationObject")
	public String getBeanAnnotation() {
		return obj.color;
	}

}

class Nail {
	
	Nail() {
		color = "white";
	}
	
	String color;
}


