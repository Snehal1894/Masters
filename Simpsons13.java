/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpsons13;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Simpsons13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a,b,n,x,x1,x2;
        System.out.println("Enter a , b");
        Scanner sc = new Scanner(System.in);
        a=sc.nextDouble();
        b=sc.nextDouble();
        System.out.println("Enter number of segements");
        n=sc.nextDouble();
        double h;
        h=(b-a)/n;
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
        System.out.println("Integration value is: "+sum);
    }
    public static double func(double x)
    {
        double val;
        val = Math.pow((4*x-3), 3);
        return val;
    }
    
}
