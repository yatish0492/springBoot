package com.yatish.springBootStart;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_7_Resource {

	/*
	 * @Resource is also same as @Autowired. but is is not provided by spring. It is provided by JSR-250. which was provided by java. Like @Autowired, @Resource can be used on Fields,
	 * Methods constructors etc. Almost same functionality as @Autowired
	 * 
	 * of course there are few differences between them.
	 * 1) @Autowired uses 'AutowiredAnnotationBeanPostProcessor', where as @Required uses 'CommonAnnotationBeanPostProcessor'. even though they have different post processors. they behave
	 * 		almost identical.
	 * 
	 * 2) The order it looks for binding the bean of @Autowired is as follows,
	 * 		a) first it looks to bind byType
	 * 		b) if byType it cannot bind then it will try to bind byName
	 * 		c) If byName also it cannot bind then it will search for qualifier if present and bind using it.
	 *    The order it looks for binding the bean of @Resource is as follows,
	 * 		a) first it looks to bind byName
	 * 		b) if byName it cannot bind then it will try to bind byType
	 * 		c) If byType also it cannot bind then it will search for qualifier if present and bind using it.
	 *    Hence @Autowired first tries to bind byType then byName. But @Resource first tries to bind byName and then byType
	 *    
	 * 3) If we try to do bind byName in @Autowierd annotation we have to make sure that the field/property name should be same as the 'id' we give in xml file, consider if user doesn't
	 *  	want to give that name to the field/property. he want to give some other name and he want to do bind byName. How can you do in @Autowired?
	 *    There is no way!!!!! we have to give the field name as same as id to bind byName otherwise there is no way. But @Required provides the solution. @Required supports one property
	 *    called 'name' with it. in which we can specify the 'id' of the bean and we can give whichever the name we want to the field/peroperty of class.
	 *    eg:
	 *    	<bean id="obj" ........../>
	 *    
	 *    @Resource(name="obj")
	 *    private Pencil myPencil;      --> here spring will search for a bean with 'id' as 'obj' and binds it. it doesn't consider 'myPencil' for binding byName
	 *    
	 *    @Autowired doesn't allow this 'name' property
	 */
	@Resource	
	private Pencil obj;

	@RequestMapping("/printResourceBindedObject")
	public String printResourceBindedObject() {
		return obj.name;
	}

}
	
@Component
class Pencil {
	
	@Value("PencilName printed")
	String name;
	
}
