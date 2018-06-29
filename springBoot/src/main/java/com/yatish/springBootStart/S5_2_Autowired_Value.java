package com.yatish.springBootStart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_2_Autowired_Value {

	/*
	 * We have seen the initialization of the bean properties using <property> tag in xml configuration. How can we do it using annotations?
	 * We need to use @Value annotation to achieve this. as shown in the file, 'valueClass' propety 'name' is assigned a string value 'propertyInitialized' using @Value.
	 * 
	 * So whenever the 'valueClass' bean is created, the property value will be initialized.
	 * 
	 * We can also initialize the property value using a variable defined in a properties file.
	 * We have created a properties file under 'src/main/resources/variables.properties' in this file, a property variable is defined 'petNameValue'. In the 'valueClass' class we are 
	 * assigning it to 'petName' field.
	 * 
	 * NOTE: we have to specify the variable name within '${<property/variable_name>}' only
	 *  
	 * If the property is not found in properties file, in this example, if 'petNameValue' is not defined in 'variables.properties' file. in this case spring will throw an exception
	 * on start of the spring application.
	 * 
	 * I don't want spring to throw exception on spring application start, if the 'petNameValue' is not defined in 'variables.properties' file. Is there any way?
	 * Yes!!!! there is a way. spring provides a way to specify a default value, if the property is not defined in properties file.
	 * Checkout the 'childHoodName' field in 'valueClass' class. the 'childHoodNameValue' property is not defined in properties file 'variables.properties', but spring will not throw
	 * an exception, instead it will assign the default value 'pilli' to 'childHoodName' field in 'valueClass' class.
	 * 
	 * NOTE: Default value has to be provided after ':' within '${}'. eg: ${<property/variable_name> : <default_value>}
	 * 
	 * 
	 * 
	 * NOTE: the variable we use within '${}' need not be always defined within properties file. we can specify an environment variable also here. the value will be resolved.
	 * 
	 * We need to first tell spring to use 'variables.properties' file, before providing the variable/property names within '${}'. how do we do that?
	 * spring provides @PropertySource() annotation. we need to specify 'variables.properties' in this annotation so that spring will search this file when it sees a @Value with '${}'
	 * inside it.
	 * eg: @PropertySource("classpath:variables.properties")
	 * 
	 * Consider, I have a property by same variable name in environment variables and properties file, in that case which will spring consider to resolve the value?
	 * In this case, environment variables take highest precedence. when Spring sees '${}', it will first search all environment variables, if it cannot find the variable in them, then
	 * spring will search the properties file.
	 * eg: Environment variable -->   name="yatish"
	 * 	   In properties file -->  name="sharat"
	 * 						spring will resolve the value to "yatish" not "sharat"
	 * 
	 * 
	 * Consider have a collection as a field in class, can i initialize then using @Value?
	 * Yes!!! you can. Refer to 'NamesArray' field in 'valueClass' class.
	 * In properties file, we just need to give the array elements as coma(,) seperated.
	 * 
	 * NOTE : with the above one we are using '${names}' in @Value, if we do this way, the field has to be array of objects only. we cannot use this with field as list of objects. as
	 * it will throw an error.
	 * 
	 * So what if i want to initialize values from properties file to a list(collection) field?
	 * Don't worry, we have a solution!!!!   checkout 'listOfNames' field in 'valueClass' class. instead of just specifing the property 'name', we need to specify using some expression.
	 * like '#{<expression>}'. 
	 * we need to specify it with split function '#{'${names}'.split(',')}'. this can be used with array field also. we have liberty to split the value based on whichever the charecter
	 * we want. eg: i can split 'name' property value using '#' or anything.
	 * 
	 * 
	 * Consider, i have a bean initialized with some value, I want the same value to be assigned to this bean field, is that possible?
	 * Yes!!! refer to 'bikeName' field in 'valueClass' class. It is taking the value of 'name' field from a bean with id as 'gv650Bike' and assigning that value to this field.
	 * 
	 * We have seen that spring supports constructor injection and property injection. which type of injection does @Value do?
	 * We can do both of them using @Value. In this program we have demonstrated the value injection on field value.
	 *
	 */
	@Autowired
	valueClass obj;
	
	@RequestMapping("/nameValueAnnotation")
	public String getNameValueFromValueAnnotion() {
		return obj.name;
	}
	
	@RequestMapping("/petNameValueAnnotation")
	public String getPetNameValueFromValueAnnotion() {
		return obj.petName;
	}
	
	@RequestMapping("/childHoodNameValueAnnotation")
	public String getChildHoodNameValueFromValueAnnotion() {
		return obj.childHoodName;
	}
	
	@RequestMapping("/ArrayOfNamesValueAnnotation")
	public String getArrayOfNamesValueFromValueAnnotion() {
		return obj.NamesArray[0] + " " + obj.NamesArray[1] + " " + obj.NamesArray[2];
	}
	
	@RequestMapping("/ListOfNamesValueAnnotation")
	public String getListOfNamesValueFromValueAnnotion() {
		return obj.listOfNames.get(0) + " " + obj.listOfNames.get(1) + " " + obj.listOfNames.get(2);
	}
	
	@RequestMapping("/otherBeanFieldValueAnnotation")
	public String getOtherBeanFieldValueFromValueAnnotion() {
		return obj.bikeName;
	}

}


/*
 * Consider we have a constructor written in the 'valueClass' file. if i try to print the value of properties like 'name','petName' etc. that should work as expected right?
 * No!!!!
 * When a bean or object is created. the constructors are called first before 
 */
@Component
class valueClass {
	
	/*
	 * If we are using @Value on fields, then there is no mandate to have setter or getter for it. without them also it will work
	 */
	@Value("propertyInitialized")
	String name;
	
	@Value("${petNameValue}")
	String petName;
	
	@Value("${childHoodNameValue:pilli}")
	String childHoodName;
	
	@Value("${names}")
	String[] NamesArray;
	
	@Value("#{'${names}'.split(',')}")
	List<String> listOfNames;
	
	/*
	 * we can access a bean and use the value assigned to its field/property using its id directly without having @Autowired of that bean in this class.
	 * As shown in below @Value, we are just referring 'gv650Bike', which is the id of a bean. it will automatically fetch that bean and assign the name property here.
	 */
	@Value("#{gv650Bike.name}")
	String bikeName;
	
	
}
