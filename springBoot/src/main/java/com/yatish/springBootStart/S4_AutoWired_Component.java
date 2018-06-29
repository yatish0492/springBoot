package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S4_AutoWired_Component {

	/*
	 * '@Autowired' annotation tells, the spring container, that i have a dependency here. The spring container will look into the Class which is declared as dependency, here it is 'Helper'
	 * Then it will see all the beans it has instantiated(The beans can be defined either in xml file or with annotations @Service, @Component etc). and injects them here. 
	 * 
	 * 
	 * Here we avoid wring the dependency code, i.e. 'Helper obj = new Helper()'
	 * 
	 * Autowired annotation, first tries to do autowire 'byType'. it will check if there is only one bean of type 'Helper' then it will use that bean here. Coniser if there are 2 or more
	 * beans of 'Helper' class type, in that case, Autowired annotation will check if the there is any bean with id as 'obj'. if there are no beans with id as 'obj' then it will see if
	 * there is any qualifier tag is present, if it is present then it will try to fetch the bean based on qualifier value.
	 */
	@Autowired	
	private Helper obj;

	@RequestMapping("/hello")
	public String printHello() {
		return obj.printHello();
		
	}
}

/*
 * We have to declare the annotation, like '@Service', '@Component' etc. It is mandatory if we want to use it anywhere using '@Autowired'
 * 
 * Spring will scan through the files in classpath, and check for the annotations, when it comes across these annotations, it will create an instance of them and link it or injects it,
 * wherever this Class is referenced with the @Autowired annotation
 * 
 * 
 * Major DrawBack of @Component/@service etc
 * ---------------------------------------------
 *	1) We cannot create multiple objects/beans of the class, here, only one bean of class 'Helper' can be created using @Component/@Service
 * 		All the beans created using @Component or @Service etc are singleton beans
 * 
 * 
 * 		Then how can we create multiple objects/beans of a class?
 * 		You can do that only through the xml file. i.e. spring.xml, here 'yatish-config.xml'
 * 
 *  2) We cannot have the advantage of providing a initialized parent bean to other child bean using annotations. please refer 'S4_6_Autowired_xml_inheritance.java'
 * 
 * Can we initialize properties of class using @Service  or @Component etc?
 * Yes!!!  we can using @Value annotation. refer S5_3_Autowired_Value.java
 *
 */


/*
 * It creates a bean with 'id' attribute
 */
	@Service("1234")
	class Helper {
	
	public String printHello() {
		return "hello";
	}
}

/*
 * Consider, we only wrote '@Autowired' annotation and didn't add @Service to 'Helper' Class,
 * 
 * Then we get a exception while starting the spring container, as follows,
			****************************
			APPLICATION FAILED TO START
			***************************
			
			Description:
			
			Field obj in com.yatish.springBootStart.S4_AutoWired required a bean of type 'com.yatish.springBootStart.Helper' that could not be found.
			
			
			Action:
			
			Consider defining a bean of type 'com.yatish.springBootStart.Helper' in your configuration.
 */


