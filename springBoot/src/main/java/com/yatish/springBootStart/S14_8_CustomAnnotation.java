package com.yatish.springBootStart;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class S14_8_CustomAnnotation {

	/*
	 * In @After,@Before,@Around etc. we saw that we are writing the pointcuts using regular expressions like 'execution(* * com.*.yatish.*.get*())'. this was annoying to understand so, 
	 * Spring AOP came up with @Pointcut. but consider you want to apply a aspect on a method 'getName()' of 50 classes but not on other classes. in that case do you think writing pointcut
	 * as follows works out!!!
	 * 				'execution(public String com.yatish.A.getName()) || execution(public String com.yatish.B.getName()) || execution(public String com.yatish.C.getName()) ...... '
	 * So spring AOP provides one more approach to handle such corner cases, where you can assign an annotation to an aspect/function and we can just specify that annotation on the methods
	 * for which this aspect has to be applied.
	 * 
	 */
	
	/*
	 * First You have to create an custom annotation class, like how we create a class file in eclipse. right click on the package and select 'new' and then select 'annotation' 
	 * in that instead of 'class'. 
	 * eg: I have created a custom annotation at - com.yatish.TutorialSupportingCode.CustomAspectAnnotation
	 */
	
	
	/*
	 * Then we have to specify the custom annotation with '@annotation()' as shown below in our case,
	 * it is "@annotation(com.yatish.TutorialSupportingCode.CustomAspectAnnotation)".
	 * 
	 *	Then we have to specify '@CustomAspectAnnotation' on whichever the method we want to this aspect to called on. in our case we have specified '@CustomAspectAnnotation' on 
	 *  'public String getColor()' in 'S5_5_Autowired_Value_Required'
	 *  
	 *  
	 */
	@Before("@annotation(com.yatish.TutorialSupportingCode.CustomAspectAnnotation)")
	public void method1() {
		System.out.println("The custom annotation aspect has been called on call of url - http://localhost:3000/RequiredField");
		
	}
}
