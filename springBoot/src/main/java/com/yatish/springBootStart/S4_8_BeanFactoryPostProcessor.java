package com.yatish.springBootStart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class S4_8_BeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	/*
	 * A class which implements 'BeanFactoryPostProcessor' interface is called as 'BeanFactoryPostProcessor' class in spring
	 * 
	 * If user doesn't want a set of statements to be executed before each and every bean initialization. then user can use 'BeanFactoryPostProcessor'. this interface provides only one
	 * method to implement. This method will be executed before the sping starts initializing the beans.
	 * 
	 * basically, first 'BeanFactoryPostProcessor' executes, then the 'BeanPostProcessor' will be executed and then the init or destroy methods will be executed.
	 * 
	 * 
	 */
	
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactoryObj)  throws BeansException{
		//System.out.println("BeanFactoryPostProcessor ==> following bean post processor is called");
	}

}
