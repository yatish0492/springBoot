package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Male;

@RestController
public class S4_1_AutoWired_xml_bean {

	/*
	 * Male class is not defined as bean using annotations like @Component, @Service etc.
	 * Male Class is defined as bean in xml file --> src/main/resources/yatish-config.xml
	 * 
	 * Here, the Male class bean is created without initializing the age property. if you see, yatish-config.xml, the bean declaration is as follows,
	 *  "<bean class="com.yatish.pojos.Male"/>"
	 *  
	 *  The bean is created with default constructor and property 'age' is not initialized while bean creation.
	 */
	@Autowired		
	private Male obj;

	@RequestMapping("/MaleAge")
	public String printAge() {
		obj.setAge(23);
		return obj.printAge();
	}

}
