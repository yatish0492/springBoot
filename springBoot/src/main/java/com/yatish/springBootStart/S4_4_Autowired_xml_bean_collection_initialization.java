package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatish.pojos.CollectionOfThings;

@RestController
public class S4_4_Autowired_xml_bean_collection_initialization {

	/*
	 * Spring supports initialization of collections using XML file(yatish-config.xml). Refer to bean 'CollectionOfThings'
	 * 
	 * Spring supports following collections initialization,
	 * 1) List
	 * 2) Set
	 * 3) Map
	 * 
	 * 
	 */
	
	@Autowired
	CollectionOfThings collectionsObject;
	
	@RequestMapping("/CollectionsPrint")
	public String printCollections() {
		return collectionsObject.printCollections();
	}

}
