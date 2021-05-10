package behaviral;

import behaviral.ISchool;
import creat.Mark;
import creat.Student;

import java.io.IOException;
import java.util.ArrayList;

public abstract class AbsManagement implements ISchool<Student> {
    @Override
    public Student input() {
        return null;
    }

    @Override
    public void add(ArrayList<Student> list) throws IOException {

    }

    @Override
    public void edit(ArrayList<Student> list) throws IOException {

    }

    @Override
    public void delete(ArrayList<Student> list) throws IOException {

    }

    public void find(ArrayList<Student> list) {
    }

    public void show(ArrayList<Student> list) throws IOException {
    }

    public void sort(ArrayList<Student> list) throws IOException {
    }

    public void checkScholarship(ArrayList<Student>list, ArrayList<Student> scholarship) throws IOException {
    }

    public float inputMark(){
        return 0;
    }
}
