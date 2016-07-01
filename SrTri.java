/**
 * Created by q on 29.06.2016.
 */
//три по убыванию
public class SrTri {
    public static void main(String[] args) {

        int q1=100;
        int q2=200;
        int q3=30;
int sum=q1+q2+q3;
      int max= sr (sr(q1,q2),q3);
       int min= srm (srm(q1,q2),q3);

        System.out.println(max);
        System.out.println(sum-max-min);
        System.out.println(min);




    }
 static   int  sr(int q1, int q2){

       if (q1>q2)return q1;
       return q2;
   }
static   int  srm(int q1, int q2){

       if (q2>q1){
           return q1;}

       return q2;
   }
}
