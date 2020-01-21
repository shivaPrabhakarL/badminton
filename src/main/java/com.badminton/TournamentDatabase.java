package com.badminton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TournamentDatabase {
    Database db = new Database();
    Statement stmt;
    public TournamentDatabase(){ stmt = db.dbConnection();}

    public void createTournament(String name,String wPrize,String rPrize,String loc,String email){
        PlayerDB pdb = new PlayerDB();
        String id = pdb.empIdOfPlayer(email);

            try {
                String query = "insert into tourmentable(name,winPrize,runPrize,location,empId) values('" + name + "','" + wPrize + "','" + rPrize + "','" + loc + "','"+id+"') ;";
                System.out.println(query);
                stmt.executeUpdate(query);
            }catch (SQLException s){
                s.printStackTrace();
            }

    }

    public String empIdOfTour(String email){
        PlayerDB pdb = new PlayerDB();
        String id = pdb.empIdOfPlayer(email);
        try{
            String query = "select name from tournamentable where empId = '"+id+"' ;";
            ResultSet rs = stmt.executeQuery(query);
            return rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public ResultSet getAll(){
        try{
            String query = "select * from tourmentable";
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
