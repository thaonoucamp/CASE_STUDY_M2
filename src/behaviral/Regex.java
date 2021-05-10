package behaviral;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean matches(String regex, String property) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(property);
        matcher.matches();
        if (matcher.matches()) {
            return true;
        } else {
            System.err.println("Enter to repeat the property ");
        }
        return false;
    }

    public boolean onlyId(ArrayList<Integer> idLists, String id) {
        int checkId = Integer.parseInt(id);
        if (idLists == null) {
            idLists.add(checkId);
            return true;
        } else {
            for (int i = 0; i < idLists.size(); i++) {
                if (idLists.get(i) != checkId) {
                    idLists.add(checkId);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}