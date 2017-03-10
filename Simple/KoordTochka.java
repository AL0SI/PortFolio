/**
 * Created by q on 29.06.2016.
 */

//вывести чертверть по коодинататм точки
public class KoordTochka {
    public static void main(String[] args) {
        System.out.println(srv(-1,1));
    }
    static int srv(int x,int y){

        int ch;
        if (x>0)ch=14;
        else    ch=23;
        if(y>0)ch=ch/10;
        else ch=ch%10;
        return ch;
    }

}
