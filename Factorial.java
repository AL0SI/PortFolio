import java.io.IOException;

/**
 * Created by q on 28.06.2016.
 */
//расчет факториала
public class Factorial {
    public static void main(String[] args) throws IOException {
       int num=( WretiRead.read("C:\\1\\1.txt"));
        System.out.println(num);
        int f=1;
        for(int i=1;i<=num;i++){
            f=f*i;System.out.println(f);
        }
        System.out.println(f);
        WretiRead.write("C:\\1\\1.txt", String.valueOf(f));
    }
}
