package demo20;

public class Triangle {
	/**
	 * �ж������ε����ࡣ���� a, b, c �ֱ�Ϊ�����ε����ߣ�
     * 
	 *  ���صĲ���ֵ
	 *  Ϊ 0 ����ʾ�������Σ�
	 *  Ϊ 1����ʾ��ͨ�����Σ� 
	 *  Ϊ 2 ����ʾ���������Σ�
	 *  Ϊ 3 ����ʾ�ȱ������Ρ�
	 */
	public static int comfirmTriangle(int a, int b, int c) {
		
			return 0;		
	}
	
	public static int isTriangle(int a, int b, int c){
		if ((a+b>c) && (a+c>b) && (b+c>a)){
			if ((a==c) && (a==b) ){
				return 3;}
			else if ((a==c) || (a==b) || (b==c)){
				return 2;}
			else{
				return 1;
			}	
		}
		else{
			return 0;
		}
	
	 }

}
