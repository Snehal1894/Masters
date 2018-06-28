/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aligns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author snehal
 */
public class Aligns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String s1="",s2="";
        String line,line2;
        FileReader fr = new FileReader("/home/snehal/Documents/align.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while((line=br.readLine())!=null)
        {
           s1=s1+line;
           if((line2=br.readLine())!=null)
           s2=s2+line2;
          
        }
        System.out.println(s1+"\n"+s2);
       System.out.println(s1.length()+" "+s2.length());
       FileWriter fw= new FileWriter("/home/snehal/Documents/results.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        fw.write(s1+"\n");
        fw.write(s2.replace("-", "_"));
        fw.close();
    }
    
}
