/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulers_ralston_fourthorder;

/**
 *
 * @author snehal
 */
public class Eulers_ralston_fourthorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int x=0;
        double newy=0;
        double oldy=1;
       while(x<=30)
       {
          //System.out.print(oldy+",");
          //eulersmethod
          //newy=oldy+func((double)x/10,oldy)*0.1; 
          //Ralston
          //newy=oldy+ralston((double)x/10,oldy,0.1)*0.1;
          //Fourth order Range Kutta
          newy=oldy+fo((double)x/10,oldy,0.1);
          oldy=newy;
          x++;
           
       }
        System.out.println(oldy);
    }
    
    public static double func(double x, double y)
    {
        double te =Math.sin(x);
        return y*Math.pow(te, 3);
    }
    public static double ralston(double x, double y,double h)
    {
        double k1,k2;
        k1=func(x,y);
        k2=func(x+(3*h/4),y+(3*k1*h/4));
        return (k1/3+2*k2/3);
    }
     public static double fo(double x, double y,double h)
     {
         double k1,k2,k3,k4;
         k1=func(x,y);
         k2=func(x+h/2,y+k1*h/2);
         k3=func(x+h/2,y+k2*h/2);
         k4=func(x+h,y+k3*h);
         
         return (k1+2*k2+2*k3+k4)*h/6;
     }
    
}
