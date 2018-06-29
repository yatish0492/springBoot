package com.yatish.springBootStart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.Student;

@RestController	//'RestController' annotation tells the spring application context, that The URL handlers are being written here in this class as methods
public class S3_ReturningObjectsFromController {

	/*
	 * Running this program doesnt help, you need to run the 'S1_SpringBootApplication.java' file as it has got the 'SpringApplication.run()', that will scan this class and registers the
	 * RestController. 
	 */
	
	/*
	 * How does it convert the object to json format?
	 * Internally, spring boot uses jaxson json parser to do this job.
	 */
	
	
	/*
	 * If we want to return a class objects as JSON, there is no need of converting into JSON objects using some JSON parsers and all.
	 * 
	 * If we just return a list of objects or just an object or anything, the SpringBoot takes care of converting them into the JSON structure before returning to browser
	 */
	@RequestMapping("/returnObjectList")
	public List returnObjectListExample() {		//The function name can be anything, nothing like it should be same as the request map
		Student s1 = new Student("yatish",25);
		Student s2 = new Student("Sharath",28);
		Student s3 = new Student("Gagan",25);
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		return list;
	}
	
	
}
