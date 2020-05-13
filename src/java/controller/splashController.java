package controller;

import java.util.ArrayList;
import java.util.List;
import data.splash;
import data.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class splashController extends databaseController {

    private final int SPLASH = 0;
    private final int USER = 1;

    public List<splash> getAllSplashes() {
        List<splash> s = getAllSplashes(null, null, null, null);
        setLastEvent("getAllSplashes");
        return s;
    }

    public List<splash> getAllSplashes(int count, int start) {
        List<splash> s = getAllSplashes(null, null, count, start);
        setLastEvent("getAllSplashes");
        return s;
    }

    public List<splash> getAllSplashes(int userID) {
        List<splash> s = getAllSplashes(userID, USER, null, null);
        setLastEvent("getAllSplashes");
        return s;
    }

    public splash getSplash(int ID) {
        splash s = getAllSplashes(ID, SPLASH, null, null).get(0);
        setLastEvent("getSplash");
        return s;
    }

    public splash getSplashByUser(int ID) {
        splash s = getAllSplashes(ID, USER, null, null).get(0);
        setLastEvent("getSplash");
        return s;
    }

    private List<splash> getAllSplashes(Integer ID, Integer mode, Integer Count, Integer Start) {
        List<splash> list = new ArrayList<>();

        sql = "select * from SPLASH ";

        if (mode != null) {

            switch (mode) {
                case SPLASH:
                    sql += "where ID = ? ";

                    break;

                case USER:
                    sql += "where USERID = ? ";

                    break;
            }

        }

        sql += "order by ID desc";

        if (Count != null) {
            sql += "limit ? ";

            if (Start != null) {
                sql += "offset ? ";
            }

        }

        try {
            int idx = 1;
            PreparedStatement query = conn.prepareStatement(sql);

            if (ID != null) {
                query.setInt(idx++, ID);
            }
            if (Count != null) {
                query.setInt(idx++, Count);
            }
            if (Start != null) {
                query.setInt(idx, Start);
            }

            ResultSet rs = query.executeQuery();

            splash s;
            userController uc = new userController();
            while (rs.next()) {
                s = new splash();

                s.setID(rs.getInt("ID"));
                s.setColour(rs.getString("COLOUR"));
                s.setLikes(rs.getInt("NUM"));
                s.setWord(rs.getString("WORD"));

                int userID = rs.getInt("USERID");
                user u = uc.getUserByID(userID);
                s.setUser(u);

                list.add(s);
            }

        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
        }

        return list;
    }

    public boolean createSplash(splash s) {
        boolean result;
        sql = "insert into SPLASH (COLOUR, NUM, USERID, WORD) values (?, ?, ?, ?)";

        try {
            PreparedStatement query = conn.prepareStatement(sql);

            query.setString(1, s.getColour());
            query.setInt(2, s.getLikes());
            query.setInt(3, s.getUserID());
            query.setString(4, s.getWord());

            result = query.execute();
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("createSplash");
        return result;
    }

    public boolean updateSplash(splash s) {
        boolean result;
        sql = "update SPLASH set COLOUR = ?, NUM = ?, USERID = ? where ID = ?";

        try {
            PreparedStatement query = conn.prepareStatement(sql);

            query.setString(1, s.getColour());
            query.setInt(2, s.getLikes());
            query.setInt(3, s.getUserID());
            query.setInt(4, s.getID());

            result = query.executeUpdate() != 0;
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("updateSplash");
        return result;
    }

    public boolean deleteSplash(int ID) {
        boolean result;
        sql = "delete from SPLASH where ID = ?";

        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.setInt(1, ID);

            result = query.execute();
        } catch (Exception e) {
            error = e.toString() + " " + Arrays.toString(e.getStackTrace());
            System.out.println(error);
            result = false;
        }

        setLastEvent("deleteSplash");
        return result;
    }

}
