/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CourseInstructorDAO;
import DTO.CourseInstructor;
import java.util.List;

/**
 *
 * @author M S I
 */
public class CourseInstructorBUS {

    CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();

    public List<CourseInstructor> selectAll() {

        List<CourseInstructor> list = courseInstructorDAO.selectAll();
        return list;
    }

    public int insert(CourseInstructor t) {
        if (courseInstructorDAO.insert(t) == 1) {
            return 1;
        }
        return 0;

    }

    public int update(CourseInstructor t) {
        if (courseInstructorDAO.update(t) == 1) {
            return 1;
        }
        return 0;
    }

    public CourseInstructor selectById(CourseInstructor t) {
        return courseInstructorDAO.selectById(t);
    }

    public int delete(CourseInstructor t) {
        return courseInstructorDAO.delete(t);
    }

    public boolean isCourseExists(int courseID) {
        for(CourseInstructor courseInstructor : courseInstructorDAO.selectAll()) {
            if(courseInstructor.getCourseID() == courseID) {
                return true;
            }
        }
        return false;
    }
}
