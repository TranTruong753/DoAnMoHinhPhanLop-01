/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class CourseInstructor {
    private int courseID ;
    private int personID ;

    public CourseInstructor(int courseID, int personID) {
        this.courseID = courseID;
        this.personID = personID;
    }

    public CourseInstructor() {
    }
    
    

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.courseID;
        hash = 59 * hash + this.personID;
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
        final CourseInstructor other = (CourseInstructor) obj;
        if (this.courseID != other.courseID) {
            return false;
        }
        return this.personID == other.personID;
    }

    @Override
    public String toString() {
        return "courseinstructorDTO{" + "courseID=" + courseID + ", personID=" + personID + '}';
    }


}
