/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CourseInstructor;
import DTO.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class PersonDAO {
    public List<Person> selectAll() {
    //Lấy tất cả đối tượng trong bảng
        List<Person> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM person";
            PreparedStatement st = db.getConnection().prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
               Person s = new Person();
               s.setPersonID(rs.getInt("PersonID"));
               s.setLastname(rs.getString("Lastname"));
               s.setFirstname(rs.getString("Firstname"));
               s.setHireDate(rs.getDate("HireDate"));
               s.setEnrollmentDate(rs.getDate("EnrollmentDate"));
               list.add(s);
            }
            // Bước 5:
            db.getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return list;
    }

    public Person selectById(Person t) {
    //Lấy 1 đối tượng trong bảng thông qua ID
        Person obj = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM person WHERE PersonID=?";
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {        
               obj = new Person();
               obj.setPersonID(rs.getInt("PersonID"));
               obj.setLastname(rs.getString("Lastname"));
               obj.setFirstname(rs.getString("Firstname"));
               obj.setHireDate(rs.getDate("HireDate"));
               obj.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            }
            // Bước 5:
            db.getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return obj;
    }

    public int insert(Person t) {
    //Thêm 1 đối tượng vào bảng  
        int result = 0;
        try {
           // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql="insert into person(PersonID,Lastname,Firstname,HireDate,EnrollmentDate)"
               + "VALUES(?,?,?,?,?)";
            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            st.setString(2, t.getLastname());
            st.setString(3, t.getFirstname());
            st.setDate(4, (Date) t.getHireDate());
            st.setDate(5, (Date) t.getEnrollmentDate());

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

    public int insertAll(List<Person> arr) {
    //Thêm tất cả đối tượng vào bảng  
        int count = 0;
        for(Person item: arr) {
            count += this.insert(item);
        }
        return count ; // Đã thêm thành công count(số điếm) đối tượng
    }

    public int delete(Person t) {
    //Xóa 1 đối tượng trong bảng 
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from person where PersonID = ?"; 

            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setInt(1, t.getPersonID());
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

    public int deleteAll(List<Person> arr) {
    int count = 0;
        for(Person item: arr) {
            count += this.delete(item);
        }
        return count ; // Đã xóa thành công count(số điếm) đối tượng
    }

    public int update(Person t) {
    //Cập nhật 1 đối tượng trong bảng
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();
            
            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE person SET Lastname = ?,Firstname = ?,HireDate = ?,EnrollmentDate = ? WHERE PersonID = ?"; 

            PreparedStatement st = db.getConnection().prepareStatement(sql);
            st.setString(1, t.getLastname());
            st.setString(2, t.getFirstname());
            st.setDate(3, (Date) t.getHireDate());
            st.setDate(4, (Date) t.getEnrollmentDate());
            st.setInt(5, t.getPersonID());
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
    
    public List<Person> getStatistic(){
        //Lấy tất cả đối tượng trong bảng
        List<Person> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            DatabaseAccess db = new DatabaseAccess();
            // Bước 2: tạo ra đối tượng statement
            String sql = 
//            "SELECT \n" +
//            "    person.PersonID,\n" +
//            "    person.Lastname,\n" +
//            "    person.Firstname,\n" +
//            "    person.HireDate,\n" +
//            "    person.EnrollmentDate,\n" +
//            "    COUNT(person.PersonID) AS Quantity \n" +
//            "FROM \n" +
//            "    courseinstructor\n" +
//            "INNER JOIN \n" +
//            "    person ON courseinstructor.PersonID = person.PersonID \n" +
//            "GROUP BY \n" +
//            "    person.PersonID;";
            "SELECT \n" +
            "    person.PersonID,\n" +
            "    person.Lastname,\n" +
            "    person.Firstname,\n" +
            "    person.HireDate,\n" +
            "    person.EnrollmentDate,\n" +
            "    COALESCE(COUNT(courseinstructor.PersonID), 0) AS Quantity \n" +
            "FROM \n" +
            "    person\n" +
            "LEFT JOIN \n" +
            "    courseinstructor ON person.PersonID = courseinstructor.PersonID \n" +
            "WHERE \n" +
            "    person.EnrollmentDate IS NULL\n" +
            "GROUP BY \n" +
            "    person.PersonID, person.Lastname, person.Firstname, person.HireDate, person.EnrollmentDate;";
            PreparedStatement st = db.getConnection().prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
               Person s = new Person();
               s.setPersonID(rs.getInt("PersonID"));
               s.setLastname(rs.getString("Lastname"));
               s.setFirstname(rs.getString("Firstname"));
               s.setHireDate(rs.getDate("HireDate"));
               s.setEnrollmentDate(rs.getDate("EnrollmentDate"));
               s.setQuantity(rs.getInt("Quantity"));
               list.add(s);
            }
            // Bước 5:
            db.getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return list;
    }
    
   
    
    
    
}
