package com.yatish.springBootStart;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_4_Aspect_JoinPoint {

	/*
	 * What is JoinPoint?
	 * JoinPoint is a class which holds information of a method. In AOP case, we know that aspect function will be executed before all the methods which match the pointcut given in @Before
	 * consider in the function/aspect, you want to access the method which is causing the execution of this aspect, we need to have the reference to the method right? JointPoint provides
	 * the reference to the current it.
	 * 
	 * We just need to mention a parameter in the aspect with type as 'JoinPoint' the parameter name can be anything in this eg it is 'jp'. spring AOP will assign the method reference to
	 * this parameter.
	 * 
	 * 
	 */
	@Before("execution(public String getColor())")
	public void method1(JoinPoint jp) {
		/*
		 * As we can see here, 'jp' variable has been assigned with the reference of the method which is invoking this aspect. we are using that reference and invokiing a method called 
		 * 'getTarget()' on it, which will give us the class of that method.
		 */
		System.out.println("Aspect method method1() is executed. On following url call - http://localhost:3000/RequiredField for class - " + jp.getTarget().toString());
	}
}
