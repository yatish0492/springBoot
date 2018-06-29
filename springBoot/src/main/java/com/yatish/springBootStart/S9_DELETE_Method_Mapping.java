package com.yatish.springBootStart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S9_DELETE_Method_Mapping {

	@RequestMapping(method=RequestMethod.DELETE,value="/delete")
	public void deleteMethod() {
		//Delete Code
	}
	

}
