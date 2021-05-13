package myFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileObject {
    public static String FILE_ID = "/Users/thaodangxuan/IdeaProjects/CASE_STUDY_M2/src/myFile/id.txt";

    public static void writeObjectToFile(Object serObj, String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile(String filepath) {
        ArrayList<String> list = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            String obj;
            while ((obj = (String) objectIn.readObject()) != null) {
                list.add(obj);
            }
            objectIn.close();
            return list;
        } catch (Exception ex) {
            System.out.println("File is empty !");
            return null;
        }
    }
}
