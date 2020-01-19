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

@WebServlet(name = "AdminLogIn",urlPatterns = "/AdminLogIn")
public class AdminLogIn extends HttpServlet{
    Player player;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, JsonSyntaxException, NumberFormatException, NullPointerException {
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = req.getRequestDispatcher("/adminReg.html");
//        requestDispatcher.forward(req, resp);
        PlayerDB database = new PlayerDB();
       String s = (req.getParameter("data"));
        System.out.println(s);
        PrintWriter p = resp.getWriter();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ResultSet str = database.getDetails(s);
        Player play = createPlayer(str);
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

    public Player createPlayer(ResultSet res){
        Player player = new Player();
        try {

            player.setFirstName(res.getString("firstName"));
            player.setLastName(res.getString("lastName"));
            player.setEmail(res.getString("email"));
            player.setGender(res.getString("gender"));
            player.setTeam(res.getString("team"));
            player.setImage(res.getString("image"));
            player.setPhone(res.getString("phone"));
            player.setType(res.getString("type"));
            player.setShirtSize(res.getString("shirtSize"));
            player.setEmpId(res.getString("empId"));
            player.setAge(res.getString("age"));
            player.setMatchesPlayed(res.getString("matchesPlayed"));
            player.setPosition(res.getString("position"));
            player.setBidStatus(res.getString("bidStatus"));
            player.setPassword(res.getString("password"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return player;
    }
}