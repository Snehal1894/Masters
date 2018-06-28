/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmc;

import java.util.Random;

/**
 *
 * @author snehal
 */
public class MCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         double En,Eo,E,xn,xo,x,te=0,T,dx=10,cnt=0,navg=0,oavg=0,avg=0,b;
         
        x=0;
        E=Energy(x);
        T=1;
        b=1/T;
        xo=x;
        Eo=E;
        Random r = new Random();
        
        
        for(int i=1;i<=100000;i++)
        {
            
           double d = r.nextDouble();
            System.out.println(d);
             xn=xo+dx*(d-0.5);
            
            En=Energy(xn);
            
            if(En <= Eo)
            {
                xo=xn;
                Eo=En;
            }
            else
            {
                if(d < Math.exp(-(En-Eo)*b))
                {
                   xo=xn; 
                   Eo=En;
                  
                }
            }
            te=te+Eo;
            avg=te/i;
            
            
            
            System.out.println("Avg E:"+avg);
        }
    }
    public static double Energy(double x)
    {
        double E = 0.1*x*x;
        return E;
    }
    
}
