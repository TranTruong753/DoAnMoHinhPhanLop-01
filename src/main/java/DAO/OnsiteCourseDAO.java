/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.OnsiteCourse;
import BUS.OnsiteCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class OnsiteCourseDAO {

    public ArrayList<OnsiteCourse> getAll() {
        ArrayList<OnsiteCourse> onsiteCourseList = new ArrayList<OnsiteCourse>();
        String sql = "select * from onsitecourse";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OnsiteCourse onsiteCourse = new OnsiteCourse();
                onsiteCourse.setCourseID(rs.getInt(1));
                onsiteCourse.setLocation(rs.getString(2));
                onsiteCourse.setDays(rs.getString(3));
                onsiteCourse.setTime(rs.getTime(4) + "");
                onsiteCourseList.add(onsiteCourse);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return onsiteCourseList;
    }

    public boolean insert(OnsiteCourse onsiteCourse) {
        boolean result = false;
        String sql = "insert into onsitecourse values(? ,?, ?, ?)";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, onsiteCourse.getCourseID());
            ps.setString(2, onsiteCourse.getLocation());
            ps.setString(3, onsiteCourse.getDays());
            ps.setString(4, onsiteCourse.getTime());
            int n = ps.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    // xóa khóa học
    public boolean delete(int courseID) {
        boolean result = false;
        String sql = "delete from onsitecourse where CourseID = ?";
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

    public boolean update(OnsiteCourse onsiteCourse) {
        boolean result = false;
        String sql = "update onsitecourse set Location = ?, Days = ?, Time = ? where CourseID = ?";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, onsiteCourse.getLocation());
            pstm.setString(2, onsiteCourse.getDays());
            pstm.setTime(3, Time.valueOf(onsiteCourse.getTime()));
            pstm.setInt(4, onsiteCourse.getCourseID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }
}
