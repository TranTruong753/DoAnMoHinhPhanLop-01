/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author M S I
 */
public class OfficeAssignment {

    private int instructorID;
    private String location;
    private Date timestamp;

    public OfficeAssignment() {
    }

    public OfficeAssignment(int instructorID, String location, Date timestamp) {
        this.instructorID = instructorID;
        this.location = location;
        this.timestamp = timestamp;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.instructorID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OfficeAssignment other = (OfficeAssignment) obj;
        return this.instructorID == other.instructorID;
    }
}
