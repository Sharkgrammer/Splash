package handlers;

import controller.splashController;
import java.util.List;
import data.splash;
import data.user;

public class splashHandler {

    private final splashController con;

    public splashHandler() {
        con = new splashController();
    }

    public List<splash> getUserSplashes(int ID) {
        return con.getAllSplashes(ID);
    }
    
    public List<splash> getAllSplashes() {
        return con.getAllSplashes();
    }

    public List<splash> getAllSplashes(int count, int start) {
        return con.getAllSplashes(count, start);
    }

    public boolean createSplash(String colour, String word, user u) {
        splash s = new splash();
        s.setColour(colour);
        s.setLikes(0);
        s.setUser(u);
        s.setWord(word);

        return con.createSplash(s);
    }

}
