/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonrm;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class NewtonRM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int itr=0;
        float ea = 100,xr,xrold;
        System.out.println("Enter x0");
        xr= sc.nextFloat();
        while(ea>0.001)
        {
         xrold=xr;
         xr=xrold-(func(xrold)/fder(xrold));
         itr++;
         if(xr!=0)
             ea=Math.abs((xr-xrold)*100/xr);
          System.out.println("i:"+itr+" xrold:"+xrold+" xr: "+xr+" ea:"+ea);
         }
        System.out.println("Root is: "+xr);
    }
    public static float fder(float x)
    {
       return (float) ((Math.exp(-x/2)*(-5*Math.cos(x)-10*Math.sin(x)))-((1/3)*Math.pow(x, -2/3)));
    }
    public static float func(float x)
    {
        return (float) (10*Math.cos(x)*Math.exp(-x/2)-Math.pow(x, 1/3)+1.8);
    }
}
