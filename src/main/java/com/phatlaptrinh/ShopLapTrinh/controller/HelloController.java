package com.phatlaptrinh.ShopLapTrinh.controller;

import com.phatlaptrinh.ShopLapTrinh.dto.UserDTO;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

@Controller
public class HelloController {
    private String DB_URL = "jdbc:mysql://localhost:3306/springbootwebshop";
    private String USER = "root";
    private String PASS = "123123";
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView hello()
    {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("model", "Test model Phatlaptrinh deeptrai!");
        return mav;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "message", required = false) String message) {
        ModelAndView mav = new ModelAndView("/login");
        mav.addObject("model", message);
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("model") UserDTO model) {
        //data access
        String message = null;
        Boolean status = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM user WHERE username = '"+model.getUserName()+"' AND password = '"+model.getPassword()+"'";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql.toString());
            status = rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null) {
                    conn.close();
                }
                if(stm!=null) {
                    stm.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //service
        if (status) {
            message = "success";
        } else {
            message = "fail";
        }
        return new ModelAndView("redirect:/login?message="+message);
    }
}
