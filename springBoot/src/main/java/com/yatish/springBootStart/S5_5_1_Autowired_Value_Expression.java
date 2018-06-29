package com.yatish.springBootStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S5_5_1_Autowired_Value_Expression {

	@Autowired
	ValueExpressionBean obj;
	
	@RequestMapping("/ValueWithExpression")
	public String getValueWithExpressions() {
		return "Is the NumberBean greater than 10 - " + obj.isNumberBeanGreaterThanTen + "  isNumberGreaterThanTenAndEqualToTwelve -" + obj.isNumberGreaterThanTenAndEqualToTwelve;
	}

}

@Component("numberB")
class NumberBean {
	
	/*
	 * even though if you are assigning a primitive type integer to the field, you have to specify it within double quotes.
	 */
	@Value("12")
	public int num;
}

@Component
class ValueExpressionBean {
	
	/*
	 * we can refer to some other beans field/property values and do some operation and initialize the values to this class field/properties.
	 * eg: refer to @Value of 'isNumberBeanGreaterThanTen' and 'isNumberGreaterThanTenAndEqualToTwelve' fields.
	 */
	@Value("#{numberB.num > 10}")
	boolean isNumberBeanGreaterThanTen;
	
	@Value("#{numberB.num > 10 and numberB.num == 12}")
	boolean isNumberGreaterThanTenAndEqualToTwelve;
}
