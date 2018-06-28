/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilesequence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class ProfileSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
       /* int a=0,g=0,c=0,t=0,n=0;
        char[] s1,s2,s3,s4,s5;
        FileReader fr = new FileReader("/home/snehal/Documents/results.txt");
        BufferedReader br = new BufferedReader(fr);
        s1=br.readLine().toCharArray();
        s2=br.readLine().toCharArray();
        double[][] mat = new double[5][s1.length];
        System.out.println(s1[109]);
        for(int i=0;i<s1.length;i++)
        {
            a=0;g=0;c=0;t=0;n=0;
            if(s1[i]=='A')
                a++;
            else if(s1[i]=='G')
                g++;
            else if(s1[i]=='C')
                c++;
            else if(s1[i]=='T')
                t++;
            else if(s1[i]=='_')
                n++;
            
            if(s2[i]=='A')
                a++;
            else if(s2[i]=='G')
                g++;
            else if(s2[i]=='C')
                c++;
            else if(s2[i]=='T')
                t++;
            else if(s2[i]=='_')
                n++;
            
            mat[0][i]=a/2.0;
            mat[1][i]=g/2.0;
            mat[2][i]=c/2.0;
            mat[3][i]=c/2.0;
            mat[4][i]=n/2.0;
            
        }
       FileWriter fw= new FileWriter("/home/snehal/Documents/profile.txt");
       BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<s1.length;j++)
                fw.append(mat[i][j]+",");
            fw.write("\n");
        }  
        fw.close();*/
       int[] x = new int[20];
       int[] y = new int[20];
       String[] z = new String[20];
      Scanner sc = new Scanner(System.in);
      for(int i=0;i<20;i++)
      {
          x[i]=sc.nextInt();
          y[i]=sc.nextInt();
          z[i]=sc.next();
      }
       for(int i=0;i<20;i++)
            System.out.print(x[i]+",");
        System.out.println("");
        for(int i=0;i<20;i++)
            System.out.print(y[i]+",");
        System.out.println("");
        for(int i=0;i<20;i++)
            System.out.print("\""+z[i]+"\""+",");
        System.out.println("");
       /* System.out.println("ready");
        String[] sts={"P-","P","P","P","P","P-","H","H","H","P+","P+","H","H","H","P+","P","P","P","P","P-"};
        Random r = new Random();
        int c=20;
       while(c>1)
        {
            //System.out.println("in while");
            int d1 = r.nextInt(20);
            //System.out.println("Randno:"+d1);
            if(!sts[d1].equals(""))
            {
             System.out.println(sts[d1]);
             sts[d1]="";
             c--;
            }
        }
        System.out.println("Final");
        for(int i=0;i<20;i++)
            System.out.print(sts[i]+",");
        System.out.println("");  */          
       
    }
      
   
    
}
