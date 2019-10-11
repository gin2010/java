package demo20;

public class Triangle {
	/**
	 * 判断三角形的种类。参数 a, b, c 分别为三角形的三边，
     * 
	 *  返回的参数值
	 *  为 0 ，表示非三角形；
	 *  为 1，表示普通三角形； 
	 *  为 2 ，表示等腰三角形；
	 *  为 3 ，表示等边三角形。
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
