package demo04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLargest {

	@Test
	public void testSimple_allzhengshu() {
		assertEquals(" Failure Messages ",9, Largest.largest(new int[]{7,8,9}));		
	}
	
	@Test
	public void testSimple_fushuAndzhengshu() {
		assertEquals(" Failure Messages ",8, Largest.largest(new int[]{7,8,-9}));		
	}
	
	@Test
	public void testSimple_twoSame() {
		assertEquals(" Failure Messages ",800, Largest.largest(new int[]{77,800,800}));		
	}
	
	@Test
	public void testSimple_zhengshu_zero_fushu() {
		assertEquals(" Failure Messages ",3, Largest.largest(new int[]{3,0,-9}));		
	}
	
	@Test
	public void testSimple_zhengshu_zero_fushu() {
		assertEquals(" Failure Messages ",3, Largest.largest(new int[]{3,}));		
	}
	
	@Test
	public void testSimple_fushuAndZero() {
		assertEquals(" Failure Messages ",0, Largest.largest(new int[]{-3,0,-9}));		
	}
	
	@Test
	public void testSimple_allFushu() {
		assertEquals(" Failure Messages ",-3, Largest.largest(new int[]{-3,-11,-9}));		
	}
	
	@Test
	public void testSimple7() {
		assertEquals(" Failure Messages ",-3, Largest.largest(new int[]{-3,-3,-3}));		
	}
	
	@Test
	public void testSimple_sameFushu() {
		assertEquals(" Failure Messages ",-3, Largest.largest(new int[]{-3,-3,-3}));		
	}
	
	@Test
	public void testSimple_allZero() {
		assertEquals(" Failure Messages ",0, Largest.largest(new int[]{0,0,0,0,0}));		
	}
	
	@Test
	public void testSimple_maxValue() {
		assertEquals(" Failure Messages ",Integer.MAX_VALUE, Largest.largest(new int[]{3,Integer.MAX_VALUE,-3,-3}));		
	}
	
	@Test
	public void testSimple_minValue() {
		assertEquals(" Failure Messages ",3, Largest.largest(new int[]{3,Integer.MIN_VALUE,-3,-3}));		
	}
	
	@Test
	public void testSimple_error() {
		assertEquals(" Failure Messages ",97, Largest.largest(new int[]{'a',Integer.MIN_VALUE,-3,-3}));		
	}
	
	@Test
	public void testSimple_errorNull() {
		assertEquals(" Failure Messages ",1, Largest.largest(new int[]{NULL,Integer.MIN_VALUE,-3,-3}));		
	}
}  
