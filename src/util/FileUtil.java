package util;

import java.io.FileWriter;

public class FileUtil {
    public static void saveData(String data){
        try{
            FileWriter fw=new FileWriter("data.txt",true);
            fw.write(data+"\n");
            fw.close();
        }catch(Exception e){
            System.out.println("File error");
        }
    }
}