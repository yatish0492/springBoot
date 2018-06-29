package com.yatish.springBootStart;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S12_RequestMapping_Locale {

	/*
	 * Sometimes we need the locale of the browser for some reasons like localization etc. In that case, there is no need for the user to find the browser locale in UI scripts and send 
	 * it as a parameter in all the REST calls made to the server!!!! Spring makes us life easy. if we just specify a parameter in the @RequestMapping function with type as 'Locale', the
	 * browser locale will be assigned to that variable, even though user didn't send a browser locale parameter in the REST call explicitly.
	 * 
	 * This works with all '@RequestMapping' functions, irrespective of the method like GET/POST/DELETE etc.
	 * 
	 * 
	 */
	@RequestMapping("/getBrowserLocale")
	public String printLocale(Locale browserLocale) {
		System.out.println("The browser locale is - " + browserLocale);
		return browserLocale.toString();
	}

}
