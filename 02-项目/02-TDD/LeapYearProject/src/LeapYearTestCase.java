
import static org.junit.Assert.*;

import org.junit.Test;

public class LeapYearTestCase {

	/*
	 * 
	 * ��20���ͺ�21���ͣ�����һ���б����������:
      1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948,
      1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 
      2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 
      2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096
	 */
	
	@Test
	public void TestThat_IsLeapYear()
    {
		
		//  ��һ����ʵ��  1996�ǵ��͵�����
        int typicalLeapYear = 1996;
        boolean isLeapYear = LeapYearCalculator.isLeapYear(typicalLeapYear);
        assertTrue(isLeapYear);
        
        
		/*
        int typicalCommonYear  = 2001;        
        isLeapYear = LeapYearCalculator.isLeapYear(typicalCommonYear);
        assertFalse(isLeapYear);     
        */
        
		/*
        int atypicalLeapYear   = 2000;        
        isLeapYear = LeapYearCalculator.isLeapYear(atypicalLeapYear );
        assertTrue(isLeapYear); 
        */
		
		/*
        int atypicalCommonYear    = 1900;        
        isLeapYear = LeapYearCalculator.isLeapYear(atypicalCommonYear  );
        assertFalse(isLeapYear);     
        */
    } 
}

