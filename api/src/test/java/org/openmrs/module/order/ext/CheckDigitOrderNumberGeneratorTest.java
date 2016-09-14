package org.openmrs.module.order.ext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.api.OrderService;
import org.openmrs.test.Verifies;

import static org.mockito.Mockito.when;

public class CheckDigitOrderNumberGeneratorTest {
	
	@InjectMocks
	private CheckDigitOrderNumberGenerator generator;
	
	@Mock
	private OrderService orderService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(orderService.getNextOrderNumberSeedSequenceValue()).thenReturn(2L);
	}
	
	@Test
	@Verifies(value = "Should generate the right next order number with check digit", method = "getNewOrderNumber")
	public void should_GenerateRightNextOrderNumber() {
		Assert.assertEquals("ORDER21", generator.getNewOrderNumber(null));
	}
}
