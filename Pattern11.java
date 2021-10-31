/*      *
          * 
            *
              *
                *                          */
import java.util.*;

class Pattern11 {
    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {   /// Space print

            for (int j = 4; j>= i; j--) {
                 System.out.print(" ");
            }
            for(int k=1;k<=i;k++){       
               
                if (i >= 2 && k >1) {
                    System.out.print(" "); // space print 
                }
                else{
                    System.out.print("*"); // * print
                }
            }
            System.out.println();
        }
    }
}
