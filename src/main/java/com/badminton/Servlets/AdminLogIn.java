package com.badminton.Servlets;

import com.badminton.Admin;
import com.badminton.AdminDB;
import com.badminton.PlayerDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


//import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
@WebServlet(name = "AdminLogIn",urlPatterns = "/AdminLogIn")
public class AdminLogIn extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = req.getRequestDispatcher("/adminReg.html");
//        requestDispatcher.forward(req, resp);
        PlayerDB database = new PlayerDB();
       String s = (req.getParameter("data"));
        PrintWriter p = resp.getWriter();
        Gson gson = new Gson();
        String str = database.getDetails(s);
        p.write(gson.toJson(str));

    }
}