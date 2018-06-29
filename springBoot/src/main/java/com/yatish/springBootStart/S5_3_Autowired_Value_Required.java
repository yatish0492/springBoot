package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.TutorialSupportingCode.CustomAspectAnnotation;

/*
 * We can also specify, if we want a field to be initialized mandatorily during bean initialization using @Required annotation.
 * 
 * In this example, we have specified @Required on 'color' field of the 'Hair' class. During bean initialization of 'Hair' class, spring will check for its value, if it not able to find
 * a value for this field of either in 'yatish-config.xml' file or in any @Value attribute, then spring will throw an exception while starting the spring application and wont allow the
 * spring application to start.
 * 
 * NOTE: if we are using @Required annotation, then we have to specify @Value on the setter only. if we specify @Value on field it will throw an error saying value not initialized for
 * 		'color'. Reason why? Not sure. need to check!!!!
 * 
 * 
 */
@RestController
public class S5_3_Autowired_Value_Required {

	@Autowired
	public Hair obj;

	@RequestMapping("/RequiredField")
	public String getRequiredFieldValue() {
		return obj.getColor();
	}
 	
}

@Component
class Hair {
	// if you specify the @Value("black") instead of on setter method. then it will give error saying the 'color' property is not intialized. not sure why it will not be
	// initialized, if i give it here.
	String color;

	
	@CustomAspectAnnotation		// this is a custom annotoation refer to 'S14_8_CustomAnnotation' for more details.
	public String getColor() {
		return color;
	}

	@Required	//@Required has to be specified on setter only not on field
	@Value("black")
	public void setColor(String color) {
		this.color = color;
	}
	
}
