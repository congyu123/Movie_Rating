package entity;

import java.util.Date;

public class Comment {
    private String userName;
    private String movieName;
    private String description;
    private Date addTime;

    // Getters and Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getAddTime() { return addTime; }
    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
