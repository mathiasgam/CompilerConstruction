package pass;
import java.lang.System;

public class TenaryConditional {
    public static int tenaryConditional(boolean b, int x, int y) {
        return (b ? x : y);
    }

    public static void main (String[] args) {
        System.out.println(tenaryConditional(true, 3, 2));
    }
}