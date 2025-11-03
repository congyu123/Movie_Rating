package entity;

import java.util.Date;

public class Collection {
    private String userName;
    private String movieName;
    private Date addTime;

    // Getters and Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public Date getAddTime() { return addTime; }
    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
