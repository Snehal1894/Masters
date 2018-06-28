/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpsons13_38;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Simpsons13_38 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
                double a,b,n,sum,h;
        System.out.println("Enter a , b");
        Scanner sc = new Scanner(System.in);
        a=sc.nextDouble();
        b=sc.nextDouble();
        System.out.println("Enter number of segements");
        n=sc.nextDouble();
        h=(b-a)/n;
        System.out.println(a+","+b);
        if(n%2==0)
           sum= simpsons13(a,b,n,h);
        else
        {
          sum=simpsons38(a,(a+h),(a+2*h),(a+3*h),h);
           n=n-3;
           sum=sum+simpsons13(a+3*h,b,n,h);
        }
        
        System.out.println("Integration value is: "+sum);

    }
    public static double func(double x)
    {
        double val;
        val = Math.pow((4*x-3), 3);
        return val;
    }
    public static double simpsons38(double f0,double f1,double f2,double f3,double h)
    {
        double sum;
        sum=3*h*(func(f0)+3*func(f1)+3*func(f2)+func(f3))/8;
        return sum;
    }
    public static double simpsons13(double a,double b,double n, double h)
    {
        double x1,x2;
        x1=a+h;
        x2=a+2*h; 
      double sum = func(a);
        
        for(double i=0;i<=(n-2)/2;i++)
        {
            sum=sum+4*func(x1);
            x1=x1+2*h;
        }
        for(double i=0;i<(n-2)/2;i++)
        {
            sum=sum+2*func(x2);
            x2=x2+2*h;
        }
        sum=sum+func(b);
        sum=sum*h/3;
       return sum;
    }
    
}
