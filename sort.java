import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by q on 26.06.2016.
 */
public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList(reader.readLine().toLowerCase().split("\\p{P}?[ \\t\\n\\r]+")));
        ArrayList<String> sr=str;Collections.sort(sr);
        for(String s:sr)
            System.out.println("sr-"+s);
        for (int i = 0; i < str.size()-1; i++)
            for (int j = i; j < str.size()-1; j++) {
              //  System.out.println("i "+i+" j "+j);
                if ((str.get(i)).length() > str.get(j).length()) {
                    String s = str.get(i);

                    str.set(i, str.get(j));
                    str.set(j, s);

                }

            }
        for(String s:str)
            System.out.println("str-"+s);

    }}

