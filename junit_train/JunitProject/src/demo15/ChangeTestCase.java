package demo15;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeTestCase {

	@Test
	public void testChange() {
		//测试1～9数字是否正确
		assertEquals("人民币壹亿贰仟叁佰肆拾伍万陆仟柒佰捌拾玖元壹角贰分",Change.changeNumberRMB(123456789.12));
		//没有小数应该是整结尾
		assertEquals("人民币壹亿贰仟叁佰肆拾伍万陆仟柒佰捌拾玖元整",Change.changeNumberRMB(123456789));
		
		assertEquals("人民币壹仟肆佰零玖元伍角",Change.changeNumberRMB(1409.50));
		assertEquals("人民币陆仟零柒元壹角肆分",Change.changeNumberRMB(6007.14));
		assertEquals("人民币壹拾万柒仟元伍角叁分",Change.changeNumberRMB(107000.53));
		
		assertEquals("人民币叁佰贰拾伍元零肆分",Change.changeNumberRMB(325.04));
	}
}
