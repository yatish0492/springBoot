package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Car;

@RestController
public class S4_3_Autowired_xml_bean_property_initialization_constructor {

	/*
	 * Car class is not defined as bean using annotations like @Component, @Service etc.
	 * Car class is defined as bean in xml file --> src/main/resources/yatish-config.xml
	 * 
	 * Here, the Car class bean is created with initializing the model,company properties but not yearOfMake. if you see, yatish-config.xml, the bean declaration is as follows,
	 *  "<bean class="com.yatish.pojos.Car">
    			<constructor-arg value="Ritz"/>
    			<constructor-arg value="Maruti"/>
    		</bean>"
	 *  
	 *  The bean is created with constructor 'Car(String model,String company)' and property 'model' and 'company' is initialized while the bean is created.
	 *  
	 *  To check about how to initialize 'yearOfMake' please read the description in 'yatish-config.xml' above the '<bean' tag
	 */
	@Autowired		
	private Car obj;

	@RequestMapping("/CarModel")
	public String printAge() {
		return obj.printCarModel();
	}

}
