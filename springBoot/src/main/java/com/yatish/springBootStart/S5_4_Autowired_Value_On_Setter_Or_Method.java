package com.yatish.springBootStart;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scala.annotation.varargs;

@RestController
public class S5_4_Autowired_Value_On_Setter_Or_Method {
	
	@Autowired
	Bottle obj;
	
	@RequestMapping("/valueOnSetter")
	public String getTheValueOnSetter() {
		return obj.color + " cap color:" + obj.capColor + " size: " + obj.bottleSize + " Company:" + obj.bottleCompany;
	}

}

@Component
class Bottle {
	
	String color;
	String capColor;
	int bottleSize;
	String bottleCompany;

	public String getColor() {
		return color;
	}
	
	/*
	 * We can also use @Value on a method as well. as we can see here we are using it on setter method. This will assign 'color' field with blue during bean initialization.
	 * 
	 * When spring sees @Value annotation on a method, it will inject the value provided to the parameter of the function and and execute that function during bean initialization
	 */
	@Value("blue")
	public void setColor(String color) {
		this.color = color;
	}
	
	/*
	 * @Value can be used on any function. not just setters.
	 */
	@Value("yellow")
	public void someMethod(String color) {
		this.capColor = color;
	}
	 
	
	/*
	 * consider if you want to initialize a set of values using some method. in that case @Value should be given along with the parameters, before corresponding parameter.
	 * 
	 * Note: Don't forget, you have to specify @Inject before the method. because if we use @Value within function parameters, then spring doesnt get to know that it should execute this
	 *      method or initialize the parameters hence if we give @Inject. spring will get to know that it should initialize the parameter hence it will try to initialize and finds the 
	 *      @Value with parameters and initialized then and then execute this function during bean initialization.
	 */
	@Inject
	public void someMethod1(@Value("12") int size, @Value("Tupperware")String company) {
		this.bottleCompany = company;
		this.bottleSize = size;
	}
	
}
