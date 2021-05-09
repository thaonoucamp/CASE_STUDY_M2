package behaviral;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean matches(String regex, String every) {
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(every);
        if (mat.matches()) {
            return true;
        }
        return false;
    }

    public boolean only(ArrayList<Integer> lists, int id) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists == null) {
                lists.add(id);
                return true;
            } else if (lists.get(i) != id) {
                lists.add(id);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
