package com.yatish.springBootStart;

public class S10_Applicaiton_Properties {

	/*
	 * Spring Boot requires some properties defined to start the application like,
	 * the server port number etc.
	 * 
	 * Spring boot comes with default properties for this, like the server port as 8000 etc.
	 * 
	 */

	
	/*
	 * Consider we don't want, server to run on 8000 port. we want it to run on 3000. how to do it?
	 * 
	 * This is where 'application.properties' file comes into picture. create a file 'application.properties'
	 * file under 'src/java/resources' and define 'server.port = 3000' in it. then while spring boot 
	 * application starts, the properties we define in 'application.properties' will be override the default
	 * properties like 'server.port = 8000' and server will be started with this port.
	 * 
	 * For the properties, which we dont define here, it will consider the default properties.
	 * 
	 * 
	 */
}