package struct;

import behaviral.Management;
import login.Login;

import java.io.IOException;

public class Menu {

    public static void main(String[] args) throws IOException {
        Login login = new Login();
        boolean checkLogin = true;
        String[] accountInput;
        do {
            accountInput = login.creatLogin();
            if (login.checkAccount(login.account, accountInput)) {
                checkLogin = false;
                Management management = new Management();
                management.menu();
            }
        } while (checkLogin);
    }
}
