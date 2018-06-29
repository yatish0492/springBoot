package com.yatish.springBootStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication 		//This is the annotation which provides default configurations to the spring boot application

/*
 * 'yatish-config.xml' is nothing but the 'spring.xml' file, I have given the name as like that. The name of 
 * the file doesn't matter. you just have to provide it in the path. It is a best practice to use universal naming
 * convention for this file. either name it as 'app-config.xml'  or 'spring.xml'
 * 
 * This is the configuration file for providing the bean configurations. you may think that, the bean 
 * configurations done using @Component annotation. then why do we need this xml file to be included?
 * Actually, the xml file bean configurations have its own advantages over @Component, so if user wants 
 * to use those advantages, then he has an option to use configurations from xml as well.
 * 
 * if we use @Component, it will always create a bean/object of a class by calling its default constructor
 * which is a non-parameterized constructor. Consider if you want to create a bean, with calling a parameterized
 * constructor, then you have to fall back to providing xml based bean configurations because by using @Component
 * you cannot achieve this. Refer to the notes for more details.
 * 
 */
@ImportResource("classpath:yatish-config.xml")


/*
 * By default, the spring container scans only the java files in the current package, if you have placed a dependency in some other package and autowire it here, then
 * It gives a error because, spring container scanned only the current package, the dependency was in some other package. Hence we have - @ComponentScan
 * 
 *  We need to specify the packages, which we want the spring container to scan. 
 *  Actually, By Default even if we don't declare @ComponentScan also, as part of @SpringBootApplication, it comes default with the current package as the value eg: here the default
 *  it would be taken as @ComponentScan("com.yatish.springBootStart")
 *  
 *  We can override it as done below
 *
 *	One more thing is, consider you cant to scan all the packages starting with something, we can do that as well, as we have done below,
 *	we have given @ComponentScan("com.yatish"), this will scan all the packages starting with "com.yatish".  i.e. it will scan both 'com.yatish.springBootStart' and 'com.yatish.pojos'
 *
 *	We can also specify multiple packages to scan as shown below,
 *	 		@ComponentScan(basePackages = {
	        "com.yatish.springBootStart",
	        "com.yatish.pojos"
 			}
	Here, we are specifying both packages explicitly. Make sure to add current package also, if you add only other packages, thinking that the current package will be added implicitly,
	Then you are in trouble, it will not scan the current package only for annotations
 *  
 */

/*
 * consider, if we want to use a properties file in spring. in that case, you can just specify the properties file within the @PropertySource annotation. 
 *
 * One use case, where we need this annotation is while using @Value with '${}'. go through 'S5_4_Autowired_Value.java' to have more clear idea.
 * 
 */
@PropertySource("classpath:variables.properties")

/*
 * @EnableAspectJAutoProxy Enables support for handling components marked with AspectJ's @Aspect annotation.
 * 
 * ok. using this annotation we can enable it. can we do the same in configuration xml file instead of annoation?
 * Yes. we need to add following in the xml file,
 * '<aop:aspectj-autoproxy/>'
 */
@EnableAspectJAutoProxy
@ComponentScan("com.yatish")
public class S1_SpringBootApplication {

	public static void main(String[] args) {
		
		/*
		 * 'SpringApplications.run()' will start the spring application context
		 * 
		 * Scans the complete class path and analyses the annotations in all the class files in the current package and the packages mentioned in @componentScan. and based on annotations it will initializes the application context
		 * EG: it scans all java files and find @Service, @Controller, @autowire etc and do the operation while running it. like autowired objects will be made available for that class
		 *  
		 * After scanning the class path, it will start the tomcat server.
		 * 
		 * Hence by just running this class as java application will start a tomcat server
		 */
		SpringApplication.run(S1_SpringBootApplication.class, args);

	}
	
	
	/* 
	 * @Bean annotation are always defined on the functions. and that function should be within the spring configuration file only. i.e. the class file with '@Configuration' annotaion.
	 * 
	 * This function should return an object mandatorily. The object that is being returned will be used as the instance/bean of the 'Nail' class by spring.
	 */
	@Bean
	public Nail getNail(){
		return new Nail();
	}
	
	/* This is regarding 'S11_Message_Source.java' instead of getting the object/bean of 'ResourceBundleMessageSource' using @Component, we can get that object using @Bean like as shown
	 * below,
	 * 
	 * @Bean
	public MessageSource configureMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18/users", "i18/errormsg");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
		}
		
		*
		*	When we use @Autowired, then we have to give it as follows,
		*  @Autowired
		*  MessageSource obj;
		*
		*/
		

}

