package demo01;

public class StringCalculator {
	
	
	public int evaluate(String expression) {
        int sum = 0;
        if(expression==null){
        		return 0;
        }
        if(expression.trim().isEmpty()){
        		return 0;
        }
        for (String summand: expression.split("\\+"))
          sum += Integer.valueOf(summand);
        return sum;
      }
}
