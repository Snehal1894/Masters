/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class GE {

    /**
     * @param args the command line arguments
     */
   public static double[][]  a;
   public static double[] b;
   public static double[] x;
   public static int n;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("How many equations?");
        n=sc.nextInt();
        a= new double[n][n];
        b= new double[n];
        x=new double[n];
        double[][] a1 = new double[n][n];
        double[] b1= new double[n];
        System.out.println("Enter a,b,c,d of equations which has form: ax+by+cz=d");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter equation "+(i+1));
            for(int j=0;j<n;j++)
            {
                double val1=sc.nextDouble();
                a[i][j]=val1;
                a1[i][j]=val1;
                
            }   
            double val2=sc.nextDouble();
            b[i]=val2;
            b1[i]=val2;
        }
        forwardele(a);
        backwardele();
        System.out.println("Solutions:");
        for(int i=0;i<n;i++)
                System.out.print("X"+(i+1)+":"+x[i]+" ");
            System.out.println(""); 
        checking(a1,b1);
        
         double det = 1;
         for(int d=0;d<n;d++)
             det=det*a[d][d];
         System.out.println("Determinant is: "+det);
    }
    public static void printmat(double[][] mat)
    {
        for(int i=0;i<3;i++)
        {    
            for(int j=0;j<3;j++)
                System.out.print(mat[i][j]+" ");
        System.out.println(" ");
        }
                
    }
    public static void scale(int i)
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
    public static void forwardele(double[][] a)
    {
        int i;
        for(i=0;i<n-1;i++)
        {
            scale(i);
            System.out.println("Intermediate Matrix:"+(i+1));
            printmat(a);
            for(int j=i+1;j<n;j++)
            {
                double fact=a[j][i]/a[i][i];
                for(int k=i;k<n;k++)
                    a[j][k]=a[j][k]-fact*a[i][k];
                b[j]=b[j]-fact*b[i];
            }
            
        }
         System.out.println("Final Matrix:"+(i+1));
         printmat(a);
        
         
    }
    
    public static void backwardele()
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
    
  public static void checking(double[][] a1, double[] b1)
    {
        for(int i=0;i<n;i++)
        {
            double sol=0;
            for(int j=0;j<n;j++)
            {
                sol=sol+a1[i][j]*x[j];
            }
            System.out.println("Sol"+(i+1)+":"+sol+" Original:"+b1[i]);
            if (sol!=b1[i])
            {
                double error=(sol-b1[i])*100/b1[i];
                System.out.println("Error for equation"+(i+1)+":"+error);
            }
        }   
    }
    
}
