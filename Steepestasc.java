/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steepestasc;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Steepestasc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double x1,y1;
        System.out.println("Enter initial x and y");
        x1=sc.nextDouble();
        y1=sc.nextDouble();
        double[] zee={0,0,0,0};
        double[] ones={1,0,0,0};
        double[]rex;
        double[] rey;
        rex=xgrad(x1,y1);
        rey=ygrad(x1,y1);
         int i=0;
        //String[] z={"2xy","2x","-1xx","-2yy"};
         String[] z ={"8x","-1xx","-12y","-4yy","2xy"};
        double[] sol = sum(zee,zee);
        while(i < z.length)
        {
            int j=0;
            boolean fg=false;
            if(z[i].charAt(0)=='-')
            {
                 fg=true;
                 j=1;
            }     
            double[] ans = multiply(ones,ones);
           while (j<z[i]. length())
           { 
   
              if(z[i].charAt(j)=='x')
                    ans=multiply(ans,rex);
               else if(z[i].charAt(j)=='y')
                   ans=multiply(ans,rey);
               else
               {
                   int val;
                   while(z[i].charAt(j)!='x'&& z[i].charAt(j)!='y')
                        j++;
                   if(fg)
                   val=Integer.parseInt(z[i].substring(1, j));
                   else
                      val=Integer.parseInt(z[i].substring(0, j));
                   double[] pasv={val,0,0,0};
                   ans=multiply(ans,pasv);
                   j--;
               }   
               j++;
           }
            //System.out.println(fg);
           if(fg)   
            for(int c=0;c<ans.length;c++)   
               ans[c]=-ans[c];
              sol=sum(sol,ans);
           i++;
        }
        System.out.println("Solution");
        for(int c=0;c<sol.length;c++)
               System.out.print(sol[c]+",");
                    System.out.println("");
                    
        System.out.println("Derivative");
        double[] der = derivative(sol);
        for(int c=0;c<der.length;c++)
               System.out.print(der[c]+",");
                    System.out.println("");
            double h = -der[0]/der[1];
            System.out.println(h);
            
          double newx=rex[0]+rex[1]*h;
          double newy=rey[0]+rey[1]*h;
          System.out.println("New x:"+newx+" New y:"+newy);
    }
    public static double[] multiply( double[] p1, double[]p2)
    {
        
     double prod[]=new double[p1.length+p2.length-1];
       
     for(int i=0;i<p1.length;i++)
         for(int j=0;j<p2.length;j++)
              prod[i+j] = prod[i+j] + p1[i] * p2[j];
     return prod;
    }
    
    public static double[] sum(double[] p1, double[] p2)
    {
        double[] sum;
        int min=p1.length;
        int max=p2.length;
        sum=p2;
        if(p2.length<p1.length)
        {
            min=p2.length;
            max=p1.length;
            sum=p1;
        }  
        for(int i=0;i<min;i++)
            sum[i]=p1[i]+p2[i];
        return sum;
    }
    
    public static double[] derivative(double[] ans)
    {
        double[] der = new double[ans.length-1];
        
        for(int i=1;i<ans.length;i++)
        {
            der[i-1]=ans[i]*i;
        }
        
        return der;
    }
    public static double[] xgrad(double x, double y)
    {
        double val = 8-2*x+2*y;
        double[] xpol= {x,val,0,0};
        return xpol;
    }
    public static double[] ygrad(double x, double y)
    {
        double val = -12-8*y+2*x;
        double[] ypol= {y,val,0,0};
        return ypol;
    }
    
}
