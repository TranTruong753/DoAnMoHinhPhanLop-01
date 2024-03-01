/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class CourseDAO {

    //Lấy tất cả Khóa học trong bảng course
    public ArrayList<Course> getAll() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String sql = "select * from course";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(1));
                course.setTitle(rs.getString(2));
                course.setCredits(rs.getInt(3));
                course.setDepartmentID(rs.getInt(4));
                courseList.add(course);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return courseList;
    }

    // xóa khóa học trong bảng course
    public boolean delete(int courseID) {
        boolean result = false;
        String sql = "delete from course where CourseID = ?";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, courseID);
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    //Thêm khóa học trong bảng course
    public boolean insert(Course c)  {
        boolean result = false;
        String sql = "insert into course values(NULL,N'" + c.getTitle() + "'," + c.getCredits() + "," + c.getDepartmentID() + ")";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeUpdate();
            result =true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }
    
    //hàm sửa 1 khóa học trong bảng course
     public boolean update(Course c) {
        boolean result = false;
        String sql = "update course"
                + " \nset Title = N'"+c.getTitle()+"', Credits = "+c.getCredits()+","
                + " DepartmentID = "+c.getDepartmentID()+""
                + " \nwhere CourseID = "+c.getCourseID();
         System.out.println(sql);
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeUpdate();
            result =true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }


    //  tìm kiếm khóa học theo từ khóa, và mục cần tìm
    public ArrayList<Course> findCourse(String key, int selectedIndexCombobox) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String cln = "";
        if (selectedIndexCombobox == 0) {
            cln = "CourseID";
        } else if (selectedIndexCombobox == 1) {
            cln = "Title";
        } else if (selectedIndexCombobox == 2) {
            cln = "Credits";
        } else if (selectedIndexCombobox == 3) {
            cln = "DepartmentID";
        }

        String sql = "select * from course where " + cln + " like '%" + key + "%'";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(1));
                course.setTitle(rs.getString(2));
                course.setCredits(rs.getInt(3));
                course.setDepartmentID(rs.getInt(4));
                courseList.add(course);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return courseList;
    }


}
