/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DepartmentDAO {

    //hàm lấy ra tất cả department
    public ArrayList<Department> getAll() {
        ArrayList<Department> list = new ArrayList<>();
        String query = "select * from Department";
        DatabaseAccess databaseAccess = new DatabaseAccess();

        try {
            Connection conn = databaseAccess.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department tmp = new Department();
                tmp.setDepartmentID(rs.getInt(1));
                tmp.setName(rs.getString(2));
                tmp.setBudget(rs.getDouble(3));
                tmp.setStartDate(rs.getDate(4));
                tmp.setAdministrator(rs.getInt(5));
                list.add(tmp);
            }
            if (conn != null) {
                conn.close();

            }
            databaseAccess.getConnection().close();

            return list;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return list;
    }

}
