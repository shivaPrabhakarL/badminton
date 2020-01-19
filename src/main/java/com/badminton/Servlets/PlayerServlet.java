package com.badminton.Servlets;


import com.badminton.Player;
import com.badminton.PlayerDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PlayerServlet", urlPatterns = "/PlayerServlet")
public class PlayerServlet extends HttpServlet {

    public PlayerServlet()
    {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fname = req.getParameter("firstName");
        String lname = req.getParameter("lastName");
        //String uname = req.getParameter("userName");
        String email = req.getParameter("email");
        //String gender = req.getParameter("gender");
        //String image = req.getParameter("image");
        //String phone = req.getParameter("phone");
        //String ssize = req.getParameter("shirtSize");
        int eid =Integer.parseInt( req.getParameter("empId"));
        //String age = req.getParameter("age");
        String pwd = req.getParameter("password");

        PlayerDB database = new PlayerDB();
        database.addPlayer(fname,lname,email,eid,pwd);

    }
}