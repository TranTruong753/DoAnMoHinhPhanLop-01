/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.Course;
import BUS.StudentGrade;
import BUS.Person;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class ResultDAO {

    public DatabaseAccess dtb = new DatabaseAccess();
    ArrayList<Course> courseInfoListOnl = new ArrayList<>();
    ArrayList<Course> courseInfoListOff = new ArrayList<>();
    ArrayList<StudentGrade> ListStudentGrade = new ArrayList<>();

    public ArrayList<StudentGrade> GetStudent(int courseid) {
        try {
            Connection conn = dtb.getConnection();
            StudentGrade std;
            String sql = "SELECT studentgrade.studentid, person.lastname, person.firstname, studentgrade.grade "
                    + "FROM person "
                    + "INNER JOIN studentgrade ON person.personid = studentgrade.studentid "
                    + "WHERE studentgrade.courseid=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseid); // Thiết lập giá trị cho tham số courseid
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                std = new StudentGrade();
                std.setStudentId(rs.getInt("studentid"));
                std.setFirstname(rs.getString("firstname"));
                std.setLastname(rs.getString("lastname"));
                std.setGrade(rs.getDouble("grade"));
                ListStudentGrade.add(std);
            }
            conn.close();
            return ListStudentGrade;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean UpdateStudent(ArrayList<Object[]> data, int courseid) {
        try {
            Connection conn = dtb.getConnection();
            String sql = "UPDATE studentgrade SET grade = ? WHERE studentid = ? AND courseid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for (Object[] rowData : data) {
                double grade = Double.parseDouble(rowData[1].toString());
                int studentid = (int) rowData[0];
                stmt.setDouble(1, grade);
                stmt.setInt(2, studentid);
                stmt.setInt(3, courseid);
                stmt.executeUpdate();
            }
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Course> GetCourseOnline() {
        try {
            Connection conn = dtb.getConnection();
            Course onl;
            String sql = "SELECT onlinecourse.courseid, course.title "
                    + "FROM onlinecourse "
                    + "INNER JOIN course ON onlinecourse.courseid = course.courseid";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                onl = new Course();
                int courseId = rs.getInt("CourseID");
                String title = rs.getString("Title");
                onl.setCourseID(courseId);
                onl.setTitle(title);
                courseInfoListOnl.add(onl);
            }
            conn.close();
            return courseInfoListOnl;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Course> GetCourseOffline() {
        try {
            Connection conn = dtb.getConnection();
            Course off;
            String sql = "SELECT onsitecourse.courseid, course.title "
                    + "FROM onsitecourse "
                    + "INNER JOIN course ON onsitecourse.courseid = course.courseid";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                off = new Course();
                int courseId = rs.getInt("CourseID");
                String title = rs.getString("Title");
                off.setCourseID(courseId);
                off.setTitle(title);
                courseInfoListOff.add(off);
            }
            conn.close();
            return courseInfoListOff;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean DeleteStudent(int studentId, int courseId) {
        try {
            Connection conn = dtb.getConnection();
            // Chuẩn bị câu lệnh SQL để xóa dữ liệu trong bảng studentgrade
            String sql = "DELETE FROM studentgrade WHERE StudentId = ? AND CourseId = ?";

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                // Thiết lập các tham số cho câu lệnh SQL
                statement.setInt(1, studentId);
                statement.setInt(2, courseId);

                // Thực thi câu lệnh SQL để xóa dữ liệu
                int rowsAffected = statement.executeUpdate();

                // Kiểm tra xem có dòng nào bị ảnh hưởng không
                if (rowsAffected > 0) {
                    // Trả về true nếu xóa thành công
                    return true;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý các trường hợp xảy ra lỗi khi thao tác với cơ sở dữ liệu
        }

        // Trả về false nếu xóa thất bại hoặc không có dòng nào bị ảnh hưởng
        return false;
    }

    public boolean addPerson(Person ps) {
        try {
            Connection conn = dtb.getConnection();

            // Câu truy vấn INSERT INTO
            String getMaxIdQuery = "SELECT MAX(PersonID) FROM Person";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getMaxIdQuery);

            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt(1);
            }

            // Đặt PersonID mới là giá trị lớn nhất + 1
            ps.setPersonID(maxId + 1);

            // Câu truy vấn INSERT INTO
            String sql = "INSERT INTO Person (personID, LastName, FirstName, HireDate, EnrollmentDate) VALUES (?, ?, ?, ?, ?)";

            // Tạo PreparedStatement và thiết lập giá trị cho các tham số
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ps.getPersonID());
            pstm.setString(2, ps.getLastname());
            pstm.setString(3, ps.getFirstname());

            // Nếu HireDate là null thì thiết lập giá trị NULL, ngược lại sẽ là giá trị của HireDate
            if (ps.getHireDate() == null) {
                pstm.setNull(4, java.sql.Types.TIMESTAMP);
            } else {
                Timestamp hireDate = new Timestamp(ps.getHireDate().getTime());
                pstm.setTimestamp(4, hireDate);
            }

            // Thiết lập giá trị cho EnrollmentDate là giá trị ngày giờ hiện tại
            Timestamp enrollmentDate = new Timestamp(System.currentTimeMillis());
            pstm.setTimestamp(5, enrollmentDate);
            // Thực hiện truy vấn INSERT
            int affectedRows = pstm.executeUpdate();

            conn.close();
            // Kiểm tra xem có dòng nào được thêm vào không
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxPersonID() {
        int maxPersonID = 0;

        try {
            Connection conn = dtb.getConnection();
            Statement stmt = conn.createStatement();

            // Truy vấn để lấy giá trị lớn nhất của PersonID
            String getMaxIdQuery = "SELECT MAX(PersonID) FROM Person";
            ResultSet rs = stmt.executeQuery(getMaxIdQuery);

            if (rs.next()) {
                maxPersonID = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxPersonID + 1;
    }

    public ArrayList<Person> getAllStudent() {
        ArrayList<Person> StudentList = new ArrayList<Person>();
        String sql = "SELECT personid, lastname, firstname FROM person WHERE enrollmentdate IS NOT NULL";
        DatabaseAccess db = new DatabaseAccess();
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Person ps = new Person();
                ps.setPersonID(rs.getInt("personid"));
                ps.setLastname(rs.getString("lastname"));
                ps.setFirstname(rs.getString("firstname"));
                StudentList.add(ps);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return StudentList;
    }

    public boolean addStudentGrade(StudentGrade stdGrade, int courseID, int studentID) {
        try (Connection conn = dtb.getConnection()) {
            // Kiểm tra xem đã tồn tại dòng với cùng CourseID và StudentID chưa
            if (!isDuplicateRecord(conn, courseID, studentID)) {
                String getMaxIdQuery = "SELECT MAX(enrollmentID) FROM studentgrade";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getMaxIdQuery);

                int maxId = 0;
                if (rs.next()) {
                    maxId = rs.getInt(1);
                }
                stdGrade.setEnrollmentID(maxId + 1);
                // Nếu không có trùng lặp, thực hiện thêm dữ liệu
                String sql = "INSERT INTO studentgrade (enrollmentID, CourseID, StudentID, Grade) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, stdGrade.getEnrollmentID());
                    pstmt.setInt(2, stdGrade.getCourseId());
                    pstmt.setInt(3, stdGrade.getStudentId());
                    pstmt.setDouble(4, stdGrade.getGrade());

                    int rowsAffected = pstmt.executeUpdate();
                    conn.close();
                    return rowsAffected > 0;
                }
            } else {
                // Nếu có trùng lặp, không thêm dữ liệu và trả về false
                conn.close();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isDuplicateRecord(Connection conn, int courseID, int studentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM studentgrade WHERE CourseID = ? AND StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, courseID);
            pstmt.setInt(2, studentID);

            try (var resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }

        return false;
    }

}
