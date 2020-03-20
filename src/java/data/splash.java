package data;

public class splash {

    private int ID;
    private String colour;
    private int likes;
    private user user;
    private String word;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public String getUserName() {
        return user.getName();
    }

    public int getUserID() {
        return user.getID();
    }

    public String getWord() {
        if (word == null){
            return "";
        }
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
