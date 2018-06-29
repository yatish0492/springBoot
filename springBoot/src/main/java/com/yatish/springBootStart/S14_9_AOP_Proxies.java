package com.yatish.springBootStart;

import org.aspectj.lang.annotation.Before;

public class S14_9_AOP_Proxies {

	/*
	 * What are AOP proxies?
	 * In spring AOP we know how @Before, @After, @Around works. but do we know how spring AOP internally does these operations? Spring AOP uses proxy class/object to achieve these.
	 * 
	 *  Consider we are using following aspect,
	 *  Aspect
	 *  -------
	 * 		@Before("execution(public String getColor())")
			public void method1() {
				System.out.println("Aspect method method1() is executed");
			}
				
		Class having 'getColor()' method
		---------------------------------
			class ABC {
			
				public String getColor() {
					return "black";
				}
			}
			
		Proxy class created by spring AOP
		----------------------------------
			class xyz extends ABC {
			
				public String getColor() {
					System.out.println("Aspect method method1() is executed");
					return super.getColor();
				}
			}
		
		Whenever, we make a call to 'getColor()', spring AOP will not directly go and execute the method from 'ABC' class, first it will go and check whether there is proxy class for 'ABC'
		class or not. if proxy class is there, then it will call the 'getColor()' method of proxy class 'xyz' instead of 'ABC'.
		Since, proxy class has the method 'getColor()' which has aspect statements before calling parent class 'getColor()' method. it will execute the aspect before the pointcut matching
		method.
		
		If you observe, we are using 'super' keyword to call the method in actual class from the proxy class. you know why? The proxies are the child classes which extends the corresponding 
		actual classes.
		
		NOTE: for @After and @Around also it works the same way.
		
	 */
	
	
}
