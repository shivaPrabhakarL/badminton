package com.badminton.Servlets;

import com.badminton.Admin;
import com.badminton.AdminDB;
import com.badminton.PlayerDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.badminton.Player;
import java.lang.NullPointerException;
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
import com.google.gson.JsonSyntaxException;
import java.lang.NumberFormatException;
import java.sql.*;

@WebServlet(name = "PlayerDetails",urlPatterns = "/PlayerDetails")
public class PlayerDetails extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, JsonSyntaxException, NumberFormatException, NullPointerException {
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = req.getRequestDispatcher("/adminReg.html");
//        requestDispatcher.forward(req, resp);

        PlayerDB database = new PlayerDB();
       String s = (req.getParameter("data"));

        PrintWriter p = resp.getWriter();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        ResultSet str = database.getDetails(s);

        Player player = new Player();
        Player play = player.createPlayer(str);
        System.out.println(play.toString());
        //Player player;
        try {
            if (!str.equals(null)) {
                 player = gson.fromJson(play.toString(), Player.class);
                System.out.println(gson.toJson(player));
                 p.write(gson.toJson(player));
            } else {
                p.write("null");
            }
        }catch (NullPointerException n){
            n.printStackTrace();
        }

    }


}