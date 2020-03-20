package handlers;

import controller.userController;
import java.util.List;
import data.user;

public class userHandler {

    private final userController con;

    public userHandler() {
        con = new userController();
    }

    public boolean register(String name, String pass, String email) {
        user u = new user();
        u.setName(name);
        u.setPass(pass);
        u.setEmail(email);
        boolean result = con.createUser(u);

        return result;
    }

    public user login(String email, String pass) {

        try {
            user u = con.getUserByEmail(email);

            System.out.println(con.lastEvent);

            if (u.getPass().equals(pass)) {
                return u;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

}
