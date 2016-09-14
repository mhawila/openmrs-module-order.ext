package org.openmrs.module.order.ext;

import org.openmrs.api.OrderContext;
import org.openmrs.api.OrderNumberGenerator;
import org.openmrs.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderEntry.CheckDigitOrderNumberGenerator")
public class CheckDigitOrderNumberGenerator implements OrderNumberGenerator {
	
	public static final String ORDER_NUMBER_PREFIX = "ORDER";
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public String getNewOrderNumber(OrderContext orderContext) {
		StringBuilder sb = new StringBuilder(ORDER_NUMBER_PREFIX);
		sb.append(orderService.getNextOrderNumberSeedSequenceValue());
		
		Integer checkDigit = checkDigit(sb.toString());
		return sb.append(checkDigit).toString();
	}
	
	private Integer checkDigit(String idWithoutCheckdigit) {
		
		// remove leading or trailing whitespace, convert to uppercase
		idWithoutCheckdigit = idWithoutCheckdigit.trim().toUpperCase();
		
		// this will be a running total
		int sum = 0;
		
		// loop through digits from right to left
		for (int i = 0; i < idWithoutCheckdigit.length(); i++) {
			
			//set ch to "current" character to be processed
			char ch = idWithoutCheckdigit.charAt(idWithoutCheckdigit.length() - i - 1);
			
			// our "digit" is calculated using ASCII value - 48
			int digit = (int) ch - 48;
			
			// weight will be the current digit's contribution to the running total
			int weight;
			if (i % 2 == 0) {
				weight = (2 * digit) - (int) (digit / 5) * 9;
				
			} else {
				weight = digit;
			}
			
			// keep a running total of weights
			sum += weight;
		}
		
		// avoid sum less than 10 (if characters below "0" allowed, this could happen)
		sum = Math.abs(sum) + 10;
		
		// check digit is amount needed to reach next number divisible by ten
		return (10 - (sum % 10)) % 10;
	}
}
