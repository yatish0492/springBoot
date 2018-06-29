package com.yatish.springBootStart;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*
 * we have to specify @Aspect on the class, which we want it to act as an aspect. AOP will scan this class for aspects and associate the aspects so that it will make sure they are called.
 * 
 * What if i miss giving @Aspect and directly use @Before  on the functions in this class?
 * There will be no compile time error. But the AOP will not scan this function and the aspects defined with @Before will not work.
 * 
 * NOTE: For @Aspect to work, you need to configure 'AspectJAutoProxy' in spring. there are 2 ways to configure it. refer to '@EnableAspectJAutoProxy' in '@SpringBootApplication'.
 */
@Aspect

/*
 * We have @Aspect defined, then why are we giving @Component also here?
 * @Aspect is like an add-on. so that AOP will scan the aspects of the beans present in spring. we have not defined a bean in 'yatish-config.xml' file. hence if we dont give @Component,
 * then spring will not create a bean of this class at all. Hence if there is no bean, AOP cannot associate or scan the aspects at all.
 */
@Component
public class S14_1_Aspect_Before {
	
	/*
	 * In AOP, we know that it is used to avoid duplication of codes in classes. But how is AOP helping here to achieve it?
	 * AOP provides @Before annotation. if we just write the code in the function below @Before annotation and give the regular expression. within @Bean annotation, then this function will
	 * be called before all the functions which match the regular expression within @Bean annotation. Hence there is no need to write any code in the classes, in which we want this code 
	 * to be executed. hence code duplication is avoided.
	 * 
	 * NOTE: we cannot give any other return type than 'void' to the functions with @Before annotations.
	 * 
	 * why we cannot give any other return type than void?
	 * Because, these methods will be executed before the specified methods in other classes. hence there will be no way we can catch the return value in those classes.
	 * 
	 * What is that which we specify within @Before annotation?
	 * This is a regular expression, where we specify the methods before which the following/aspect function should be called. in this code we are telling spring-AOP to execute 'method1()'
	 * before 'public String getColor()' function from any class/beans.
	 * 
	 * NOTE: 'execution()' is the basic syntax for specifying the regular expression. if you specify regular expression without 'execution()', then it wont work.
	 * 
	 * What is pointcuts?
	 * The regular expressions, what we specify here are called as pointcuts. refer to 'S14_2_Aspect_PointCut.java' for more details.
	 * 
	 * consider, i have written an function/aspect with regular expression for all setter methods of all classes. when spring initialized the bean it will obviously call the setter if we
	 * have provided the values. does the aspect function be called before spring calls the setter method?
	 * No!!!
	 * The aspects are called only when user executes that method. if spring is calling that method during initialization, in that case aspects will not be executed before/after any time.
	 * 
	 * Few more other examples of how to use regular expression
	 * --------------------------------------------------------
	 * CASE 1 : consider you have 'getColor()' method in many classes and you want this AOP to be called on only 'getColor()' method in a particular class. eg: 'Colors' class.
	 * 			@Before("execution(public String com.yatish.springBootStart.pojos.Colors.getColor())")
	 * 	
	 * CASE 2 : consider you need to call all the functions in all the classes starting with 'get' . like 'getName()', getAge(), getAnything() etc. with return type as string.
	 * 			@Before("execution(public String get*())")
	 * 
	 * CASE 3 : consider you need to call all the functions in a particular class starting with 'get'. like 'getName()', getAge(), getAnything() etc. with return type as string.
	 * 			@Before("execution(public String com.yatish.springBootStart.pojos.Colors.get*())")
	 * 
	 * CASE 4 : consider you need to call all the functions in all the classes starting with 'get'. with any return type. and no parameters.
	 * 			@Before("execution(public * get*())")
	 * 
	 * CASE 5 : consider you need to call all the functions in all the classes starting with 'get'. with any return type. and with one or more parameters
	 * 			@Before("execution(public * get*(*))")
	 * 
	 * CASE 6 : consider you need to call all the functions in all the classes starting with 'get'. with any return type. and with zero or more parameters
	 * 			@Before("execution(public * get*(..))")
	 * 
	 * CASE 7 : consider you need to call all the functions in all the classes starting with 'get'. with any return type. and no parameters and irrespective of access specifier.
	 * 			@Before("execution(* get*(..))")	--> you can either specify a '*' in place of access specifier or just don't give anything there. both will work
	 * 
	 * CASE 8 : consider you need to call all the functions in all the classes starting with 'get' within a particular package. with any return type. and no parameters and irrespective 
	 * of access specifier.
	 * 			@Before("execution(* com.yatish.springBootStart.pojos.*.get*(..))")
	 * 			@Before("execution(* com.yatish.springBootStart.*.*.get*(..))")
	 * 			@Before("execution(* com.yatish.*.*.*.get*(..))")
	 * 
	 * 
	 */
	@Before("execution(public String getColor())")
	public void method1() {
		System.out.println("Aspect method method1() is executed. On following url call - http://localhost:3000/RequiredField");
	}
	
	/*
	 * Consider, i want to have multiple condition to be applied on an function/aspect, how do we do that?
	 * Spring AOP allows, operands as well in pointcuts, you can use &&, || etc to achieve it.
	 * eg: refer to the below code, this aspect will be applied only when both the conditions are met. I know there can be no case the method name can be both 'getColor()' and 'getName()'
	 * just for sake of example i have given just to understand the concept. 
	 */
	@Before("execution(public String getColor()) && execution(public String getName())")
	public void method2() {
		System.out.println("Aspect method method2() is executed");
	}


}
