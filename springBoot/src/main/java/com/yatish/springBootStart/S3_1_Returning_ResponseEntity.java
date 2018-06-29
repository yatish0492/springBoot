package com.yatish.springBootStart;

import com.yatish.pojos.Student;

@RestController
public class S3_1_Returning_ResponseEntity {

	@RequestMapping("/returnObjectList1")
	public ResponseEntity<Student> returnObjectListExample() {		//The function name can be anything, nothing like it should be same as the request map
		Student s1 = new Student("yatish",25);
		
		return new ResponseEntity<Student>(s1, 200);
	}

}
