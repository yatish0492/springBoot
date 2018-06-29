package com.yatish.springBootStart;

public class S1_1_Bean_Life_Cycle {

	/*
	 * What is Bean life cycle?
	 * When the spring application is started, spring will follow the below process,
	 * 1) The xml or component scan path will be scanned and the objects/beans will be created. If constructor-args are present then those will be considered while creating object/bean.
	 * 2) Then if we have the property values specified, then the corresponding setter methods will be called on the beans to initialize those property values.
	 * 3) Then, 'setbeanName()' will be called to set the bean names/ids for the corresponding beans.
	 * 4) Then, 'setBeanFactory()' will be called to set the bean to the bean factory.
	 * 5) Then, the 'PostProcessBeforeInitialize' will be called.
	 * 6) Then, the 'afterPropertiesSet' will be called.
	 * 7) Then, the default init method or the bean level init methods specified in the configuration xml file will be called.
	 * 8) Then, The 'PostPreocessAfterInitialization' will be called.
	 * 9) Then, the bean is ready for use.
	 * 
	 * 10) After, bean has been destroyed, the 'destroy()' method in Disposable Bean will be called.
	 * 11) Then, the default destroy method or the bean specific destroy method defined in the confiuration xml file will be called.
	 * 
	 * 
	 * 
	 * What is Spring IOC container?
	 * BeanFactory or ApplicationContext is nothing but IOC container, BeanFactory/ApplicationContext is also called as IOC container.
	 * 
	 * 
	 * 
	 */

}
