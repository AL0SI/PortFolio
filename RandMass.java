import java.util.Random;

/**
 * Created by q on 27.06.2016.
 */
//сортировка двумерного массива
public class RandMass {
    public static void main(String[] args) {
int[][] mass=rand();
        for(int[] w:mass){
            for(int e:w){
                System.out.print(e);}
            System.out.println();

        }
       mass=sortmass(mass);
        for(int[] w:mass){
            for(int e:w){
                System.out.print(e);}
            System.out.println();

    }}

    public static int [][] rand(){
        Random rand=new Random();
        int [][] mass=new int[6][7];
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                mass[i][j]=rand.nextInt(10);

            }
        }
        return mass;
    }

public static int [][] sortmass(int [][] mass){
        int i=0;
        for(int[] w:mass){mass[i]=sort(w);
            i++;

        }

        return mass;
}
    public static int [] sort(int [] mass) {
        int size=mass.length;
        int m;
        for (int i = 0; i < size; i++) {

            for (int j = i; j < size; j++) {
                if(mass[i]<mass[j]){ m=mass[i]; mass[i]= mass[j]; mass[j]= m;}


            }
        }
        return mass;
    }





}
