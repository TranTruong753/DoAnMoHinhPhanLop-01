/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OnlineCourseDAO;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class OnlineCourseBUS {
    
    OnlineCourseDAO onlineCourseDAO = new OnlineCourseDAO();

    public ArrayList<OnlineCourse> getAll() {
        return onlineCourseDAO.getAll();
    }
    
    public boolean isCourseExists(int courseID) {
        for (OnlineCourse onlineCourse : onlineCourseDAO.getAll()) {
            if (onlineCourse.getCourseID() == courseID) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(OnlineCourse onlineCourse)
    {
        return onlineCourseDAO.insert(onlineCourse);
    }
    
     public boolean update(OnlineCourse onlineCourse)
    {
        return onlineCourseDAO.update(onlineCourse);
    }
    public boolean delete(int courseID) {
        return onlineCourseDAO.delete(courseID);
    }
    
    public OnlineCourse getByID(int courseID) {
        for (OnlineCourse onlineCourse : onlineCourseDAO.getAll()) {
            if (onlineCourse.getCourseID() == courseID) {
                return onlineCourse;
            }
        }
        return null;
    }
    
}
