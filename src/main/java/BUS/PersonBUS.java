/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CourseInstructorDAO;
import DAO.PersonDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PersonBUS {
    PersonDAO person =new PersonDAO();
    public List<Person> selectAll() {
        
        List<Person> list = person.selectAll();
        return list;
    }
    
    public Person selectById(Person t) {
        return person.selectById(t);
    }
    
    public List<Person> getStatistic() {   
        List<Person> list = person.getStatistic();
        return list;
    }
    
    
}
