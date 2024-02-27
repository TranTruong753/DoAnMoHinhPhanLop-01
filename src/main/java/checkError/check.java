/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkError;

import java.sql.Time;

/**
 *
 * @author DELL
 */
public class check {

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    //hàm check 1 chuỗi là số nguyên và lơn hơn 0
    public static boolean is_integer_number_and_greater_than_0(String n) {
        //flag = 1 => số nguyên
        //flag = 0 => số thực
        String errStr = "";
        boolean flag = true;
        if (isNumeric(n)) {
            Double x = Double.parseDouble(n);
            if (Math.ceil(x) != Math.floor(x)) {
                flag = false;
            }
            if (flag == true && x > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean check_time_format(String time) {
        String timeRegex = "^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$";
        if (time.matches(timeRegex)) {
            return true;
        } 
            return false;
        
    }

    public static void main(String[] args) {
//        System.out.println(check.check_time_format("24:24"));
        Time.valueOf("22:55");
        
    }
}
