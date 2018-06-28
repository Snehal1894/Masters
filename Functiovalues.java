/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiovalues;

/**
 *
 * @author snehal
 */
public class Functiovalues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float i=-5;
        float val;
        while (i < 10)
        {
            val=(float) ((0.5*Math.pow(i, 3))-(4*Math.pow(i, 2))+(5.5*i)-1);
            System.out.print(val+",");
            i=(float) (i+0.1);
        }
    }
    
}
