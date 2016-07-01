/**
 * Created by q on 29.06.2016.
 */
// вывод последней цифры и суммы цифр числа
public class Poscif {
    public static void main(String[] args) {
        int i=325;
        int p=i%((i/10)*10);
        //System.out.println(p);
        int q1=i/100;
       int q2=(i-q1*100)/10;
       int q3=i-q1*100-q2*10;
        int sum= q1+q2+q3;
      //  System.out.println(sum);
        System.out.println(i%2==0?i+2:i+1);
    }
}
