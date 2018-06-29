package com.yatish.springBootStart;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_8_Inject {

	/*
	 * @Inject is same as that of @Autowired there is no difference at all.
	 * Both of them us same post processor 'AutowiredAnnotationBeanPostProcessor'. both of them first tries to do binding byType first and then byName and then by qualifier. 
	 * No difference at all functionality wise.
	 * 
	 * Only difference is @Inject is provided by java in JSR-250. not by spring.
	 * 
	 * Hence whatever the difference we find between @Resource and @Autowired applies for @Resource and @Autowired. Refer 's5_8_Resource' for differences.
	 * 
	 */
	@Inject
	private Pen obj;

	@RequestMapping("/printInjectedObjectField")
	public String printInjectedObjectField() {
		return obj.name;
	}

}
	
@Component
class Pen {
	
	@Value("PenName Printed")
	String name;
		
}
