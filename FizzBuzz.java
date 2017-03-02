import java.util.stream.IntStream;

/**
 * Created by q on 29.06.2016.
 */
//физбазз
public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.range(1, 101).forEach(i -> System.out.println((((i % 3 != 0) && (i % 5 != 0)) ? i : "") + ((i % 3 == 0) ? "fizz" : "") + ((i % 5 == 0) ? "buzz" : "")));
    }
}
