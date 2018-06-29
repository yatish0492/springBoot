package com.yatish.springBootStart;

import org.springframework.context.ApplicationEvent;


/*
 * If user wants to throw his own custom event. then how will he throw?
 * The user needs to first create a custom event first. User can create custom events using 'ApplicationEvent' class provided by spring. you need to extend the class which you want to act
 * as custom event with 'ApplicationEvent'. then you need write a parameterized constructor and call super class parameterized constructor and pass the argument to it. it is mandatory.
 * 
 * What is that 'sourceObject', which we are passing to this constructor and from this to super constructor?
 * That is the object from which this event is being trigerred. refer to 'S13_2_EventHandling_EventPublisher.java' to know about what parameter is passed while triggering this custom 
 * event.
 */
public class S13_1_EventHandling_Event extends ApplicationEvent {
	
	/*
	 *  this is mandatory, you have to have this constructor because, the parent class 'ApplicationEvent' has a parameterized constructor defined with one parameter and it doesnt have a
	 *  non-parameterized constructor. hence from this class we have to call that parameterized constructor of parent compulsorily to instantiate it. hence 'super(sourceObject)'
	 *  has to called mandatorily in the constructor of this class.
	 *  
	 *  We can simply call the parent constructor simply from a non-parameterized constructor of this class right?
	 *  No. because consider you write something like as follows,
			    public S13_1_EventHandling_Event(){		
					super(someObject);
				}
		in this case, you need to send the object of the class, which is trigerring this event to the parent class constructor as argument. to get the object of the class, which is trigerring
		this event, we need that object to be passed to this event class right so. we need to do it as in this class constructor.
	 *  
	 */
	public S13_1_EventHandling_Event(Object sourceObject){		
		super(sourceObject);
	}
	
	public String toString() {
		return "Custom Event";
	}

}
