public class Literals {
    public static void main(String[] args) {
        //long b = 777L;
        //float c = 3.14f;
        double d = 1.2d;
        double f = 78.2e-9d;

        double k;
        k = d + f;
        k = d * f;
        k = d / f;
        k = d - f;
        k = d % f;

        k += d;
        k -= d;
        k /= d;
        k *= d;
        k %= d;

        boolean b;
        b = k < d || k > d || k <= d || k >= d || k == d || k != d;
    }
}
