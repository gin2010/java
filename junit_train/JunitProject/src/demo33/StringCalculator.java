package demo33;

public class StringCalculator {
	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public static int add(String numbers){		
		if(isNullorEmpty(numbers)){ 
			return 0;
		}		    		   
		String[] splitNumbers = split(numbers);
		return sum(splitNumbers);		
	} 
   
	private static boolean isNullorEmpty(String numbers) {
		return numbers==null || numbers.trim().equals("");
	}
 
	private static String[] split(String numbers) {
		String splitNumbers[]=numbers.split(",");
		return splitNumbers;
	}

	private static int sum(String[] splitNumbers) {
		int sum=0;
		for(String number:splitNumbers){
			int num=0;				
			num = toInt(number);
			
			if(num<=0)
				throw new IllegalArgumentException("��������Ϊ����!  ������"+num);
			if(num>1000)
				num=0;
			sum+=num;			
		}
		return sum;
	}
 
	private static int toInt(String number) {
		int num=0;
		try {
			num = Integer.parseInt(number);
		} catch (Exception e) {
			throw new IllegalArgumentException("�������ܺ��зǷ�����!  �Ƿ�������"+number);
		}
		return num;
	}
}
