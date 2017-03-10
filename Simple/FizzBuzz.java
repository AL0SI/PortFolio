import static java.lang.System.exit;

/**
 * Created by q on 29.06.2016.
 */
//физбазз
public class FizzBuzz {
    static int i;

    public static void main(String[] args) {

        a:
        for (i = 0; i < 101; i++){
            if (pr(15, "fizzbuzz")) continue a;
            if (pr(3, "fizz")) continue a;
            if (pr(5, "buzz")) continue a;
            System.out.println(i);
        }
    }

    private static boolean pr(int p, String f) {
        if (i % p == 0) {
            System.out.println(f);
            return true;
        }
        return false;

    }


}
