package uts.wsd;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Formula implements Serializable{
    private int n;
    
    public Formula(){super();}
    public Formula(int n) {super(); this.n = n;}

    @XmlElement
    public int getN() {return n;}

    public void setN(int n) {this.n = n;}
    
    public int multiply(int a, int b){
        int x = 1;
        for(int i=a; i<=b; i++)
            x *=i;
        return x;
    }
    
    @XmlElement
    public int getFactorial(){return multiply(1,n);}
    
    @XmlElement
    public double getSquareroot(){return Math.sqrt(n);}
    
    @XmlElement
    public double getLogarithm(){return Math.log(n);}
    
    @XmlElement
    public double getExponent(){return Math.pow(Math.E, n);}
}