package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_6_Autoiwred_Required_property {

	/*
	 * when spring sees @Autowired annotation, it will try to find the bean of that type, here it is 'EyeLash' and wire it. if it is not able to find the bean either in configuration xml
	 * or through @Component/@Service etc. then it will throw up an exception during spring application startup itself saying, it cannot find the bean. Hence we cannot start the spring 
	 * application until a bean is declared for 'EyeLash'.
	 * 
	 * Is there any way we can start the spring application, even though if few bean are missing to autowire?
	 * Yes!!!
	 * @Autowired has one property called 'required'. by default this property will be set to 'true'. If we set this property as false. it will let us start the spring application without
	 * throwing an exception and blocking the spring application start.
	 * eg: @Autowired(required=false)
	 * 		in this case, as you can see we have a class 'EyeLash' defined but we have not given any @Component/@Service etc annotaion on it hence spring will not create a bean for 
	 * 		'EyeLash' class. still the spring application will start without throwing any exception.
	 * 
	 * NOTE: in this example, if you set the 'required' property value to 'true' then, it will throw an error during spring application startup and doesn't allow it to start.
	 * 
	 * 
	 */
	@Autowired(required=false)
	public EyeLash obj;

	@RequestMapping("/RequiredFieldFalse")
	public String getRequiredFieldValueSetToFalse() {
		return obj.color;
	}

}

class EyeLash {
	String color;
}
