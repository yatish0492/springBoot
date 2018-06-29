package com.yatish.springBootStart;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_6_After {

	/*
	 * @After is similar to @Before, whatever we can do in @Before, we can do it in @After as well.
	 * 
	 * So both @After and @Before are same?
	 * No!!!
	 * @After aspect will be called after the corresponding point cut matching method executed. whereas @Before aspect will be called before the point cut matching method executed.
	 */
	
	@After("execution(public String getColor())")
	public void method1() {
		System.out.println("Aspect method method1() is executed. On following url call - http://localhost:3000/RequiredField");
	}
	
	
	/*
	 * There is one more aspect annotation provided by spring AOP called @AfterReturning
	 * 
	 * @After or @Before aspect will run even if the corresponding point cut matching method executes successfully without throwing any exception or if the method throws an exception.
	 * where as @AfterReturning aspect will be executed only if the corresponding point cut matching method is successfully executed without throwing any exception. 
	 * 
	 * If you want the reference to the returning object from the method, in the aspect, then spring AOP also provides an option to that as follows,
	 * @AfterReturning(pointcut="execution(public void executesWithoutException())" returning=“returningString”)
	   	method(String returningString);	--> It need not be a string only. it can be any object as well
	 */
	@AfterReturning("execution(public void executesWithoutException())")
	public void method2() {
		System.out.println("Aspect method method2() is executed. On following url call - http://localhost:3000/noException");
	}
	
	
	
	/*
	 * There is one more aspect annotation provided by Spring AOP called @AfterThrowing
	 * 
	 * It is exact opposite of @AfterReturning. @AfterThrowing aspect will be executed only if the corresponding point cut matching method is successfully executed throwing 
	 * any exception. 
	 * 
	 * If you want the reference to the exception, in the aspect, then spring AOP also provides an option to that as follows,
	 * @AfterThrowing(pointcut=“reg_exp” throwing=“ex”)
		public void method3(Exception ex);		--> The exception thrown by the method will be assigned to the 'ex' parameter
	 */
	@AfterThrowing("execution(public void executesWithThrowingException())")
	public void method3() {
		System.out.println("Aspect method method3() is executed. On following url call - http://localhost:3000/Exception");
	}
	
	
}
