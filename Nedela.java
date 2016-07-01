import java.util.HashMap;

/**
 * Created by q on 30.06.2016.
 */
//день недели
public class Nedela {
    public static void main(String[] args) {
       ned(1);
    }
   static void ned(int i){
        HashMap<Integer,String> ned=new HashMap<>();
        ned.put(1,"понедельник");
        ned.put(2,"второник");
        ned.put(3,"среда");
        ned.put(4,"четверг");
        ned.put(5,"пятница");
        ned.put(6,"суббота");
        ned.put(7,"воскресенье");
        ned.put(8,"такого дня нет");
        if(i>7)i=8;
        System.out.println(ned.get(i));
    }
}
