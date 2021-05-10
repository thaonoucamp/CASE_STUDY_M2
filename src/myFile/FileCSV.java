package myFile;

import creat.Student;

import java.io.*;
import java.util.ArrayList;

public class FileCSV {
    public String FILE_PATH = "/Users/thaodangxuan/IdeaProjects/CASE_STUDY_M2/src/myFile/student.txt";

    public void writer(String filePath, ArrayList<Student> list) throws IOException {
        FileWriter fw = new FileWriter(new File(filePath));

        for (Student s : list) {
            fw.write(s.toString() + "\n");
        }

        fw.close();
    }

    public String reader(String filePath) throws IOException {
        String result = "";

        FileReader fr = new FileReader(new File(filePath));
        BufferedReader bfr = new BufferedReader(fr);

        String line;
        while ((line = bfr.readLine()) != null) {
            result = result.concat(line + "\n");
        }
        bfr.close();
        fr.close();

        return result;
    }

    public ArrayList<Student> swapCSV(String filePath) {
        ArrayList<Student> lists = new ArrayList<>();

        String[] students = filePath.split("\n");
        if (students.length != 0) {
            for (int i = 0; i < students.length; i++) {
                String studentItem = students[i];
                String[] elements = studentItem.split(",");

                lists.add(new Student(elements[0], elements[1], elements[2],
                        elements[3], elements[4], elements[5], Float.parseFloat(elements[6])));
            }
        }
        return lists;
    }
}
