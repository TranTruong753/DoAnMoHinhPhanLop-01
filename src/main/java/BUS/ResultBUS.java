/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ResultDAO;
import DTO.Course;
import DTO.Person;
import DTO.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ResultBUS {
    private ResultDAO RSDAO=new ResultDAO();
    
    public ArrayList<Course> GetCourseOnline(){
        return RSDAO.GetCourseOnline();
    }
    public ArrayList<Course> GetCourseOffline(){
        return RSDAO.GetCourseOffline();
    }
    public ArrayList<StudentGrade> GetStudent(int courseid) {
        return RSDAO.GetStudent(courseid);
    }
    public boolean UpdateStudent(ArrayList<Object[]> data, int courseid) {
        return RSDAO.UpdateStudent(data, courseid);
    }
    public boolean DeleteStudent(int studentId,int courseId){
        return RSDAO.DeleteStudent(studentId, courseId);
    }
    public String AddPerson ( Person ps  ){
        if(RSDAO.addPerson(ps)){
            return "Ghi danh thành công";
        }
        return "Ghi danh thất bại";
    }
    public int NewIDPerson (){
        return RSDAO.getMaxPersonID();
    }
    public ArrayList<Person> GetAllStudent(){
        return RSDAO.getAllStudent();
    }
    public String AddStudentCource ( StudentGrade studentGrade, int CourseID, int studentID  ){
        if(RSDAO.addStudentGrade(studentGrade, CourseID, studentID)){
            return "Thêm học viên vào khóa học thành công";
        }
        return "Thêm thất bại. Học viên đã tồn tại!";
    }
    
    public boolean isCourseExists(int courseID) {
        for(StudentGrade studentGrade : RSDAO.GetStudent(courseID)) {
            if(studentGrade.getCourseId() == courseID) {
                return true;
            }
        }
        return false;
    }    
}
