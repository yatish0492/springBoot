package com.yatish.springBootStart;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_5_Autowired_Value_On_Constructor {

	@Autowired
	Cap obj;
	
	@RequestMapping("/getSetValueOnConstructor")
	public String getSetValueOnConstructor() {
		return obj.company;
	}
}

@Component
class Cap {
	
	String company;
	
	Cap() {
		
	}
	
	/*
	 * we can also use @Value on Constructors as well. 
	 * 
	 * but here, the we have only one parameter to initialize so can we use @Value before the method? like as follows,
			    @Value("Rebook")
			    Cap(String company) {
					this.company = company;
				}
		?
		No!!!!!
		Spring doesnt support it. for constructors, you have to do it this way only in front of corresponding parameters
		
		Note: Don't forget, you have to specify @Inject before the method. because if we use @Value within function parameters, then spring doesnt get to know that it should execute this
	       method or initialize the parameters hence if we give @Inject. spring will get to know that it should initialize the parameter hence it will try to initialize and finds the 
	       @Value with parameters and initialized then and then execute this function during bean initialization.
		
	 */
	@Inject
	Cap(@Value("Rebook") String company) {
		this.company = company;
	}
}