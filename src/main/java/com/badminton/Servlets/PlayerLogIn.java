package com.badminton.Servlets;

import com.badminton.PlayerDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PlayerLogIn", urlPatterns = "/PlayerLogIn")
public class PlayerLogIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        PlayerDB database = new PlayerDB();
        System.out.println("before login check");
        boolean result = database.checkLogin(email,password);
        System.out.println("after login check");
        if(result)
        {

            Cookie cUserName = new Cookie("cookuser", email.trim());
         //   Cookie cPassword = new Cookie("cookpass", email.trim());
            cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days
          //  cPassword.setMaxAge(60 * 60 * 24 * 15);
            resp.addCookie(cUserName);
           // resp.addCookie(cPassword);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("sessuser", email.trim());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("playerDetails.html");
            requestDispatcher.forward(req, resp);
            System.out.println("cookie enabled");
            out.write("s");
        }
        else
        {
            System.out.println("f");
            out.write("failure");
        }
    }
}
