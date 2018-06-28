/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package needle;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Needle {

    /**
     * @param args the command line arguments
     */
     public static Cell[][] mat;
    public static char[] s1,s2;
    public static void main(String[] args) {
        // TODO code application logic here
        
   Cell c1;
   int i,j,m,d,g;
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the two Strings");
   s1=sc.next().toCharArray();
   s2=sc.next().toCharArray();
   System.out.println("Enter Match, Mismatch and gap penalty:");
   m= sc.nextInt();
   d=sc.nextInt();
   g=sc.nextInt();
   mat= new Cell[s1.length+1][s2.length+1];
   
   c1=new Cell();
   c1.dir="D";
   mat[0][0]=c1 ;  
  
   for(i=1;i<s2.length+1;i++)
    {
       c1 = new Cell();
       c1.score=mat[0][i-1].score+g;
       c1.dir=c1.dir+"L";
       mat[0][i]=c1;
       
     }
      for(i=1;i<s1.length+1;i++)
    {
       c1 = new Cell();
       c1.score=mat[i-1][0].score+g;
       c1.dir=c1.dir+"U";
       mat[i][0]=c1;
      
     }

     for(i=1;i<s1.length+1;i++)
     {
       for(j=1;j<s2.length+1;j++)
       {
           int x2;
           c1=new Cell();
           int x1=mat[i][j-1].score+g;
           int x3=mat[i-1][j].score+g;
           if(s1[i-1]==s2[j-1])
             x2=mat[i-1][j-1].score+m;
           else
             x2=mat[i-1][j-1].score+d;
            int mx=Math.min(Math.min(x1,x2),x3);
             c1.score=mx;
            if(mx==x1)
               c1.dir=c1.dir+"L";
            if(mx==x2)
               c1.dir=c1.dir+"D";
            if(mx==x3)
               c1.dir=c1.dir+"U";
            mat[i][j]=c1;   
              

       }
     }
  
  /*for(i=0;i<s1.length+1;i++)
  {
    for(j=0;j<s2.length+1;j++)
    {
       System.out.print(mat[i][j].score+","+mat[i][j].dir+" ");
        //System.out.print("'"+mat[i][j].dir.length()+"' ");
    } 
      System.out.println("");
  }*/
  String f1="";
  String f2="";
  int len=mat[s1.length][s2.length].dir.length();
  for(int ct=0;ct<len;ct++)
       backtrack(f1,f2,mat[s1.length][s2.length].dir.charAt(ct),s1.length,s2.length);
  
    }
    
    public static void backtrack(String f1, String f2,char dir,int i, int j)
    {
       if(i==0 && j==0)
       {
           System.out.println("Results");
           System.out.println(f1);
           System.out.println(f2);
       }
       else
    {
      if(dir=='D')
            {
                i=i-1;
                j=j-1;
                f1=Character.toString(s1[i])+f1;
                f2=Character.toString(s2[j])+f2;
                
            }
             else if(dir=='L')
            {      
               j=j-1;
               f1="_"+f1;
               f2=Character.toString(s2[j])+f2;
            }
            else
            {
                i=i-1;
                f1=Character.toString(s1[i])+f1;
                f2="_"+f2;
            }
             int len=mat[i][j].dir.length();

                for(int ct=0;ct<len;ct++)
                {
                    //System.out.println("f1:"+f1+" f2:"+f2+" Dir:"+mat[i][j].dir.charAt(ct)+" i:"+i+" j:"+j);
                  
                    backtrack(f1,f2,mat[i][j].dir.charAt(ct),i,j);
                }
    }
    }        
    
    
}
