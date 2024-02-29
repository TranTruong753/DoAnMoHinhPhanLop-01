/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.Time;

/**
 *
 * @author M S I
 */
public class OnsiteCourse {
    private int courseID;
    private String days;
    private String location;
    private String time;

    public OnsiteCourse() {
    }

    public OnsiteCourse(int courseID, String days, String location, String time) {
        this.courseID = courseID;
        this.days = days;
        this.location = location;
        this.time = time;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    
    
}
