public class Operators {

    static int bob;

    static {
        bob = 5;
    }

    public static void main(String[] args) {
        int x = 372;
        x += 100;
        x -= 20;
        x *= 2;
        x /= 3;
        x %= 10.0d;
        int y = 1;
        boolean z = y == 1 || false;
        --x;
        x++;
        bob++;
        //int z = y ? 2 : 0;
    } 
}
