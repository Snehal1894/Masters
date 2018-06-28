/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticreg;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Quadraticreg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        double sumx=0,sumy=0,sumxy=0,sumx2=0,sumx3=0,sumx4=0,sumx2y=0,xm=0,ym=0,st=0,sr=0,r,stere=0;
        System.out.println("Enter the number of data points");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        double[] x = new double[n];
        double[] x2= new double[n];
        double[] x3= new double[n];
        double[] x4 = new double[n];
        double[] y = new double[n];
        System.out.println("Enter x points");
        for(int i=0;i<n;i++)
            x[i]=sc.nextDouble();
        System.out.println("Enter y points");
        for(int i=0;i<n;i++)
            y[i]=sc.nextDouble();
        for(int i=0;i<n;i++)
        {
            x2[i]=x[i]*x[i];
            x3[i]=x2[i]*x[i];
            x4[i]=x3[i]*x[i];
            sumx=sumx+x[i];
            sumy=sumy+y[i];
            sumx2=sumx2+x2[i];
            sumx3=sumx3+x3[i];
            sumx4=sumx4+x4[i];
            sumxy=sumxy+x[i]*y[i];
            sumx2y=sumx2y+x2[i]*y[i];
        }
        xm=sumx/n;
        ym=sumy/n;
        //System.out.println(sumx+" "+sumy+" "+sumx2+" "+sumx3+" "+sumx4+" "+sumxy+" "+sumx2y);
        double[] e1={n,sumx,sumx2,sumy};
        double[] e2={sumx,sumx2,sumx3,sumxy};
        double[] e3={sumx2,sumx3,sumx4,sumx2y};
        double[] res;
       GE ge = new GE();
       res=ge.Equations(e1, e2, e3);
       for(int i=0;i<n;i++)
        {
            st=st+(y[i]-ym)*(y[i]-ym);
            sr=sr+(y[i]-res[0]-res[1]*x[i]-res[2]*x[i]*x[i])*(y[i]-res[0]-res[1]*x[i]-res[2]*x[i]*x[i]);
        }
       r=Math.sqrt((st-sr)/st);
       stere=Math.sqrt(sr/(n-3));
       
       System.out.println("Equarion is y="+res[0]+"+"+res[1]+"x"+"+"+res[2]+"x^2");
        System.out.println("Standard error estimate is: "+stere);
        System.out.println("Correlation coefficient is :"+r);
    }
    
}
