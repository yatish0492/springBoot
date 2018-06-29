package com.yatish.springBootStart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class S4_7_BeanPostProcessor implements BeanPostProcessor {
	
	
	/*
	 * if a class implements the 'BeanPostProcessor', then that class is called as the bean post processor class in spring.
	 * 
	 * there are 2 methods declared in the interface 'BeanPostProcessor' as implemented in this class.
	 * 
	 * whatever we write in the 'postProcessBeforeInitialization' function will be executed before initialization of each and every bean. then if there is any 'init-method' 
	 * defined in the bean, that will be executed. Then the 'postProcessBeforeInitialization' function will be executed.
	 * 
	 * When the 2 functions will be called with each and every bean, the current bean object will be passed as the first argument and the name of the bean will be passed as the
	 * second argument.
	 * 
	 * Just writing the java file doesn't help. we need to declare this java file as bean in xml file or else we can declare this class with @Component annotation. so that spring
	 * will come to know.
	 * 
	 * 
	 * NOTE: Make sure, in both the function, the null value is not returned. if null is returned explicitly, then spring application startup will throw up an error.
	 */

	public Object postProcessAfterInitialization(Object beanObj, String beanName) throws BeansException{
		//System.out.println("BeanPostProcessor --> following bean post processor after initialization is called : " + beanName);
		return beanObj;
	}
	
	public Object postProcessBeforeInitialization(Object beanObj, String beanName) throws BeansException{
		//System.out.println("BeanPostProcessor --> following bean post processor before initialization is called : " + beanName);
		return beanObj;
	}

}
