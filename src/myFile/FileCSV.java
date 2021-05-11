package myFile;

import creat.Student;

import java.io.*;
import java.util.ArrayList;

public class FileCSV {
    public String FILE_ID = "/Users/thaodangxuan/IdeaProjects/CASE_STUDY_M2/src/myFile/id.txt";
    public String FILE_PATH = "/Users/thaodangxuan/IdeaProjects/CASE_STUDY_M2/src/myFile/student.txt";

    public void writer(String filePath, ArrayList<Student> list) throws IOException {
        FileWriter fw = new FileWriter(new File(filePath));
        for (Student s : list) {
            fw.write(s.getName() + "," + s.getBirthday() + "," + s.getAddress() + ","
                    + s.getGender() + "," + s.getEmail() + "," + s.getId() + "," + s.getMark() + "\n");
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

    public ArrayList<Student> swapCSV(String content) {
        ArrayList<Student> lists = new ArrayList<>();

        String[] students = content.split("\n");

        for (int i = 0; i < students.length; i++) {
            String studentItem = students[i];
            String[] elements = studentItem.split(",");
            if (elements.length == 7) {
                lists.add(new Student(elements[0], elements[1], elements[2],
                        elements[3], elements[4], elements[5], Float.parseFloat(elements[6])));
            }
        }
        return lists;
    }

    public void writerId(ArrayList<Integer> listId, File filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(String.valueOf(filePath)));

        for (int i : listId) {
            fileWriter.write(i);
        }
        fileWriter.close();
    }

    public ArrayList<Integer> readId(File filePath) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        FileReader reader = new FileReader(new File(String.valueOf(filePath)));
        int item;
        while ((item = reader.read()) != -1) {
            item = reader.read();
            list.add(item);
        }
        reader.close();
        return list;
    }
}
