package behaviral;

import behaviral.ISchool;
import creat.Mark;
import creat.Student;

import java.util.ArrayList;

public abstract class AbsManagement implements ISchool<Student> {
    @Override
    public Student input() {
        return null;
    }

    @Override
    public void add(ArrayList<Student> list) {

    }

    @Override
    public void edit(ArrayList<Student> list) {

    }

    @Override
    public void delete(ArrayList<Student> list) {

    }

    public void find(ArrayList<Student> list) {
    }

    public void show(ArrayList<Student> list) {
    }

    public void sort(ArrayList<Student> list) {
    }

    public void checkScholarship(ArrayList<Student>list, ArrayList<Student> scholarship){
    }

    public Mark inputMark(){
        return null;
    }
}
