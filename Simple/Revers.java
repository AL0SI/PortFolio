/**
 * Created by q on 27.06.2016.
 */
// реверс строки
public class Revers {
    public static void main(String[] args) {
        System.out.println(rev("qwerty"));
    }

    private static String rev(String d) {
        String[] rev=d.split("");
        int i=rev.length;
        String s=rev[i-1];
        for(int r=i-2;r>=0;r--){s=s+rev[r];}
        return s;
    }
}
