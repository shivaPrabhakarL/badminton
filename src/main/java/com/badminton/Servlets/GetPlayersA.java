package com.badminton.Servlets;

import com.badminton.PlayerDB;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetPlayersA",urlPatterns = "/GetPlayersA")
public class GetPlayersA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerDB db = new PlayerDB();
        Gson gson = new Gson();
        String team = req.getParameter("team");
        resp.getWriter().write(gson.toJson(db.getPlayersByTeam(team)));

        // System.out.println(tdb.listAll());
    }
}
