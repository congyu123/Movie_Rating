package entity;

import java.util.Date;

public class History {
    private String movieName;
    private int userid;
    private Date addTime;

    // Getters and Setters
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }

    public Date getAddTime() { return addTime; }
    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
