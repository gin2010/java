package demo15;

import java.text.DecimalFormat;

public class Change {
	private static final String digit_0 = "��Ҽ��������½��ƾ�";
	private static final String digit_1 = "��һ�����������߰˾�";
	private static final String[] digit_2 = { "", "ʮ", "��", "ǧ" };
	private static final String[] digit_3 = { "", "ʰ", "��", "Ǫ" };
	private static final String[] digit_4 = { "", "��", "��", "����", "����" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(changeDigit("2012.12", false));
		System.out.println(changeDigit("210.12", true));
		System.out.println(changeNumberRMB(200010.1662));
	}

	/**
	 * Description: ����ת��������
	 * 
	 * @param str
	 * @param bo
	 * @return
	 */
	public static String changeDigit(String str, boolean bo) {
		StringBuffer strbu = new StringBuffer();
		int dou = str.indexOf(".");
		// :�ж��Ƿ�ΪС����������������С����Ϊ����
		if (dou < 0) {
			dou = str.length();
		}
		// :��ȡ��������
		String inter = str.substring(0, dou);
		strbu.append(changeInteger(Long.parseLong(inter), bo));
		// :����С������
		if (dou != str.length()) {
			strbu.append("��");
			// :��ȡС�����������
			String xh = str.substring(dou + 1);
			for (int i = 0; i < xh.length(); i++) {
				if (bo) {
					strbu.append(digit_0.charAt(Integer.parseInt(xh.substring(
							i, i + 1))));
				} else {
					strbu.append(digit_1.charAt(Integer.parseInt(xh.substring(
							i, i + 1))));
				}
			}
		}
		String strs = strbu.toString();
		// :����������������ܲ�ȫ
		if (strs.startsWith("��")) {
			strs = strs.substring(1);
		}
		if (strs.startsWith("һʮ")) {
			strs = strs.substring(1);
		}
		while (strs.endsWith("��")) {
			strs = strs.substring(0, strs.length() - 1);
		}
		if (strs.startsWith("��")) {
			strs = "��" + strs;
		}
		if (strs.endsWith("��")) {
			strs = strs.substring(0, strs.length() - 1);
		}
		return strs;
	}

	/**
	 * λ��С��4ʱ�����ô�������
	 * 
	 * @param str
	 * @param bo
	 * @return
	 */
	public static String readNumber(String str, boolean bo) {
		StringBuffer strbu = new StringBuffer();
		if (str.length() != 4) {
			return null;
		}
		for (int i = 0; i < 4; i++) {
			char ch = str.charAt(i);
			if (ch == '0' && i > 1 && str.charAt(i - 1) == '0') {
				continue;
			}
			if (ch != '0' && i > 1 && str.charAt(i - 1) == '0') {
				strbu.append('��');
			}
			if (ch != '0') {
				if (bo) {
					strbu.append(digit_0.charAt(ch - 48));
					strbu.append(digit_3[4 - i - 1]);
				} else {
					strbu.append(digit_1.charAt(ch - 48));
					strbu.append(digit_2[4 - i - 1]);
				}
			}
		}
		return strbu.toString();
	}

	/**
	 * ��������ת����д
	 * 
	 * @param lon
	 * @param bo
	 * @return
	 */
	public static String changeInteger(long lon, boolean bo) {
		StringBuffer strbu = new StringBuffer();
		// :����3λ��,Ϊ����ɴ�дת��
		String strN = "000" + lon;
		int strN_L = strN.length() / 4;
		// :���ݲ�ͬ��λ�����ȣ�����strN"0"�ĸ���
		strN = strN.substring(strN.length() - strN_L * 4);
		for (int i = 0; i < strN_L; i++) {
			String s1 = strN.substring(i * 4, i * 4 + 4);
			String s2 = readNumber(s1, bo);
			strbu.append(s2);
			if (s2.length() != 0) {
				strbu.append(digit_4[strN_L - i - 1]);
			}
		}
		String s = new String(strbu);
		if (s.length() != 0 && s.startsWith("��"))
			s = s.substring(1);
		return s;
	}

	/**
	 * �����������ʽ
	 * 
	 * @param rmb
	 * @return
	 */
	public static String changeNumberRMB(double rmb) {
		String strRMB = "" + rmb;
		DecimalFormat df = new DecimalFormat("#.#");
		df.setMaximumFractionDigits(2);
		strRMB = df.format(rmb).toString();
		// :true����Ҵ�д������������
		strRMB = changeDigit(strRMB, true);
		if (strRMB.indexOf("��") >= 0) {
			strRMB = strRMB + "��";
			strRMB = strRMB.replaceAll("��", "Ԫ");
			String str1 = strRMB.substring(0, strRMB.indexOf("Ԫ") + 1);
			String str2 = strRMB.substring(strRMB.indexOf("Ԫ") + 1);
		    System.out.print(str2.charAt(1));
		    if(str2.charAt(1)=='��'){
		    	strRMB = str1 + str2.charAt(0) + "��";
		    }else if (str2.charAt(0)=='��'){
		    	strRMB = str1 + str2.charAt(0) +  str2.charAt(1) + "��";
		    }else{
		    	strRMB = str1 + str2.charAt(0) + "��" + str2.charAt(1) + "��";
		    }							
		} else {
			strRMB = strRMB + "Ԫ��";
		}
		return "�����" + strRMB;
		//return "" + strRMB;
	}

}
