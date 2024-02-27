/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DepartmentDAO;
import DTO.Department;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DepartmentBUS {
    DepartmentDAO dao = new DepartmentDAO();
    
    public ArrayList<Department> getAll() {
        return dao.getAll();
    }
    
    public Department getByID(int departmentID) {
        for(Department department : dao.getAll()) {
            if(department.getDepartmentID() == departmentID) {
                return department;
            }
        }
        return null;
    }
}
