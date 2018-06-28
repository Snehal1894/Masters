/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trapezoidalrule_RI;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class TrapezoidalRule_RI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double n1,n2,a,b,h1,h2,sum1,sum2,fsum;
        System.out.println("Enter a, b");
        a=sc.nextDouble();
        b=sc.nextDouble();
        System.out.println("Enter n1 and n2");
        n1=sc.nextDouble();
        n2=sc.nextDouble();
        h1=(b-a)/n1;
        h2=(b-a)/n2;
        sum1=trapezoidal(a,b,n1);
        sum2=trapezoidal(a,b,n2);
        fsum=sum2+(sum2-sum1)/((h1*h1)/(h2*h2)-1);
        System.out.println(fsum);
         
    }
    public static double func(double x)
    {
        double val;
        val = Math.pow((4*x-3), 3);
        return val;
    }
    public static double trapezoidal(double a,double b,double n)
    {
        double x;
        double h;
        h=(b-a)/n;
        x=a;
        double sum = func(a);
        for(double i=1;i<n;i++)
        {
            x=x+h;
            sum=sum+2*func(x);
        }
        sum=sum+func(b);
        sum=sum*h/2;
        
        return sum;
        
    }
    
}
