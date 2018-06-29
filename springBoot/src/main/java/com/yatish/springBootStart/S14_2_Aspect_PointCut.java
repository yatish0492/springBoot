package com.yatish.springBootStart;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_2_Aspect_PointCut {
	
	/*
	 * In both aspect methods 'method1()' and 'method2()' we see that the regular expression or point cut are same. in such cases, we are simply again introducing code duplication again
	 * in this class!!!! hahaha. do we have a solution?
	 * Yes Spring AOP provides solution for this as well. checkout how the it is being handled for 'method3()' and 'method4()' in this class. both of them need same regular expression/point
	 * cut which is 'public String getAge()'.
	 * 
	 */
	@Before("execution(public String getName())")
	public void method1() {
		System.out.println("Aspect1 has been executed");
	}
	
	@Before("execution(public String getName())")
	public void method2() {
		System.out.println("Aspect2 has been executed");
	}
	
	
	/*
	 * To solve the code duplication problem we faced in the 'method1()' and 'method2()'. here we have declared the regular expression using @Pointcut annotation and we are using that 
	 * method names here. Hence less code duplication.
	 */
	@Before("allAgeGetters()")
	public void method3() {
		System.out.println("Aspect3 has been executed");
	}
	
	@Before("allAgeGetters()")
	public void method4() {
		System.out.println("Aspect4 has been executed");
	}
	
	
	/*
	 * we use @Pointcut, to assign the regular expression to the function name. so that wherever in @Before we want to use this regular expression. we can give the function name isntead
	 * of retyping the complete regular expression.
	 * 
	 * what is the advantage of doing this, here also we need to define pointcut seperately which will cost us some amount of code and in @Before, we still need to give the function name
	 * which still causes code duplication?
	 * 1) yes, code duplication is still there, i agree but consider there are 100 functions/aspects which use a regular expression of length 30 charecters. in that case
	 * 		retyping that 30 charecter regular expression in all those 100 functions/aspects in @Bean costs us 100 time duplication of 30 charecters in code. 
	 * 		if we use @Pointcut and write the function name for point cut as 'abc()' then instead of using 30 charecter regular expressoin in 100 function/aspect's @Bean we just use 5
	 * 		charecter 'abc()'. hence you can only decide to how much extend code duplication is reduced using @Pointcut.
	 * 2) sometimes, the regular expressions will be complex in nature. coder might make mistakes in typing the same regular expression in all n number of functions/aspect's @Bean. hence
	 * 		major problem.
	 * 3) Consider if you want to change a regular expression used by 100+ functions/aspects's @Bean. in that case you need to manually goto each @Bean of those 100+ functions/aspects and
	 * 		change it. if we use @Pointcut then we can just change it at one place.
	 * 4) It provides readability.
	 * 		eg: consider if you have @Before("execution(public String get*())"); 
	 * 			consider instead of above, you have  @Before("allGetters()")	--> how meaningful is this to understand than above one. even though both do the same functionality.
	 *
	 * 		
	 */
	@Pointcut("execution(public String getAge())")
	public void allAgeGetters() {}
	
	@Pointcut("execution(public String getName())")
	public void allNameGetters() {}
	
	
	/*
	 * following code shows applying of multiple pointcuts on an aspect. we showed how to use this using regular expression in 'S14_1_Aspect_Before' like,
	 * @Before("execution(public String getColor()) && execution(public String getName())")
	 * can we do the same using pointcut methods as well?
	 * Yes!!!!!
	 * the below pointcut shows you about how to do that 
	 */
	@Before("allAgeGetters() || allNameGetters()")
	public void method5() {
		System.out.println("Aspect4 has been executed");
	}
}
