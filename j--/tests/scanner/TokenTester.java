package pass;
import java.lang.System;

public class ShiftLeft {
    public int shift_left(int x, int y) {
        return x << y;
    }

    public static void main (String[] args) {
        int x = 5;
        int y = 2;

        // single line comment

        /*
        Multi line comment
         */

        System.out.println("Token Tester");


        int result;
        result = x++ << y;
        result += x / y;
        result = result >> 1;
        result = result >>> 1;

        if ((true | false) & (true ^ false) ){
            result += 5;
        }

        do {
            /* do nothing */
        } while (true){
            break;
        }
        for (;;) {
            try {
                if (true) { continue; }
            }
            catch (SomeException e) {
                /* do nothing */
            }
        }
        final int x;

    }
}