/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import BUS.*;

/**
 *
 * @author ACER
 */
public class StudentGrade {
    private int enrollmentID;
    private int courseId;
    private int studentId;
    private String firstname;
    private String lastname;
    private Double grade;

    public StudentGrade() {
    }

    public StudentGrade(int enrollmentID, int courseId, int studentId, String firstname, String lastname, Double grade) {
        this.enrollmentID = enrollmentID;
        this.courseId = courseId;
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
}
