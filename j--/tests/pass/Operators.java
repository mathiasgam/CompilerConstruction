package pass;
import java.lang.System;

public class Operators {

    /*
    +
    -
    *
    /
    %

    +=
    -=
    *=
    /=
    %=

    ++
    --
     */

    // INTEGER TESTS
    public int addInt(int x, int y) {
        return x + y;
    }

    public int subInt(int x, int y) {
        return x - y;
    }

    public int mulInt(int x, int y) {
        return x * y;
    }

    public int divInt(int x, int y) {
        return x / y;
    }

    public int remInt(int x, int y) {
        return x % y;
    }

    public int assignAddInt(int x, int y) {
        x += y;
        return x;
    }

    public int assignSubInt(int x, int y) {
        x -= y;
        return x;
    }

    public int assignMulInt(int x, int y) {
        x *= y;
        return x;
    }

    public int assignDivInt(int x, int y) {
        x /= y;
        return x;
    }

    public int assignRemInt(int x, int y) {
        x %= y;
        return x;
    }

    public int postIncInt(int x) {
        x++;
        return x++;
    }

    public int postDecInt(int x) {
        x--;
        return x--;
    }

    public int preIncInt(int x) {
        ++x;
        return ++x;
    }

    public int preDecInt(int x) {
        --x;
        return --x;
    }

    public double addDouble(double x, double y) {
        return x + y;
    }

    public double subDouble(double x, double y) {
        return x - y;
    }

    public double mulDouble(double x, double y) {
        return x * y;
    }

    public double divDouble(double x, double y) {
        return x / y;
    }

    public double remDouble(double x, double y) {
        return x % y;
    }

}