public class ReservedWords extends SomeClass implements  SomeInterface {

    public static int f(int x) throws Exception, Exception2 {
        //throw new Exception("Some exception");
        return x*x;
    }

    public static void main(String[] args) {

        try {
            printf(f(4));
        }
        catch (Exception e) {
            /* do nothing */
        }
        catch (Exception2 e){

        }finally {

        }

    }
}
