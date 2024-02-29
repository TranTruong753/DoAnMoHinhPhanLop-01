/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OnsiteCourseDAO;

/**
 *
 * @author M S I
 */
public class OnsiteCourseBUS {

    OnsiteCourseDAO onsiteCourseDAO = new OnsiteCourseDAO();

    public boolean insert(OnsiteCourse onsiteCourse) {
        return onsiteCourseDAO.insert(onsiteCourse);
    }

    public OnsiteCourse getByID(int courseID) {
        for (OnsiteCourse OnsiteCourse : onsiteCourseDAO.getAll()) {
            if (OnsiteCourse.getCourseID() == courseID) {
                return OnsiteCourse;
            }
        }
        return null;
    }

    public boolean delete(int courseID) {
        return onsiteCourseDAO.delete(courseID);
    }

    public boolean isCourseExists(int courseID) {
        for (OnsiteCourse onsiteCourse : onsiteCourseDAO.getAll()) {
            if (onsiteCourse.getCourseID() == courseID) {
                return true;
            }
        }
        return false;
    }

    public boolean update(OnsiteCourse onsiteCourse) {
        return onsiteCourseDAO.update(onsiteCourse);
    }
}
