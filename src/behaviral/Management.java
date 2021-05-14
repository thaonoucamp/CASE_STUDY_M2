package behaviral;

import creat.Mark;
import creat.Student;
import myFile.FileCSV;
import myFile.FileObject;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management extends AbsManagement {
    transient Scanner sc = new Scanner(System.in);

    FileCSV fileCSV = new FileCSV();

    Regex regex = new Regex();

    ArrayList<Student> studentArrayList;

    public Management() throws IOException {
        studentArrayList = fileCSV.swapCSV(fileCSV.reader(fileCSV.FILE_PATH)) == null ?
                new ArrayList<>() : fileCSV.swapCSV(fileCSV.reader(fileCSV.FILE_PATH));
    }

    @Override
    public Student input() throws IOException {

        Student newStudent = new Student();
        System.out.println("Enter the id");
        boolean checkId = true;
        do {
            String id = sc.nextLine();
            if (onlyId(studentArrayList, id)) {
                newStudent.setId(id);
                checkId = false;
            }
        } while (checkId);

        System.out.println("Enter the name");
        String name = sc.nextLine();
        newStudent.setName(name);

        System.out.println("Enter the birthday");
        String regexBorn = "^[0-9]{2}[/|-]{1}[0-9]{2}[/|-]{1}[0-9]{4}$";
        String birthday;
        boolean checkBorn = true;
        do {
            birthday = sc.nextLine();
            if (regex.matches(regexBorn, birthday)) {
                newStudent.setBirthday(birthday);
                checkBorn = false;
            } else {
                System.err.println("Enter repeat the birthday");
            }
        } while (checkBorn);

        System.out.println("Enter the address");
        newStudent.setAddress(sc.nextLine());

        System.out.println("Enter the gender");
        newStudent.setGender(sc.nextLine());

        System.out.println("Enter the email");
        String regexMail = "^[a-z0-9]*@[a-z0-9]*[\\.][a-z]*$";
        String email;
        boolean checkMail = true;
        do {
            email = sc.nextLine();
            if (regex.matches(regexMail, email)) {
                newStudent.setEmail(email);
                checkMail = false;
            } else {
                System.err.println("Enter repeat the mail");
            }
        } while (checkMail);

        newStudent.setMark(inputMark());

        return newStudent;
    }

    public boolean onlyId(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.err.println("The id is existed");
                return false;
            }
        }
        return true;
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

        fileCSV.writer(fileCSV.FILE_PATH, studentArrayList);
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
        fileCSV.writer(fileCSV.FILE_PATH, studentArrayList);

    }

    @Override
    public void delete(ArrayList<Student> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the id want to delete");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(list.get(i));
                break;
            }
        }
        show(list);
        fileCSV.writer(fileCSV.FILE_PATH, studentArrayList);

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
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                float min = list.get(j).getMark();
                float max = list.get(j - 1).getMark();
                if (min > max) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    @Override
    public void checkScholarship(ArrayList<Student> list) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMark() >= SCHOLARSHIP) {
                System.out.println(list.get(i));
            }
        }
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
        fileCSV.writer(fileCSV.FILE_PATH, studentArrayList);

    }

    public void menu() throws IOException {
        int choice;
        do {
            System.out.println("-----------------------" +
                    "\nMenu:" +
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
                    checkScholarship(studentArrayList);
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
