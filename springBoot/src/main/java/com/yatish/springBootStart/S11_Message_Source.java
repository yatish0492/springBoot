package com.yatish.springBootStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Consider you have lot of messages like success,warning or error messages to be sent back to UI based on conditions. consider you have 2000+ msgs to handle. you can have them all as
 * constants in a java file and use them. But is it good to have all message assigned to a static fields in a java file?
 * No!!!! is there any solution?
 * Yes!!!! we do have. using 'ResourceBundleMessageSource'
 * We can have all the messages in one or multiple properties file and use them. 'ResourceBundleMessageSource' provides that capability in spring. First we have to create an object of
 * 'ResourceBundleMessageSource' type and using that object we have to specify all the properties files from where you want the messages to be fetched using 'setBasenames()' method of the
 * object. then you can use 'getMessage()' function of the object to fetch the messages from the specified properties file.
 * eg: Checkout the 'MessageUtil' class.
 *
 */
@RestController
public class S11_Message_Source {

	@Autowired
	MessageUtil obj;
	
	@RequestMapping("/GetMessageSource")
	public String getResourceBundleMessageFromProperties() {
		return obj.getMessage();
	}

}

@Component
class MessageUtil {
	
	private ResourceBundleMessageSource messageSource;
	
	MessageUtil() {
		/*
		 * we are creating an object once when this bean initializes
		 * 
		 * NOTE: you have to manually create the object using 'new' keyword, you cannot use @Autowired to create a instance of 'ResourceBundlemessageSource' because if we use @Autowired
		 * 		The spring will try to look for xml configuration file or else classes with @Component/@Service etc to find the bean. since 'ResourceBundlemessageSource' is a library not
		 * 		a bean defined by use, spring will say it cannot find 'ResourceBundleMessageSource' bean.
		 */
		messageSource = new ResourceBundleMessageSource();
		/*
		 * Once we have the object of 'ResourceBundleMessageSource' we are providing the properties files, which the object has to scan through to get the message. we are providing the 
		 * properties files below using 'setBasenames()' method.
		 * 
		 * NOTE: we need not specify '.properties', just give the file name without '.properties' extension. you can specify n number of properties files ',' seperated.
		 * 
		 * NOTE: 'ResourceBundleMessageSource' will scan the properties files specified in sequential order. first it will scan 'variables.properties' file and then 'messages.properties'
		 * 		file and then 'ErrorMessages.properties file.
		 * 		In this example, i am trying to fetch the value of 'msg' from properties file. I have 'msg' property defined in two properties files 'messages.properties' and
		 * 		'ErrorMessages.properties'. in this case since it processes the properties files sequentially it will find the value of 'msg' in 'messages.properties' and then it wont go
		 * 		and check the 'ErrorMessages.properties' file at all hence we will always get the value of 'msg' from 'messages.properties'
		 * 
		 * 
		 */
        messageSource.setBasenames("variables","messages","ErrorMessages");
        messageSource.setDefaultEncoding("UTF-8");	
	}
	
	public String getMessage() {
		/*
		 * The first parameter we are sending in a string 'msg' is nothing but a key value to search in the properties files.
		 * 
		 * 
		 * In the below 'getMessage()' we see that we are sending second parameter as null. what is that parameter?
		 * it is arguments to the value found in properties file.
		 * eg: in properties file we can also specify property as 'WelcomeMessage=Hi {0} welcome to {1}'
		 * 		in this function instead of 'return messageSource.getMessage("msg", null,Locale.getDefault());' you can place below code,
		 * 		String[] array = new String[2];
				array[0] = "Yatish";
				array[1] = "Spring Boot";
				return messageSource.getMessage("WelcomeMessage",array,Locale.getDefault());
				
				in above example, we are sending array of strings, the first element in the array will be substituted in the place of {0} and correspondingly second array element will b
				substituted in the place of {1}. Hence our final string retured will be 'Hi Yatish welcome to Spring Boot'
				
		 * 
		 * What is that 3rd argument sent? that Locale thing?
		 * we have to send the Locale of the value we are going to fetch from the properties files, like 'Locale.CHINESE','LOCALE.CANADA' etc.
		 * 
		 * What is the use of this setting Locale here?
		 * This is very helpful in achieving 'localization/internationalization'. we just needs to add the specific locale properties files like here i have created 'messages_en_US.properties'
		 * and 'messages_zh_CN.properties' etc. if i give locale as 'Locale.ENGLISH', Then the 'ResourceBundleMessageSource' will search for 'variables_en_US.properties' file. if it is not
		 * present then it will search for 'variables.properties' file. in that it will search for 'msg' property. since it is not present then it will search for 'messages_en_US.properties'
		 * file. since it is present, it will search for 'msg' property in it and fetches the value of the property from it. if 'messages_en_US.properties' was not present then it would got and
		 * search for 'messages.properties' and goes on.
		 * Consider if 'variables.properties' file had 'msg' property then. it will not goto 'messages_en_US.properties' to fetch 'msg' property since it finds 'msg' property in
		 * 'variables.properties' file itself.
		 * 
		 * What does Locale.getDefault() return?
		 * It will return the default locale set in JVM of the server.
		 * 
		 * If we use the Locale.getDefault(), consider server is hosted in USA, and the default locale of server JVM instance is 'en_US'. if accessing this server from china, then server will
		 * show them the UI in english only as Locale.getDefault() will give 'en_US' even if user is accessing from china?
		 * Yes that problem is there. for this you can pass a locale of browser as parameter in the REST calls and use that parameter as locale in 'getMessage()' method.
		 * 
		 * In AngularJS and all we can do localization right? then we need to all this circus with this?
		 * if you recieve any response from the server for a REST call in English. you cannot localize those responses in angularJS. hence all those server response messages should be localized
		 * in server only. hence it is very handly for serverside localization.
		 * 
		 * Consider, i am looking for a property, if that property is not present in any of the properties files, then i don't want to get an internal server error, instead i want the
		 * response to be a string saying 'No value found for this property'. can we do that?
		 * Yes!!!!
		 * for that we need to pass one more argument before locale argument as shown in below example.
		 * 		return messageSource.getMessage("msg123",null,"No value found for this property",Locale.CANADA);
		 * 
		 */
		return messageSource.getMessage("msg", null,Locale.getDefault());
		
	}
	
}
