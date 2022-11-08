package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper {
    private static File file;
    private static FileWriter writer;

    public static String getcurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public static void createFile(){
        file = new File("src/main/logs/logs_"+getcurrentDate() + ".txt");
        try {
            writer = new FileWriter((file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(String text){
        try {
            writer.write(text+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void closeWriter(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

