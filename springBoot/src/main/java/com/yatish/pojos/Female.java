package com.yatish.pojos;

public class Female {

	String name;
	String friendName;
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		System.out.println("Female friendName initialized using setter method, name is :" + friendName);
		this.friendName = friendName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Female name initialized using setter method, name is :" + name);
		this.name = name;
	}
	
	public String printName() {
		return name + " " + friendName;
	}

}
