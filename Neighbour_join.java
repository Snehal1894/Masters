/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neighbour_join;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class Neighbour_join {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                int c=1;
        double val, val1;
        double[] res = null;
        String[] nodes, tnodes = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();
        nodes=new String[n];
        System.out.println("Enter nodes");
        for(int i=0;i<n;i++)
            nodes[i]=sc.next();
        double[][] mat = new double[n][n];
        double[][] matdiv=new double[n][n];
        System.out.println("Enter matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Tree is:");
        while(n>2)
        {
         matdiv = new double[n][n];   
         double[] diverg=new double[n];
         for(int i=0;i<n;i++)
         {
             double dsum=0;
             for(int j=0;j<n;j++)
                 dsum=dsum+mat[i][j];
             diverg[i]=dsum;
         }
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 matdiv[i][j]=mat[i][j]-(diverg[i]+diverg[j])/(n-2);
             }
             matdiv[i][i]=0;
         }
         
         //printmat(matdiv, n);
        
        res = findmin(matdiv, n);
        //System.out.println("Results"+res[0]+" "+res[1]+" "+res[2]);
        double[][] matn = new double[n - 1][n - 1];
        tnodes=new String[n-1];
        int k = 0, l = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (i != res[1] && i != res[2]) {
                j = 0;
                l = 0;
                while (j < n) {

                    if (j != res[1] && j != res[2]) {
                        matn[k][l] = mat[i][j];
                        l++;
                    }
                    j++;
                }
                k++;
            }
            i++;
        }
        i = 0;
        k = 0;
        while (i < n) {
            if (i != res[1] && i != res[2]) {
                //System.out.println("in:"+i);
                matn[k][n - 2] = (mat[i][(int)res[1]] + mat[i][(int)res[2]]-mat[(int)res[1]][(int)res[2]]) / 2;
                matn[n - 2][k] = matn[k][n - 2];
                tnodes[k]=nodes[i];
                k++;
                //System.out.println(k);
            }
            i++;
        }
        tnodes[k]="n"+c;
            val1 = (mat[(int)res[1]][(int)res[2]])/2-(diverg[(int)res[1]]-diverg[(int)res[2]])/(2*(n-2));
            System.out.println("n"+c+"->"+nodes[(int)res[1]]+"="+val1);
            val = mat[(int)res[1]][(int)res[2]]-val1;
            System.out.println("n"+c+"->"+nodes[(int)res[2]]+"="+val);
            c++;
        //System.out.println("Matrix");
        //printmat(matn, n - 1);
           //System.out.println("Nodes are");
        /*for(int y=0;y<n-1;y++)
                System.out.print(tnodes[y]+" ");*/
        n=n-1;
        mat = matn;
        nodes=tnodes;
        
    } 
        matdiv = new double[n][n];   
         double[] diverg=new double[n];
         for(int i=0;i<n;i++)
         {
             double dsum=0;
             for(int j=0;j<n;j++)
                 dsum=dsum+mat[i][j];
             diverg[i]=dsum;
         }
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 matdiv[i][j]=mat[i][j]-(diverg[i]+diverg[j])/(n-2);
             }
             matdiv[i][i]=0;
         }
        
         System.out.println(tnodes[0]+"->"+tnodes[1]+"="+mat[0][1]);
       
    }
           public static void printmat(double[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static double[] findmin(double[][] mat, int n) {
        double[] res = new double[3];
        res[0] = mat[0][1];
        res[1]=0;
        res[2]=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0 && mat[i][j] < res[0]) {
                    res[0] = mat[i][j];
                    res[1] = i;
                    res[2] = j;
                }
            }
        }
        return res;
    }
 
    
}
