package com.yatish.springBootStart;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S13_2_EventHandling_EventPublisher implements ApplicationEventPublisherAware{

	/*
	 * This program shows, how we can publish/trigger an event, so that Event Listener(S13_EventHandling_EventListener.java) will catch this event.
	 */
	
	/*
	 * we need to first have a field/property of type 'ApplicationEventPublisher' in the class from which we want to publish an event. this field is used to publish the events.
	 */
	private ApplicationEventPublisher publisher;
	
	/*
	 * we need to write a setter method for the 'ApplicationEventPublisher' field/property.
	 * 
	 * So do we need to call this setter explicitly before we can use this?
	 * No!!! shocked.
	 * you need not set this property explicitly. spring will call this setter function and set the 'ApplicationEventPublisher' field/property. hence we need not call this function and 
	 * set this property.
	 */
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		System.out.println("Event pushlisher is initialized: " + publisher.toString());
		this.publisher = publisher;		
	}
	
	
	@RequestMapping("/publishEvent")
	public void publishEvent() {
		
		/*
		 * we are creating an object of custom event here. as we can see we are sending 'this' as the argument to the constructor. this will be sent to the event super class 
		 * 'ApplicationEvent' constructor. 
		 */
		S13_1_EventHandling_Event event = new S13_1_EventHandling_Event(this);
		
		/*
		 * Here, we are publishing the custom event we created using '.publishEvent()' method of 'ApplicationEentPublisher' field/property. The Event Listener will be invoked for this
		 * trigerred event.
		 */
		publisher.publishEvent(event);
		System.out.println("Event has been published");
	}	

}
