package behaviral;

import creat.Mark;
import creat.Student;
import myFile.FileObject;
import myFile.FileObject;

import java.util.*;

public class Management extends AbsManagement {
    transient Scanner sc = new Scanner(System.in);

    FileObject fileObj = new FileObject();

    Regex match = new Regex();

    ArrayList<Student> studentArrayList = new ArrayList<>();

    ArrayList<Integer> idLists = new ArrayList<>();
    //    ArrayList<Student> scholarship = new ArrayList<>();
    ArrayList<Student> studentArrayList = fileObj.readObj(new ArrayList<Student>()) == null ? new ArrayList<>() : fileObj.readObj(new ArrayList<Student>());

    @Override
    public Student input() {
        Student newStudent = new Student();
        String regex;

        System.out.println("Enter the name");
        regex = "^[]{1,}$";
        String name = sc.nextLine();
        if (matchInput(regex, name)) {
            newStudent.setName(name);
        }

        System.out.println("Enter the birthday");
        regex = "^[0-9]{2}[/|-]{1}[0-9]{2}[/|-]{1}[0-9]{4}$";
        String birthday = sc.nextLine();
        if (matchInput(regex, birthday)) {
            newStudent.setBirthday(birthday);
        }

        System.out.println("Enter the address");
        newStudent.setAddress(sc.nextLine());

        System.out.println("Enter the gender");
        newStudent.setGender(sc.nextLine());

        System.out.println("Enter the email");
        newStudent.setEmail(sc.nextLine());

        System.out.println("Enter the id");
        String id = sc.nextLine();
        if (matchId(idLists, id)){
            newStudent.setId(id);
        }

        System.out.println("Enter the mark");
        newStudent.setMark(inputMark());

        return newStudent;

    }

    public boolean matchInput(String regex, String every) {
        boolean check = false;
        do {
            every = sc.nextLine();
            if (match.matches(regex, every)) {
                check = true;
                return true;
            }
        } while (check);
        return false;
    }

    @Override
    public void add(ArrayList<Student> list) {
        fileObj.writerObj(list);

        System.out.println("Enter the quantity want to add");
        int quantity = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter add index " + (i + 1));
            list.add(input());
        }
        sort(list);
        show(list);
//        fileObj.writerObj(list);
        fileObj.readObj(list);

    }

    public boolean matchId(ArrayList<Integer> listId, String id) {
        int item = Integer.parseInt(id);
        boolean check = false;
        do {
            if (match.only(listId, item)) {
                check = true;
                return true;
            }else {
                System.err.println("The id had exits...invited enter to repeat");
            }
        } while (check);
        return false;
    }

    @Override
    public void edit(ArrayList<Student> list) {
//        fileObj.readObj(list);

        System.out.println("Enter the id want to edit");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, input());
                break;
            }
        }
        show(list);
        fileObj.readObj(list);

//        fileObj.writerObj(list);
    }

    @Override
    public void delete(ArrayList<Student> list) {
//        fileObj.readObj(list);

        System.out.println("Enter the id want to edit");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(list.get(i));
                break;
            }
        }
        show(list);
        fileObj.readObj(list);

//        fileObj.writerObj(list);
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
    public void show(ArrayList<Student> list) {
        sort(list);

        for (Student s :
                list) {
            System.out.println(s);
        }
    }

    @Override
    public void sort(ArrayList<Student> list) {
        float min = list.get(0).getMark().getAverage();
        Student temp;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                float next = list.get(j).getMark().getAverage();
                if (next < min) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    @Override
    public void checkScholarship(ArrayList<Student> list, ArrayList<Student> scholarship) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMark().getAverage() >= SCHOLARSHIP) {
                scholarship.add(list.get(i));
            }
        }
        show(scholarship);
    }

    @Override
    public Mark inputMark() {
        Mark newMark = new Mark();
        float sum = 0;

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

        sum = (newMark.getMath() + newMark.getBiology() + newMark.getChemistry() + newMark.getComputer() + newMark.getPhysics() + newMark.getEnglish()) / 6;
        newMark.setAverage(sum);

        return newMark;
    }

    public void editMark(ArrayList<Student> list) {
        System.out.println("Enter the id want to edit of mark");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.get(i).setMark(inputMark());
                break;
            }
        }
    }

    public void menu() {
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
