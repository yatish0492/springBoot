package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Child;

@RestController
public class S4_6_Autowired_xml_inheritance {

	/*
	 * We know that java supports inheritance, but in case of spring context. we can also specify which bean should act as the parent bean of the child class. please refer to 
	 * 'parent' attribute in 'yatish_config.xml'
	 *  
	 * Using this, we can initialize a parent bean with property values and then use it in child class. hence no need to simply use 'super()' in the constructor and do all the circus
	 * to initialize parent class properties.
	 * 
	 * There is no way to do this using annotations, this can be done only using xml file.
	 */
	@Autowired
	Child child;
	
	@RequestMapping("/AutowiredInheritence")
	public String getParentPorperty() {
		return child.printFromChild();
	}

}
