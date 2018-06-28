/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.util.Random;

/**
 *
 * @author snehal
 */
public class MonteCarlo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double En,Eo,E,xn,xo,x,te,T,dx=10,cnt=0,avg=0;
        Random r = new Random();
        x=0;
        E=0.1*x*x;
        te=0;
        T=0.1;
        xo=x;
        Eo=E;
        double d = r.nextDouble();
        System.out.println(d);
        for(int i=1;i<=10;i++)
        {    
            //double d = r.nextDouble();
            //System.out.println(d);
            xn=x+dx*(d-0.5);
            //System.out.println("xn:"+xn);
            En=0.1*xn*xn;
            //System.out.println(En);
            
            //Metropolis scheme
            if(En<=Eo)
            {
                E=En;
                x=xn;
            }
            else
            {
                if(d<Math.exp(-(En-Eo)/T))
                {
                   E=En;
                   x=xn; 
                }
                else
                {
                    x=xo;
                    E=Eo;
                }
            }
            System.out.println("E:"+E);
            //System.out.println("x:"+x);
            te=te+E;
            avg=te/i;
            System.out.println("Avg E:"+avg);
        }
    }
    
}
