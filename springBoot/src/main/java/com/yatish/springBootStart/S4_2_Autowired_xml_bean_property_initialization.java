package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Female;

@RestController
public class S4_2_Autowired_xml_bean_property_initialization {

	/*
	 * Female class is not defined as bean using annotations like @Component, @Service etc.
	 * Female Class is defined as bean in xml file --> src/main/resources/yatish-config.xml
	 * 
	 * Here, the Female class bean is created with initializing the name property. if you see, yatish-config.xml, the bean declaration is as follows,
	 *  "<bean class="com.yatish.pojos.Female">
    			<property name="name" value="Ramya"/>
    		</bean>"
	 *  
	 *  The bean is created with default constructor and property 'name' is initialized while bean creation using setter method for 'name' property.
	 */
	@Autowired
	private Female obj;

	@RequestMapping("/FemaleName")
	public String printAge() {
		return obj.printName();
	}
}
