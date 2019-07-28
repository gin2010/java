package demo01;


public class Calculator
{
    public double add( double number1, double number2 )
    {
        return number1 + number2;
    }
        
       
    public double sub( double number1, double number2 )
    {
        return   number1 - number2;
    }
    
    public int multiply(int x, int y) {
        // the following is just an example
        //if (x > 999) {
        //  throw new IllegalArgumentException("X should be less than 1000");
       // }
        return x * y;
      }
    
    public double div( double number1, double number2 )
    {
    	//
        return number1 / number2;
    }
}
