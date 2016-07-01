import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by q on 28.06.2016.
 */
//чтение запись
public class WretiRead {
    public static void write(String file,String text) throws IOException {
        FileWriter writer=new FileWriter(file,true);
        writer.write(text);


    }
    public static int read(String file)throws IOException{
        FileReader reader=new FileReader(file);
        int str= reader.read();
    return str;}

}
