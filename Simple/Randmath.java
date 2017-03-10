import java.util.*;

/**
 * Created by q on 26.06.2016.
 */
//15 комбинаций случайных цифр без повторения
public class Randmath {
    public static void main(String[] args) {
       Set<Integer> map=  new HashSet<>();
        Random rand=new Random();
        int a;
        int b;

    while(map.size()<15)  {
      a=rand.nextInt(68)+22;
        if(a%10==1|a%10==0)continue;
        b=a/10+a%10*10;

        if(!map.contains(b) )map.add(a);
        //System.out.println("a -"+a+"  размер-"+map.size());

    }
        for(Integer q:map ){
            int f=q/10+q%10;
            System.out.println(q/10+"+"+q%10+"="+f);
        }

    }

}
