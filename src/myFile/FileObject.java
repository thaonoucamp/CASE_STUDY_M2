package myFile;

import creat.Student;

import java.io.*;
import java.util.ArrayList;

public class FileObject {
    String filePath = "/Users/thaodangxuan/IdeaProjects/CASE_STUDY_M2/src/myFile/student.dat";

    File file = new File(filePath);

    public ArrayList<Student> readObj(ArrayList<Student> list) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Student>) ois.readObject();
            ois.close();
            fis.close();
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writerObj(ArrayList<Student> list) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
