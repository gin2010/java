package demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	/*
	 * ��1+2��    ���� 3
        ��1+2+3+4��  ���� 10
         ����   ���� 0
         ��100+101+200��    ���� 401
           �����Ǻ��зǷ����ݣ�����  1+b+3 
	 */


	@Test
	  public void evaluatesExpression() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate("1+2+3");
	    assertEquals(6, sum);
	  }
	@Test
	  public void evaluatesExpression1() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate("1+2");
	    assertEquals(3, sum);
	  }
	@Test
	  public void evaluatesExpression2() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate("1+2+3+4");
	    assertEquals(10, sum);
	  }
	@Test
	  public void evaluatesExpression3() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate("1");
	    assertEquals(1, sum);
	  }
	@Test
	  public void evaluatesExpression4() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate(" ");
	    assertEquals(0, sum);
	  }
	@Test
	  public void evaluatesExpression5() {
		StringCalculator calculator = new StringCalculator();
	    int sum = calculator.evaluate(null);
	    assertEquals(0, sum);
	  }
}
