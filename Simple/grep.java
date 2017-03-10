import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 26.06.2016.
 */
//вывод строк ,содержащих подстроку.вне зависимости от регистра
public class grep {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        while (true) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String st = reader.readLine();
            for (int i = 0; i < str.length; i++) {
                st = st.toLowerCase();
                if (st.contains(str[i].toLowerCase()) | st.matches(str[i])) {
                    System.out.println(st);
                    break;
                }
            }
        }
    }
}
