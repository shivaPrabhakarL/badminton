package com.badminton.Servlets;

import com.badminton.Teams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "GetTeamsA",urlPatterns = "/GetTeamsA")
public class GetTeamsA extends HttpServlet {
    TeamsDB tdb = new TeamsDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();

       resp.getWriter().write(gson.toJson(tdb.listAll()));
       // System.out.println(tdb.listAll());
    }

}
