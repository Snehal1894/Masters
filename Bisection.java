/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisection;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Bisection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float ea=100,eagiven,xl,xu,xrold,f1,f2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter xl");
        xl=sc.nextFloat();
        System.out.println("Enter xu");
        xu=sc.nextFloat();
        System.out.println("Enter ea");
        eagiven=sc.nextFloat();
        int itr=0;
        float xr=xl;
        while(ea > eagiven)
        {
            itr++;
            xrold=xr;
            xr=(xl+xu)/2;
            if(xr!=0)
                ea=((Math.abs(xr-xrold))/xr)*100;
            f1=function(xl);
            f2=function(xr);
            System.out.println("i:"+itr+" xl:"+xl+" xu:"+xu+" fl:"+f1+" fu:"+f2+" xr:"+xr+" ea:"+ea);
           float test=f1*f2;
            if(test< 0)
                xu=xr;
            else if(test>0)
                xl=xr;
            
        }
        float fval=(float) ((-2*xr*xr*xr*xr*xr*xr)-(1.6*xr*xr*xr*xr)+(12*xr)+1);
            System.out.println("The Maximum value of given function is "+fval+" at"+xr);
        
    }
    
    public static float function(float val)
    {
        //put original function not derivate
       return  (float) ((float) (-12*(Math.pow((double)val, 5)))-(6.4*Math.pow((double)val, 3))+12);
    }
    
}
