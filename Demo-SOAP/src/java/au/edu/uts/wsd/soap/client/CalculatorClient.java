package au.edu.uts.wsd.soap.client;

/**
 * Spring 2018
 * @author George
 */
public class CalculatorClient {
    public static void main(String[] args){
        int n = CalculatorClient.getN();
        new CalculatorClient().calculate(n);
    }

    Calculator_Service locator = new Calculator_Service();
    Calculator ms = locator.getCalculatorPort();
    
    public CalculatorClient() { }
    
    public static int getN() {
        System.out.print(" N = ");
        return In.nextInt();
    }
    private void show(String action, double result) {
        System.out.println(action + " = " + result);
    }
    private void calculate(int n) {
        show("factorial", ms.factorial(n));
        show("squareroot", ms.squareroot(n));
        show("logarithm", ms.logarithm(n));
        show("exponent", ms.exponent(n));
    }    
}
