package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Bike;

@RestController
public class S4_4_Qualifier_xml_multiple_bean_for_same_class {

	/*
	 * @Qualifier is used to identify a bean, among many beans of same type.
	 * 
	 * eg: in this case, the Bike class has 2 beans defined in the 'yatish-config.xml'. So spring will get confused like which bean to select. To solve this ambiguity, 
	 * 		we specify an 'id' or 'qualifier' to the bean when we declare in 'yatish-config.xml'(refer to the <bean> tag of Bike type), now we need to tell  @Autowired to get a bean
	 * 		some identifier. how to tell that identifier to @Autowired!!!! that is where spring gave us @Qualifier, we specify the identifier of the bean, which we want to get using 
	 * 		@Qualifier as shown below.
	 * 		
	 */
	@Autowired
	@Qualifier("suzuki")
	private Bike obj;

	@RequestMapping("/bikeModel")
	public String printAge() {
		return obj.printModel();
	}

}
