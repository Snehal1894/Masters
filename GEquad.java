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
public class GE {
    public  double[][]  a;
   public  double[] b;
   public  double[] x;
   public int n;
   
   public GE()
           {
       }
    public double[] Equations(double[] e1,double[] e2,double[] e3) {
        // TODO code application logic here
        n=3;
        a=new double[3][3];
        b= new double[3];
        x= new double[3];
        double[][] a1=new double[3][3];
        double[] b1= new double[3];
        a1=a;
        b1=b;
        for(int i=0;i<3;i++)
        {
          a[0][i]=e1[i];
          a[1][i]=e2[i];
          a[2][i]=e3[i];
        }
        b[0]=e1[3];
        b[1]=e2[3];
        b[2]=e3[3];
        forwardele(a);
        backwardele();
         return x;
    }
    public  void scale(int i)
    {
        double max=a[i][i];
        int p=i,j;
        for(j=i+1;j<n;j++)
        {
            if(a[j][i]>max)
            {
                max=a[j][i];
                p=j;
            }    
            
        }
        if(p!=i)
        {
          for(int k=i;k<n;k++)
          {
              double t=a[i][k];
              a[i][k]=a[p][k];
              a[p][k]=t;
              
                      
          }
          double te=b[p];
              b[p]=b[i];
              b[i]=te;
        }
    }
    public  void forwardele(double[][] a)
    {
        int i;
        for(i=0;i<n-1;i++)
        {
            scale(i);
            for(int j=i+1;j<n;j++)
            {
                double fact=a[j][i]/a[i][i];
                for(int k=i;k<n;k++)
                    a[j][k]=a[j][k]-fact*a[i][k];
                b[j]=b[j]-fact*b[i];
            }
            
        }
    }
    
    public  void backwardele()
    {
       x[n-1]=b[n-1]/a[n-1][n-1];
        for(int i=n-2;i>=0;i--)
        {
            double t=b[i];
            for(int j=i+1;j<n;j++)
            {
                t=t-x[j]*a[i][j];
            }
            x[i]=t/a[i][i];
        }
        
    }    
}
