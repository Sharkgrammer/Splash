package controller;

import data.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class userController extends databaseController {

    public user getUserByID(int ID) {
        user u = getAllUsers(ID, null, false).get(0);
        setLastEvent("getUserByID");
        return u;
    }

    public user getUserByEmail(String email) {
        user u = getAllUsers(null, email, true).get(0);
        setLastEvent("getUserByEmail");
        return u;
    }

    private List<user> getAllUsers(Integer ID, String email, boolean login) {
        List<user> list = new ArrayList<>();

        sql = "select * from USERS ";

        if (ID != null) {
            sql += "where ID = ?";
        } else if (email != null) {
            sql += "where EMAIL = ?";
        }

        try {
            int idx = 1;
            PreparedStatement query = conn.prepareStatement(sql);

            if (ID != null) {
                query.setInt(idx++, ID);
            }
            if (email != null) {
                query.setString(idx++, email);
            }

            ResultSet rs = query.executeQuery();

            user u;
            while (rs.next()) {
                u = new user();

                u.setID(rs.getInt("ID"));
                u.setName(rs.getString("NAME"));
                if (login) {
                    u.setPass(rs.getString("PASS"));
                }
                u.setEmail(rs.getString("EMAIL"));
                u.setProfile(rs.getString("IMAGE"));
                list.add(u);
            }

        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
        }

        return list;
    }

    public boolean createUser(user u) {
        boolean result;
        sql = "insert into USERS (NAME, PASS, EMAIL, IMAGE) values (?, ?, ?, ?)";

        try {
            PreparedStatement query = conn.prepareStatement(sql);

            query.setString(1, u.getName());
            query.setString(2, u.getPass());
            query.setString(3, u.getEmail());
            query.setString(4, u.getProfile());

            result = query.execute();
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("createUser");
        return result;
    }

    public boolean updateUser(user u) {
        boolean result;
        sql = "update USERS set NAME = ?, PASS = ?, EMAIL = ?, IMAGE = ? where ID = ?";

        try {
            PreparedStatement query = conn.prepareStatement(sql);

            query.setString(1, u.getName());
            query.setString(2, u.getPass());
            query.setString(3, u.getEmail());
            query.setString(4, u.getProfile());
            query.setInt(5, u.getID());

            result = query.executeUpdate() != 0;
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("updateUser");
        return result;
    }

    public boolean deleteUser(int ID) {
        boolean result;
        sql = "delete from USERS where ID = ?";

        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.setInt(1, ID);

            result = query.execute();
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("deleteUser");
        return result;
    }

}
