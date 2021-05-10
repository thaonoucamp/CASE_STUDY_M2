package behaviral;

import creat.Mark;
import creat.Student;
import myFile.FileCSV;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management extends AbsManagement {
    transient Scanner sc = new Scanner(System.in);

    FileCSV fileCSV = new FileCSV();

    Regex regex = new Regex();

    ArrayList<Integer> idLists = new ArrayList<>();

    ArrayList<Student> studentArrayList;

    ArrayList<Student> scholarship = new ArrayList<>();

    public Management() throws IOException {
        studentArrayList = fileCSV.swapCSV(fileCSV.reader(fileCSV.FILE_PATH));
    }

    @Override
    public Student input() {
        Student newStudent = new Student();

        System.out.println("Enter the name");
        String regexName = "^[a-zA-Z]*$";
        String name = sc.nextLine();
        if (regex.matches(regexName, name)) {
            newStudent.setName(name);
        }

        System.out.println("Enter the birthday");
        String regexBorn = "^[0-9]{2}[/|-]{1}[0-9]{2}[/|-]{1}[0-9]{4}$";
        String birthday = sc.nextLine();
        if (regex.matches(regexBorn, birthday)) {
            newStudent.setBirthday(birthday);
        }

        System.out.println("Enter the address");
        newStudent.setAddress(sc.nextLine());

        System.out.println("Enter the gender");
        newStudent.setGender(sc.nextLine());

        System.out.println("Enter the email");
        String regexMail = "^[a-zA-Z0-9]*[\\@]+[a-zA-Z0-9]*[\\.][a-z]*$";
        String email = sc.nextLine();
        if (regex.matches(regexMail, email)) {
            newStudent.setEmail(email);
        }

        System.out.println("Enter the id");
        String id;
        do {
            id = sc.nextLine();
            if (regex.onlyId(idLists, id)) {
                newStudent.setId(id);
                break;
            }
        } while (regex.onlyId(idLists, id) == false);


        System.err.println("Enter the mark");
        newStudent.setMark(inputMark());

        return newStudent;

    }

    @Override
    public void add(ArrayList<Student> list) throws IOException {

        System.out.println("Enter the quantity want to add");
        int quantity = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter add index " + (i + 1));
            list.add(input());
        }
        sort(list);
        show(list);

        fileCSV.writer(fileCSV.FILE_PATH, list);
    }

    @Override
    public void edit(ArrayList<Student> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the id want to edit");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, input());
                break;
            }
        }
        show(list);
        fileCSV.writer(fileCSV.FILE_PATH, list);

    }

    @Override
    public void delete(ArrayList<Student> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the id want to edit");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(list.get(i));
                break;
            }
        }
        show(list);
        fileCSV.writer(fileCSV.FILE_PATH, list);

    }

    @Override
    public void find(ArrayList<Student> list) {
        System.out.println("Enter the id want to find");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println(list.get(i));
                break;
            }
        }
    }

    @Override
    public void show(ArrayList<Student> list) throws IOException {
        sort(list);

        for (Student s :
                list) {
            System.out.println(s);
        }
    }

    @Override
    public void sort(ArrayList<Student> list) throws IOException {
        float min = list.get(0).getMark();
        Student temp;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                float next = list.get(j).getMark();
                if (next < min) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        fileCSV.writer(fileCSV.FILE_PATH, list);

    }

    @Override
    public void checkScholarship(ArrayList<Student> list, ArrayList<Student> scholarship) throws IOException {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMark() >= SCHOLARSHIP) {
                scholarship.add(list.get(i));
            }
        }
        show(scholarship);
    }

    @Override
    public float inputMark() {
        Mark newMark = new Mark();

        System.out.println("Enter the Math");
        newMark.setMath(Float.parseFloat(sc.nextLine()));

        System.out.println("Enter the physics");
        newMark.setPhysics(Float.parseFloat(sc.nextLine()));

        System.out.println("Enter the chemistry");
        newMark.setChemistry(Float.parseFloat(sc.nextLine()));

        System.out.println("Enter the biology");
        newMark.setBiology(Float.parseFloat(sc.nextLine()));

        System.out.println("Enter the english");
        newMark.setEnglish(Float.parseFloat(sc.nextLine()));

        System.out.println("Enter the computer");
        newMark.setComputer(Float.parseFloat(sc.nextLine()));

        float sum = (newMark.getMath() + newMark.getBiology() + newMark.getChemistry()
                + newMark.getComputer() + newMark.getPhysics() + newMark.getEnglish()) / 6;
        newMark.setAverage(sum);

        return sum;
    }

    public void editMark(ArrayList<Student> list) throws IOException {
        System.out.println("Enter the id want to edit of mark");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.get(i).setMark(inputMark());
                break;
            }
        }
        fileCSV.writer(fileCSV.FILE_PATH, list);

    }

    public void menu() throws IOException {
        int choice;
        do {
            System.out.println("Menu:" +
                    "\n1. ADD" +
                    "\n2. EDIT" +
                    "\n3. DELETE" +
                    "\n4. FIND" +
                    "\n5. CHECK_SCHOLARSHIP" +
                    "\n6. SHOW_ALL" +
                    "\n7. EDIT_MARK" +
                    "\n8. EXIT" +
                    "\nEnter your choice ?");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    add(studentArrayList);
                    break;
                case 2:
                    edit(studentArrayList);
                    break;
                case 3:
                    delete(studentArrayList);
                    break;
                case 4:
                    find(studentArrayList);
                    break;
                case 5:
                    checkScholarship(studentArrayList, scholarship);
                    break;
                case 6:
                    show(studentArrayList);
                    break;
                case 7:
                    editMark(studentArrayList);
                    break;
                case 8:
                    System.exit(8);
            }
        } while (choice != 0);
    }
}
