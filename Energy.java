/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcproject;

import java.util.Scanner;


/**
 *
 * @author snehal
 */
public class Energy {
   
    String[] e ={"HH","HP","P-P+","P+P+","P-P-","P+H","P+P","P-H","P-P"};
   double[] en = {-2.0,-1.0,-1.5,2.0,2.0,1.0,1.0,1.0,1.0};
   public Vector[] enterlist()
   {
       Vector[] v= new Vector[20];
       Scanner sc = new Scanner(System.in);
       for(int i=0;i<20;i++)
        {
            Vector t = new Vector();
            t.x=sc.nextInt();
            t.y=sc.nextInt();
            t.z=sc.next();
            v[i]=t;
        }
       return v;
   }
   public double energycalculate(Vector[] v1)
   {
       double energy=0;
        for(int i=0;i<19;i++)
        {
            for(int j=i+2;j<20;j++)
            {
                if(dist(v1[i].x,v1[j].x,v1[i].y,v1[j].y))
                {
                    //System.out.println("In dist:"+i+","+j);
                    String t1 = v1[i].z+v1[j].z;
                    String t2 = v1[j].z+v1[i].z;
                    //System.out.println("t1:"+t1+" t2:"+t2);
                    if(index(t1,e)!=-1)
                        energy = energy+en[index(t1,e)];
                    else if(index(t2,e)!=-1)
                        energy = energy+en[index(t2,e)];
                }
            }
        }
        //System.out.println("E:in class"+energy);
        return energy;
   }
    public  boolean dist(int x1,int x2,int y1,int y2)
    {
       
        if(((x1-x2)==0 && Math.abs(y1-y2)==1) || (Math.abs(x1-x2)==1 && Math.abs(y1-y2)==0) )
            return true;
        else
            return false;
         
    }
    public int index(String t,String[] e)
    {
        int ix=-1;
        for(int i=0;i<e.length;i++)
            if(e[i].equals(t))
                ix=i;
        //System.out.println("index:"+ix);
        return ix;
        
    } 
    public void print(Vector[] c)
    {
        for(int i=0;i<20;i++)
            System.out.print("\""+c[i].z+"\""+",");
        System.out.println("");
    }
    
}
