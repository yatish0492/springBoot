package com.yatish.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionOfThings {

	List<String> names = new ArrayList<String>();
	int[] ages = new int[10];
	Set<Bike> bikes = new HashSet<Bike>();
	
	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Set<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(Set<Bike> bikes) {
		this.bikes = bikes;
	}
	
	public int[] getAges() {
		return ages;
	}
	
	public void setAges(int[] ages) {
		this.ages = ages;
	}
	
	public String printCollections() {
		return "names" + names.get(0) + "," + names.get(1);
	}
	

}
