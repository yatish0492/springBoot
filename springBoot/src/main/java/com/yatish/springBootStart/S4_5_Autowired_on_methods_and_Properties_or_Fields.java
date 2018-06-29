package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S4_5_Autowired_on_methods_and_Properties_or_Fields {

	/*
	 * @Autowired can be applied on both Class properties/fields,constructors and methods/setter methods as well
	 * 
	 * @Autowired on properties/fields(field Autowiring)
	 * -------------------------------------------------
	 * we can specify @Autowired on a property. Whenever the Object of this class is created, this bean will be created/injected. The Bean of the property above which the @Autowired
	 * is present will be created/injected
	 * 
	 * @Autowired on Constructor(constructor Autowiring)
	 * -------------------------------------------------
	 * we can specify @Autowired on a constructor. Whenever the Object of this class is created, Spring will create/inject the beans of the objects
	 * present as parameters in the constructor.
	 * 
	 * @Autowired on Methods/setter methods
	 * ------------------------------------
	 * we can specify @Autowiered on any methods, it can be setter methods or some other methods, Spring will create/inject the beans of the objects present as parameter in the function.
	 * 
	 * 
	 * Consider, if a file has all types of @Autowired, then what is the order, spring will inject beans?
	 * When object of a class is created, Spring will first search the class, if any @Autowired on properties, if present it will take highest precedence, this bean will be injected, 
	 * then spring searches, whether if there is any constructor with @Autowiring, if present, they will take the next preference, spring will inject the parameters present in the
	 * constructor. Then spring searches if there are methods with @Autowired, if present, they will take the next preference, spring will inject the parameters present in the 
	 * method sequentially, one method after another
	 * 
	 * In this example,
	 * In this class, it searches for field autowiring and it finds below one,
	 * 		@Autowired
			Omlet om;
	   it will create/inject the 'Omlet' bean. Before injecting Omlet bean, spring will first resolve the 'Omlet' class dependencies before injecting 'Omlet' object to this class.
	   In 'Omlet' class, spring searches the field autowiring, as there are no field autowiring, it will start searching for constructor autowiring, then it will inject 'Helper' bean
	   to the constructor. then it will start searching for method autowiring, it will start scanning for methods with @Autowired from start of the class, it will find 'someMethod()'
	   and injects the 'Helper' bean to this method, and then scans further and finds 'setObj' setter method and injects the 'Helper' bean to it. 
	   Then only the 'Omlet' bean injection to this class will be complete.
		
	 * 
	 */
	@Autowired
	Omlet om;
	
		
	@RequestMapping("/AutowiredOnMethods")
	public String pringAutowiredInjections() {
		return om.obj.printHello();
	}

}

@Component
class Omlet {
	
	Helper obj;
	
	@Autowired
	public void someMethod(Helper object) {
		System.out.println("Autowired applied on some method " + object.printHello());
	}
	
	@Autowired
	public void setObj(Helper obj) {	
		this.obj = obj;
		System.out.println("Setter object called " + obj.printHello());
	}

	@Autowired
	Omlet(Helper helper) {
		System.out.println("Autowired applied on constructor " + helper.printHello());
	}
	
	
	
	
}
