package creat;

public class Student extends Person {
    private String email;
    private String id;
    private Mark mark;

    public Student() {
    }

    public Student(String email, String id, Mark mark) {
        this.email = email;
        this.id = id;
        this.mark = mark;
    }

    public Student(String name, String birthday, String id, String address, String gender, String email, String id1, Mark mark) {
        super(name, birthday, address, gender);
        this.email = email;
        this.id = id;
        this.mark = mark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", mark=" + mark +
                '}';
    }
}
