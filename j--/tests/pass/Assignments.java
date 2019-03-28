package pass;

import java.lang.System;

public class Assignments {

    int x = 0;

    private int foo() {
        x += 1;
        x -= 2;
        x *= 2;
        x /= 3;
        x %= 10;
        return x;
    }

    public static void main(String[] args) { System.out.println((new Assignments()).foo()); }
}