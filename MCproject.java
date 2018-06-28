/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class MCproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
       
         Vector[] vo,vn;
        Energy eng = new Energy();
        vo=eng.enterlist();
        double eno = eng.energycalculate(vo);
        double enn=0;
        /*vo=v;
        eno=en;*/
        //System.out.println("eno:"+eno+" enn:"+enn);
        //eng.print(vo);
        //System.out.println("Start");
        for(int T=10;T>=1;T--)
        {
            double tp=(double)T/(double)10;
        int i=0;
        Random r = new Random();
        System.out.println("Temp:"+tp);
       while(i<100000)
        {
           
           int d1 = r.nextInt(20);
           int d2 = r.nextInt(20);
           double d = r.nextDouble();
            //System.out.println(d1+","+d2+","+d);
           
            if(d1!=d2)
            {
               vn=vo; 
               String temp;
               temp=vn[d1].z;
               vn[d1].z=vn[d2].z;
               vn[d2].z=temp;
                //eng.print(vn);
               
            enn=eng.energycalculate(vn);
            /*eno=en;
            vo=v;*/
            //System.out.println("Enn:"+enn+" Eno:"+eno);
            if(enn <= eno)
            {
                vo=vn;
                eno=enn;
            }
            else if(d < Math.exp(-(enn-eno)/tp))
                {
                   vo=vn; 
                   eno=enn;
                  
                }
            else
            {
                
               temp=vo[d1].z;
               vo[d1].z=vo[d2].z;
               vo[d2].z=temp;
                
            }
            
            //eng.print(vo);
            if(i<=500)
            {
                System.out.print(eno+",");
                
            }   
              //System.out.println(" ");
           
             i++;
            }
         
           
        }
         System.out.println("");
         
         //eng.print(vo);
         //System.out.println("En:"+eno); 
       //for T 
       }
        System.out.println("Final");  
        eng.print(vo);
         System.out.println("En:"+eno); 
         
    }
    
    
}

