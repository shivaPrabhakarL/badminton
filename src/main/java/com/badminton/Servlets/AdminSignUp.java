package com.badminton.Servlets;

import com.badminton.Admin;
import com.badminton.AdminDB;
import com.fasterxml.jackson.databind.ObjectMapper;


//import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
@WebServlet(name ="AdminSignUp", urlPatterns = "/AdminSignUp")
public class AdminSignUp extends HttpServlet{
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = new Admin();
        admin.setFirstName(req.getParameter("firstName"));
        admin.setLastName(req.getParameter("lastName"));
        admin.setUserName(req.getParameter("userName"));
        admin.setEmail(req.getParameter("email"));
        admin.setPassword(req.getParameter("password"));
        admin.setId();
        PrintWriter out = resp.getWriter();
        AdminDB adb = new AdminDB();
        adb.createOrUpdateDB(admin);
        out.println("signed up.");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter o = resp.getWriter();
        o.println("hi");
    }
}