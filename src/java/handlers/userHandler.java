package handlers;

import controller.userController;
import java.util.List;
import data.user;

public class userHandler {

    private final userController con;

    public userHandler() {
        con = new userController();
    }

    public boolean register(String name, String pass, String email, String profilePath) {
        user u = new user();
        u.setName(name);
        u.setPass(pass);
        u.setEmail(email);
        u.setProfile(profilePath);
        boolean result = con.createUser(u);

        return result;
    }

    public user login(String email, String pass) {

        try {
            user u = con.getUserByEmail(email);

            if (u.getPass().equals(pass)) {
                return u;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public user getUserByID(int ID) {

        try {
            user u = con.getUserByID(ID);

            if (u != null) {
                return u;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

}
