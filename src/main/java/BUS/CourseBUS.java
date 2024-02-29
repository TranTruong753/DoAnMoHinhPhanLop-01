/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CourseDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class CourseBUS {

    CourseDAO courseDAO = new CourseDAO();

    // lấy toàn bộ khóa học
    public ArrayList<Course> getAll() {
        return courseDAO.getAll();
    }

    // lấy ra khóa học thông qua mã
    public Course getByID(int courseID) {
        for (Course course : courseDAO.getAll()) {
            if (course.getCourseID() == courseID) {
                return course;
            }
        }
        return null;
    }
    //thêm 1 khóa học trong bảng onlinecourse
    public boolean insert(Course c) 
    {
        return courseDAO.insert(c);
    }
    
    //sửa 1 khóa học trong bảng onlinecourse
    public boolean update(Course c) 
    {
        return courseDAO.update(c);
    }


    // xóa khóa học
    public boolean delete(int courseID) {
        return courseDAO.delete(courseID);
    }

    //lấy CourseID tiếp theo của course 
   public int  getNextId()
   {
       ArrayList<Course> list = getAll();
       return list.get(list.size()-1).getCourseID()+1;
   }
   
   //lấy courseID cuối cùng
   public int  getLastId()
   {
       ArrayList<Course> list = getAll();
       return list.get(list.size()-1).getCourseID();
   }
   
    // lấy ra khóa học thông qua mã
    public ArrayList<Course> findCourse(String key, int selectedIndexComboboxSearch) {
        return courseDAO.findCourse(key, selectedIndexComboboxSearch);
    }
}
