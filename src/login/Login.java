package login;

import behaviral.Regex;

import java.util.Scanner;

public class Login {
    transient Scanner sc = new Scanner(System.in);

    public String[] account = {"dangxuanthao", "26061990"};

    Regex regexLogin = new Regex();

    public String[] creatLogin() {
        String[] loginAccount = new String[2];
        Account account = new Account();
        System.out.println("LOGIN ACCOUNT");
        System.out.print("user name: ");
        String regexUser = "^[a-zA-Z0-9]*$";
        String user = sc.nextLine();
        boolean checkUser = true;
        do {
            if (regexLogin.matches(regexUser, user)) {
                account.setUser(user);
                loginAccount[0] = account.getUser();
                checkUser = false;
            } else {
                System.err.println("Enter repeat username");
            }
        } while (checkUser);

        System.out.print("password: ");
        String regexPass = "^[0-9]{8}*$";
        String pass = sc.nextLine();

        boolean checkPass = true;
        do {
            if (regexLogin.matches(regexUser, user)) {
                account.setPass(pass);
                loginAccount[1] = account.getPass();
                checkPass = false;
            } else {
                System.err.println("Enter repeat password");
            }
        } while (checkPass);

        return loginAccount;
    }

    public boolean checkAccount(String[] accountGiven, String[] accountInput) {
        for (int i = 0; i < accountGiven.length; i++) {
            if (accountGiven[i].equals(accountInput[i])) {
                return true;
            }
        }
        return false;
    }
}
