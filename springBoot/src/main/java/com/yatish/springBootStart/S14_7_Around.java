package com.yatish.springBootStart;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_7_Around {

	/*
	 * We learnt @Before and @After. consider you want some code/aspect to run before and after a pointcut matching methods. In that case writing a  the code in 2 aspect method with @Before
	 * and @After increases the number of lines of code. hence spring AOP provides one more annotation called @Around. We can write the @Before and @After code within the same aspect using
	 * @Around
	 * 
	 * NOTE: In @Around aspect, we have to specify 'ProceedingJoinPoint' parameter mandatorily.
	 * 
	 * in @Around you can control about what should be executed before the pointcut metching method and what should be executed after the execution of pointcut matching method by using 
	 * 'ProceedJoinPoint' parameter. '.proceed()' method informs spring AOP that, the @Before code has been executed. to you can execute the point cut matching method now. hence whatever
	 * the code we write after '.proceed()' method will be executed afterwards.
	 * Basically, whatever the code we write before '.proceed()' method is consider as @Before code and whatever is written after '.proceed()' method will be considered as @After code.
	 * 
	 * NOTE: '.proceed()' method throws a 'Throwable' object hence we have to mandatorily write try catch block.
	 * 
	 * Is that the only advantage we have with @Around that we can include both @Before and @After code within it?
	 * No!!!!
	 * Actual main advantage is, if we do not write '.proceed()' method in the @Around aspect, then the pointcut matching methods will not be executed at all even if we try to manually 
	 * execute them by calling that function because, the aspect will be executed first. Hence we execute '.proceed()' method based on some conditions in the @Around aspect. hence only if
	 * those conditions are met then only the pointcut mathcing method will be exeucted otherwise no. so basically we can control the execution of the point cut matching method in @Around
	 * which is not supported by @Before,@After etc.
	 * eg:
	 * @Around("execution(public String getColor())")
		public void method1(ProceedingJoinPoint pjp) {
		System.out.println("The Arround Aspect has been called before execution of url - http://localhost:3000/RequiredField");
		try {
			if(10<20) {			--> here the 'getColor()' method will be called only if the condition is satisfied otherwise, it will not be executed.
				pjp.proceed();
			}
		}catch(Throwable e) {}
		System.out.println("The Arround Aspect has been called after execution of url - http://localhost:3000/RequiredField");
	
	}
	 *  
	 *  why are we returning an object here?
	 *  The pointcut expression which we are using is returning a 'String' so we also have to return an object here in aspect method mandatorily. In some cases if pointcut is complex 
	 *  like '* * get*()' which applies to many method which may return different types of objects. To handle these kind of cases, we generally return 'Object' type instead of 'String'.
	 *  The return object is nothing but the returning value of '.proceed()' method.  
	 *  
	 *  Consider if the pointcut specifies the return type is void, in that case also we should return an object?
	 *  No!!!
	 *  eg: @Around("execution(public void someMethod())")
	 *  If pointcut specifies that it is returning void, then the aspect also can return void. otherwise it can return object also. if the pointcut matching methods are returning an object
	 *  then we have to mandatorily return the object returned by '.proceed()' method.
	 *
	 */
	
	@Around("execution(public String getColor())")
	public Object method1(ProceedingJoinPoint pjp) {
		Object obj = null;
		System.out.println("The Arround Aspect has been called before execution of url - http://localhost:3000/RequiredField");
		try {
			obj = pjp.proceed();		// this line tells spring AOP to execute he 'getColor()' method now.
		}catch(Throwable e) {}
		System.out.println("The Arround Aspect has been called after execution of url - http://localhost:3000/RequiredField");
		return obj;
	}

}
