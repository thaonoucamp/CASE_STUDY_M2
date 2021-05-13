package behaviral;

import java.io.IOException;
import java.util.ArrayList;

public interface ISchool<T> {
    float SCHOLARSHIP = 9.0f;

    T input() throws IOException;

    void add(ArrayList<T> list) throws IOException;

    void edit(ArrayList<T> list) throws IOException;

    void delete(ArrayList<T> list) throws IOException;

}
