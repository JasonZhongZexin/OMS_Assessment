package au.edu.uts.wsd.soap;

import uts.wsd.Formula;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Spring 2018
 * @author George
 */
@WebService(serviceName = "Calculator")
public class Calculator {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName = "factorial")
    public int getFactorial(@WebParam(name = "n") int n) {
        return new Formula(n).getFactorial();
    }    
    @WebMethod(operationName="logarithm")
    public double getLogarithm(@WebParam(name = "n") int n){
        return new Formula(n).getLogarithm();
    }
    @WebMethod(operationName="squareroot")
    public double getSquareroot(@WebParam(name = "n") int n){
        return new Formula(n).getSquareroot();
    }
    @WebMethod(operationName="exponent")
    public double getExponent(@WebParam(name = "n") int n){
        return new Formula(n).getExponent();
    }
}
