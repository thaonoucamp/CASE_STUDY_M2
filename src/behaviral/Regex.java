package behaviral;

import creat.Student;

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
        }
        return false;
    }
}