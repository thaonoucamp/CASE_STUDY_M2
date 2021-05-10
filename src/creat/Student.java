package creat;

public class Student extends Person {
    private String email;
    private String id;
    private float mark;

    public Student(String email, String id, float mark) {
        this.email = email;
        this.id = id;
        this.mark = mark;
    }

    public Student(String name, String birthday, String address, String gender, String email, String id, float mark) {
        super(name, birthday, address, gender);
        this.email = email;
        this.id = id;
        this.mark = mark;
    }

    public Student() {

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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", mark=" + mark +
                '}';
    }
}
