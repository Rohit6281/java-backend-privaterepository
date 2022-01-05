package exception;

public class NumDivider {
    public double divideNumbers(double num1,double num2){
        if(num2==0)
            return 0;
        return num1/num2;
    }
    public double divideNumbersException(double num1,double num2) {
        if (num2 == 0) throw new BadNumberException("num is 0");
        return num1 / num2;
    }
    public void  divideNumberHandle (double num1, double num2){
        try{
            double res =num1/num2;

        }
        catch (ArithmeticException e)
        {
            double res=0;
        }
        catch (RuntimeException e){

        }
        catch (Exception e){

        }
        finally{

        }
    }

}
