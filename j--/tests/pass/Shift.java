package pass;
import java.lang.System;

public class Shifts {

    /*
    <<
    >>
    <<=
    >>=
    <<<=
    >>>=
     */

    public int leftShiftInt (int x, int shift) {
        return x << shift;
    }

    public int rightShiftInt (int x, int shift) {
        return x >> shift;
    }

    public int logicalRightShiftInt (int x, int shift) {
        return x >>> shift;
    }
}