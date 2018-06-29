package com.yatish.pojos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Human {

	public String printHuman() {
		return "human";
	}

}
