/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CourseInstructor;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseInstructorDAO {

    public ArrayList<CourseInstructor> selectAll() {
    //Lấy tất cả đối tượng trong bảng  
        ArrayList<CourseInstructor> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM courseinstructor";
            PreparedStatement st = db.getConnection().prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");
                CourseInstructor courseinstructor = new CourseInstructor(courseID, personID);
                list.add(courseinstructor);
            }
            db.getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return list;
    }

    public CourseInstructor selectById(CourseInstructor t) {
    //Lấy 1 đối tượng trong bảng thông qua ID
        CourseInstructor courseinstructor = null ;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM courseinstructor WHERE CourseID = ?";
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            
            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");
                courseinstructor = new CourseInstructor(courseID, personID);
            }
            // Bước 5:
            db.getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return courseinstructor;
    }

    public int insert(CourseInstructor t) {
    //Thêm 1 đối tượng vào bảng  
        int result = 0;
        try {
           // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO courseinstructor (CourseID, PersonID)"+ "VALUES(?,?)"; 
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            st.setInt(2, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();
      
            // Bước 4: đóng kết nối
            db.getConnection().close(); 
        }catch (SQLException e){
            e.printStackTrace();
        }
//        result = 0 : Thêm thất bại , result = 1 : Thêm thành công
        return result;
    }

    public int insertAll(ArrayList<CourseInstructor> arr) {
    //Thêm tất cả đối tượng vào bảng  
        int count = 0;
        for(CourseInstructor item: arr) {
            count += this.insert(item);
        }
        return count ; // Đã thêm thành công count(số điếm) đối tượng
    }

    public int delete(CourseInstructor t) {
    //Xóa 1 đối tượng trong bảng 
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();
            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from courseinstructor "+
                             " WHERE CourseID=? AND PersonID=?";

            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            st.setInt(2, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();        

            // Bước 4:
            db.getConnection().close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
//        result = 0 : Xóa thất bại , result = 1 : Xóa thành công
        return result;
    }

    public int deleteAll(ArrayList<CourseInstructor> arr) {
    //Xóa tất cả đối tượng trong bảng 
        int count = 0;
        for(CourseInstructor item: arr) {
            count += this.delete(item);
        }
        return count ; // Đã xóa thành công count(số điếm) đối tượng
    }

    public int update(CourseInstructor t) {
    //Cập nhật 1 đối tượng trong bảng
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();
            // Bước 2: tạo ra đối tượng statement
            String sql =  "UPDATE courseinstructor "+
                        " SET " +
                        " PersonID=?"+
                        " WHERE CourseID=?";

            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            st.setInt(2, t.getCourseID());
            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();        

            // Bước 4:
            db.getConnection().close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        result = 0 : update thất bại , result = 1 : update thành công
        return result;
    }
    
    
    
}
