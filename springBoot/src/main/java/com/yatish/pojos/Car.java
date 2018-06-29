package com.yatish.pojos;

public class Car {

	String model;
	String company;
	int yearOfMake;
	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	Car() {}
	
	Car(String model,String company) {
		this.model = model;
		this.company = company;
	}
	
	Car(String model,int yearOfMake) {
		this.model = model;
		this.yearOfMake = yearOfMake;
	}
	
	public String printCarModel() {
		return model + " " + company + " " + yearOfMake;
	}
	
	public void abc() {
		System.out.println("abc : Init Method has been called for class Car");
	}

}
