package com.yatish.springBootStart;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_3_Aspect_PointCut_Within {
	
	/*
	 * Spring AOP provides, one more support in regular expressions, 'within' this is used like as we use 'execution'
	 * 
	 * We had 'execution' why we need 'within'?
	 * the way both of them work is different. 'execution' will just match all the methods matching with the regular expression provided. where as 'within' will apply/call the aspect on
	 * all the methods which comes under the matching class or on all the methods which comes under a while package etc. see the example for much more clarity.
	 * eg:  @Before("within(com.yatish.pojos.Bike)")	--> The aspect will be called on all the methods present under 'com.yatish.pojos.Bike' class.
	 * 		@Before("within(com.yatish.pojos.*)")  --> The aspect will be called on all the methods of all the classes present in 'com.yatish.pojos' package.
	 * 		@Before("within(com.*.pojos.*)") 	--> The aspect will be called on all the methods of all the classes present in 'com.*.pojos.*' package.
	 * 		@Before("within(com.yatish..*)")	--> The aspect will be called on all the methods of all the classes present in all the packages present under 'com.yatish' package.	
	 * 
	 */
	@Before("within(com.yatish.pojos.Bike)")
	public void method1() {
		System.out.println("The aspect method1() has been called on URL call of http://localhost:3000/bikeModel");
	}

}
