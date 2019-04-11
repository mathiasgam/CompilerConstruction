public class Loops {

    public static void main(String[] args) {
        int x = 0;
        int[] y = {1,2,3};
        for (int i = 0;
             i > 0;
             i--) {
            x += 5;
        }

        for ( ; ; ) {
            x += 5;
        }
        int res;
        for (int i : y) {
            res += i;
        }
    }
}
