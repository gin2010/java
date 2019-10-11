package demo15;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeTestCase {

	@Test
	public void testChange() {
		//����1��9�����Ƿ���ȷ
		assertEquals("�����Ҽ�ڷ�Ǫ������ʰ����½Ǫ��۰�ʰ��ԪҼ�Ƿ���",Change.changeNumberRMB(123456789.12));
		//û��С��Ӧ��������β
		assertEquals("�����Ҽ�ڷ�Ǫ������ʰ����½Ǫ��۰�ʰ��Ԫ��",Change.changeNumberRMB(123456789));
		
		assertEquals("�����ҼǪ�������Ԫ���",Change.changeNumberRMB(1409.50));
		assertEquals("�����½Ǫ����ԪҼ������",Change.changeNumberRMB(6007.14));
		assertEquals("�����Ҽʰ����ǪԪ�������",Change.changeNumberRMB(107000.53));
		
		assertEquals("��������۷�ʰ��Ԫ������",Change.changeNumberRMB(325.04));
	}
}
