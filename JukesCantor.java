/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jukescantor;

/**
 *
 * @author snehal
 */
public class JukesCantor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double D=0;
        //PF4
       /* double[] m={1022,1277,1240,1223,1025,995,979,1244,1226,1213};
        double[] g={259,4,11,15,6,13,16,7,11,4};
        double[] tot={1302,1301,1301,1301,1299,1299,1298,1298,1298,1291};*/
        //APOC3
       /* double[] m={2957,3042,2986,2989,2995,2895,2861,2970,2948,2934};
        double[] g ={162,123,82,56,111,162,223,67,114,85};
        double[] tot={3231,3216,3166,3176,3162,3158,3207,3148,3190,3154};*/
        //Waterman smith
        /*double[] m={1022,1277,1240,1223,1025,995,979,1244,1226,1213 };
        double[] g={2,1,8,12,1,8,11,7,11,4};
        double[] tot={1045,1298,1298,1298,1045,1045,1045,1298,1298,1291};*/
        double[] m ={2957,3040,2984,2988,2995,2892,2861,2971,2948,2933};
        double[] g ={162,75,78,55,93,92,167,19,76,83};
        double[] tot={3164,3167,3160,3165,3144,3087,3150,3097,3151,3136};
        for(int i=0;i<10;i++)
        {
            double ng = tot[i]-g[i];
            double r = (4/3)*(m[i]/ng);
            D = -0.75 * Math.log10(1-(r));
            System.out.println(D);
        }
        
    }
    
}
