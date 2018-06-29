package com.yatish.pojos;

import org.springframework.beans.factory.annotation.Required;

public class Bike {

	String name;

	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	public String printModel() {
		return name;
	}

}
