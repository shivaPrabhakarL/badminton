package com.badminton.Servlets;

import com.badminton.Admin;
import com.badminton.Database;
import com.badminton.Teams;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamsDB {
    Database db = new Database();
    private static Statement stmt;
    public TeamsDB() {
        stmt  = db.dbConnection();
    }

    public void createOrUpdateDB(Teams t){
        try {
            // stmt.executeUpdate("truncate table TaskList");
            String query = "create table teamtable(" +
                    "TeamId  INT AUTO_INCREMENT PRIMARY KEY,Name varchar(255) NOT NULL, MatchesPlayed INT, Wins Int, Losses INT, Position INT, Points INT, empId INT UNIQUE, FOREIGN KEY (empId) REFERENCES users(empId)  )";
            stmt.executeUpdate(query);
            query = "insert into teamtable values(" + t.getTeamid() + ",'" + t.getName() + "','" + t.getMatchesPlayed() + "', '" + t.getWins() + "','" + t.getLosses() + "','" + t.getPosition() + "','" + t.getPoints() + "','" + t.getEmpId() + "' )";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            try {
                String query = "insert into teamtable values(" + t.getTeamid() + ",'" + t.getName() + "','" + t.getMatchesPlayed() + "', '" + t.getWins() + "','" + t.getLosses() + "','" + t.getPosition() + "','" + t.getPoints() + "','" + t.getEmpId() + "' )";
                System.out.println(query);
                stmt.executeUpdate(query);
            } catch (SQLException q) {
                String response = "Sql query not correct or no such data.";
                System.out.println(response);
            }
        }
    }

    public  ArrayList<String> listAll(){
        try{
            String query = "select Name from teamtable";
            ResultSet rs =  stmt.executeQuery(query);
            ArrayList<String> teamName = new ArrayList<>();
            while(rs.next()){
                teamName.add(rs.getString("Name"));
            }
            return teamName;
        }catch (SQLException q) {
            String response = "Sql query not correct or no such data.";
            System.out.println(response);
            return null;
        }
    }

}
