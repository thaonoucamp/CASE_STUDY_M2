package behaviral;

import java.util.ArrayList;

public interface ISchool<T> {
    float SCHOLARSHIP = 9.0f;

    T input();

    void add(ArrayList<T> list);

    void edit(ArrayList<T> list);

    void delete(ArrayList<T> list);

}
