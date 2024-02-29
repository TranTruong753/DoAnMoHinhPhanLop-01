/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Department {
    private int departmentID;
    private String name;
    private double budget;
    private Date startDate;
    private int administrator;

    public Department() {
    }

    public Department(int departmentID, String name, double budget, Date startDate, int administrator) {
        this.departmentID = departmentID;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    @Override
    public String toString() {
        return "department{" + "departmentID=" + departmentID + ", name=" + name + ", budget=" + budget + ", startDate=" + startDate + ", administrator=" + administrator + '}';
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.departmentID;
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
        final Department other = (Department) obj;
        return this.departmentID == other.departmentID;
    }

    
    
    
}
