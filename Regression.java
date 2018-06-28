/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regression;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Regression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        double sumx=0,sumy=0,sumxy=0,sumx2=0,xm=0,ym=0,a0,a1,st=0,sr=0,r,stere=0;
        System.out.println("Enter the number of data points");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        System.out.println("Enter x points");
        for(int i=0;i<n;i++)
            x[i]=sc.nextDouble();
        System.out.println("Enter y points");
        for(int i=0;i<n;i++)
            y[i]=sc.nextDouble();
        
        for(int i=0;i<n;i++)
        {
            sumx=sumx+x[i];
            sumy=sumy+y[i];
            sumxy=sumxy+x[i]*y[i];
            sumx2=sumx2+x[i]*x[i];
        }
        //System.out.println(sumx+" "+sumy+" "+sumx2+" "+sumxy);
        xm=sumx/n;
        ym=sumy/n;
        a1=(n*sumxy-sumx*sumy)/(n*sumx2-sumx*sumx);
        a0=ym-a1*xm;
        //System.out.println(a1+" "+a0);
        for(int i=0;i<n;i++)
        {
            st=st+(y[i]-ym)*(y[i]-ym);
            sr=sr+(y[i]-a0-a1*x[i])*(y[i]-a0-a1*x[i]);
        }
       r=Math.sqrt((st-sr)/st);
       stere=Math.sqrt(sr/(n-2));
      
        System.out.println("Equarion is y="+a0+"+"+a1+"x");
        System.out.println("Standard error estimate is: "+stere);
        System.out.println("Correlation coefficient is :"+r);
    }  
    
}
