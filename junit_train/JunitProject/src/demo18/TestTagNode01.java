

package demo18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTagNode01 {
	
	@Test
	public void testNode()
	{
		String expected = "<orders/>";
		TagNode orders = new TagNode("orders");
		assertEquals("orders xml", expected, orders.toString());
		
		// add a couple of attributes
		orders.addAttribute("Date", "20130204");
		orders.addAttribute("OrderCount", "453");
		assertEquals("<orders Date=\"20130204\" OrderCount=\"453\"/>",orders.toString());

		assertEquals("20130204", orders.getAttributeNamed("Date"));
		assertEquals("453", orders.getAttributeNamed("OrderCount"));
		assertEquals(2,orders.attributes.size());
		
		expected =
		"<orders Date=\"20130204\" OrderCount=\"453\">" +
			"<order number=\"123\">" +
			"carDoor" + 
			"</order>" +
		"</orders>";

		TagNode order  = new TagNode("order");
		order.addAttribute("number", "123");
		order.addValue("carDoor");
		orders.add(order);
		assertEquals("orders xml", expected, orders.toString());
		
		String EXPECTED_VALUE = "a value";
		orders.addValue(EXPECTED_VALUE);
		assertEquals(EXPECTED_VALUE, orders.getValue());
	 	  
		orders.add(new TagNode("order1"));
		orders.add(new TagNode("order2"));
		orders.add(new TagNode("order3"));
		
		TagNode order4 = new TagNode("order4");
		order4.add(new TagNode("order4-child"));
		orders.add(order4);
		
		//assertEquals(5,orders.children.size());
		assertEquals(5,orders.children.size());
		assertEquals("order4",orders.children.get(4).getName());
		assertEquals("order4-child",orders.children.get(4).children.get(0).getName());
	}
}
