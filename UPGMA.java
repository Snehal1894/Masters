/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upgma;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class UPGMA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int c = 1;
        double val;
        double[] res = null;
        String[] nodes, tnodes, cnodes, c1nodes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();
        nodes = new String[n];
        cnodes = new String[n];
        System.out.println("Enter nodes");
        for (int i = 0; i < n; i++) {
            String nt = sc.next();
            nodes[i] = nt + ",0";
            cnodes[i] = nt;
        }
        double[][] mat = new double[n][n];
        System.out.println("Enter matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Tree is:");
        while (n > 2) {
            res = findmin(mat, n);
            //System.out.println("Results"+res[0]+" "+res[1]+" "+res[2]);
            double[][] matn = new double[n - 1][n - 1];
            tnodes = new String[n - 1];
            c1nodes = new String[n - 1];
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
                    matn[k][n - 2] = (mat[i][(int) res[1]] * cnodes[(int) res[1]].length() + mat[i][(int) res[2]] * cnodes[(int) res[2]].length()) / (cnodes[(int) res[1]].length() + cnodes[(int) res[2]].length());
                    matn[n - 2][k] = matn[k][n - 2];
                    tnodes[k] = nodes[i];
                    c1nodes[k] = cnodes[i];
                    k++;

                }
                i++;
            }
            String nd = cnodes[(int) res[1]] + cnodes[(int) res[2]];
            tnodes[k] = "n" + c + "," + res[0] / 2;
            c1nodes[k] = nd;
            val = res[0] / 2 - Double.parseDouble(nodes[(int) res[1]].split(",")[1]);
            System.out.println("n" + c + "->" + nodes[(int) res[1]].split(",")[0] + "=" + val);
            val = res[0] / 2 - Double.parseDouble(nodes[(int) res[2]].split(",")[1]);
            System.out.println("n" + c + "->" + nodes[(int) res[2]].split(",")[0] + "=" + val);
            c++;
           /* System.out.println("Matrix");
             printmat(matn, n - 1);
             System.out.println("Nodes are");
            for (String c1node : c1nodes) {
                System.out.print(c1node + " ");
            }*/
            n = n - 1;
            mat = matn;
            nodes = tnodes;
            cnodes = c1nodes;

        }
        /*System.out.println("Last:");
        printmat(mat,n);*/
        res = findmin(mat, n);

        val = res[0] / 2 - Double.parseDouble(nodes[(int) res[1]].split(",")[1]);
        System.out.println("n" + c + "->" + nodes[(int) res[1]].split(",")[0] + "=" + val);
        val = res[0] / 2 - Double.parseDouble(nodes[(int) res[2]].split(",")[1]);
        System.out.println("n" + c + "->" + nodes[(int) res[2]].split(",")[0] + "=" + val);
        
        /*System.out.println("Nodes are");
            for (String c1node : c1nodes) {
                System.out.print(c1node + " ");
            } */

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
        res[1] = 0;
        res[2] = 1;
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
