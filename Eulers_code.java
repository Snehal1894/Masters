/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulers_code;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Eulers_code {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        float r= (float) 3.00;
        float st=(float) 0.25;
        float t= (float) 0.0;
        float vol,area;
        vol=(float) (4*3.14*r*r*r/3);
        area=(float) (4*3.14*r*r);
         System.out.println("T:"+t+" R:"+r+" A:"+area+" V:"+vol);
         String volume = String.valueOf(vol)+",";
        while (t<28)
        {
         t=(float) (t+0.25);   
         vol=(float) (vol-(0.1*area*0.25));
         r=(float) Math.cbrt((vol*3)/(4*3.14));
         area=(float) (4*r*r*3.14);
         System.out.println("T:"+t+" R:"+r+" A:"+area+" V:"+vol);
         volume=volume+String.valueOf(vol)+",";
        }
        System.out.println(volume);
        
    }
    
}
