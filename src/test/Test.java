package test;

import behaviral.Regex;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String item = sc.nextLine();
        ArrayList<Integer> test = new ArrayList<Integer>();
        Regex regex = new Regex();
        test.add(1);
        regex.onlyId(test, item);
        for (int i:
             test) {
            System.out.println(i);
        }
    }
}
