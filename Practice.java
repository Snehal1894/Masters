/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author snehal
 */
public class Practice 
    {
        public static void main()
            {
        
                int j=60085;
                int greatestPrime=1;
                int smallestPrime=2;
                 while(greatestPrime!=smallestPrime)
                    {
                        smallestPrime=smallPrime(j);
                        int quotient=j/smallestPrime;
                        if(isPrime(quotient)==true)
                            {
                                greatestPrime = quotient;   
                            }
                        else
                            {
                                greatestPrime=smallestPrime;
                            }       
                    }
                System.out.println("the number is:"+greatestPrime);
            }
    
        int smallPrime(int a)
            {
                for(int i=2;i<a/2;i++)
                    {
                        if (isPrime(i)==true)
                            {
                                if(a%i==0)
                                return i;
                            }
                    }
            }
        boolean isPrime(int n)
            {
                int i=0;
                for(i=2; i<=n/2; ++i)
                    {                
                        if(n%i==0)
                            {
                                return true;
                            }
                    }
            }
       }
