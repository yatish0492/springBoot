package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_1_Component_with_Identifier {

	/*
	 * We cannot create multiple beans of a class using @Component or @Service etc. the created bean will be singleton, then why the hell do we need an identifier for it?
	 * Yes, we cannot create multiple beans of class, but in case, if we are autowiring an interface, then there can be one or more classes implementing it, if we simply autowire,
	 * How will spring know, which implementation(class) bean to create. there raises ambiguity. so spring has allowed us to assign a 'qualifier' along with @Component so that while
	 * we use @Autowired we can specify the identifier of the implementation(class) using @Qualifier
	 * 
	 */
	@Autowired
	@Qualifier("leftKannu")
 	Eye obj;
	
	@RequestMapping("/getEye")
	public String printHello() {
		return obj.getLabel();
	}
}


//interface
interface Eye {
	public String getLabel();
}

//We just specify the id of the bean within the brackets of @Component
@Component("leftKannu")
class LeftEye implements Eye{
	String label = "LeftEye";
	public String getLabel() {
		return label;
	}
}

//We just specify the id of the bean within the brackets of @Component
@Component("rightKannu")
class RightEye implements Eye{
	String label = "RightEye";
	
	public String getLabel() {
		return label;
	}
}



