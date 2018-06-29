package com.yatish.springBootStart;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
 * Spring provides the interfaces to handle the events.
 * 
 * In this program, we are writing a event listener. it is a global event listener, whatever the events are being triggerred in the spring application, will following listener function will
 * be called.
 * 
 * Spring provides an interface 'ApplicationListener', we need to implement that interface on whichever the class we want it to act as a listener for all events. Then we have to implement
 * the interface method 'onApplicationEvent()'.
 */
@Component
public class S13_EventHandling_EventListener implements ApplicationListener {	//Implementing 'ApplicationListner' is mandatory.

	/*
	 * This function will be called whenever an Event is trigerred in the spring. The corresponding event will be passed as argument to this function. we can do whatever we want with that
	 * event inside this function.
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
	}

}
