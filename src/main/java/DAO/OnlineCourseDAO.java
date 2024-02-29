/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.Course;
import BUS.OnlineCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class OnlineCourseDAO extends DatabaseAccess {

    public ArrayList<OnlineCourse> getAll() {
        ArrayList<OnlineCourse> onlineCourseList = new ArrayList<OnlineCourse>();
        String sql = "select * from onlinecourse";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OnlineCourse onlineCourse = new OnlineCourse();
                onlineCourse.setCourseID(rs.getInt(1));
                onlineCourse.setUrl(rs.getString(2));

                onlineCourseList.add(onlineCourse);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return onlineCourseList;
    }

    // xóa khóa học
    public boolean delete(int courseID) {
        boolean result = false;
        String sql = "delete from onlinecourse where CourseID = ?";
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
      //Thêm khóa học trong bảng onlinecourse
    public boolean insert(OnlineCourse c)  {
        boolean result = false;
        String sql = "insert into onlinecourse values(" + c.getCourseID()+ ",N'" + c.getUrl() + "')";
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
    
    //hàm sửa 1 khóa học trong bảng onlinecourse
     public boolean update(OnlineCourse c) {
        boolean result = false;
        String sql = "update onlinecourse"
                + " \nset url = N'"+c.getUrl()+"'"
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
}
