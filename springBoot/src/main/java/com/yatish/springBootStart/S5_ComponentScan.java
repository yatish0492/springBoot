package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Human;

@RestController
public class S5_ComponentScan {

		@Autowired		
		private Human obj;

		@RequestMapping("/human")
		public String printHuman() {
			return obj.printHuman();
			
		}

}


/*
 * This program gives the following error, if we forget to include the 'com.yatish.pojos' package in @ComponentScan.
		****************************
		APPLICATION FAILED TO START
		***************************
		
		Description:
		
		Field obj in com.yatish.springBootStart.S5_ComponentScan required a bean of type 'com.yatish.pojos.Human' that could not be found.
		
		
		Action:
		
		Consider defining a bean of type 'com.yatish.pojos.Human' in your configuration.






@ComponentScan is used in the first program along with the spring configuration. please refer to 'S1_SpringBootApplication.java' for more on this.
*/
