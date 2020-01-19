package com.badminton;

import java.sql.*;
import com.google.gson.Gson;


public class PlayerDB {
    Database db = new Database();
    //Connection con;
    Statement stmt;

    public PlayerDB()
    {
        stmt = db.dbConnection();
    }




    public int addPlayer(String firstName, String lastName, String email, int eid, String password)
    {
        try {
            String query = " create table users(\n" +
                    " firstName varchar(25), lastName varchar(25), userName varchar(20), email varchar(40), gender varchar(15),\n" +
                    " team varchar(20) default \"none\", image varchar(100) default \"http://cdn.onlinewebfonts.com/svg/img_184513.png\",\n" +
                    " phone varchar(13) , type varchar(15), shirtSize varchar(10), empId int unique, age int,\n" +
                    " matchesPlayed int default 0, position int default 0, bidStatus int default -1, role varchar(15) default \"player\", password varchar(30),\n" +
                    " userId int auto_increment, primary key (userId)\n" +
                    " );";
            stmt.executeUpdate(query);
            System.out.println("in add Player");
             query = "insert into users (firstName,lastName,email,empId,password) values(\""+firstName+"\",\""+lastName+"\",\""
                    +email+"\","+eid+",\""+password+"\");";
            System.out.println(query);

            stmt.executeUpdate(query);
        }
        catch (Exception e) {
            try{

                String query = "insert into users (firstName,lastName,email,empId,password) values(\""+firstName+"\",\""+lastName+"\",\""
                        +email+"\","+eid+",\""+password+"\");";
                stmt.executeUpdate(query);
            }catch(SQLException s){
                String response = "Sql query not correct or no such data.";
                System.out.println(response);
            }

        }

        return 1;
    }

    public boolean checkLogin(String email, String password)  {
        try {
            String query = "select password from users where email = \"" + email +"\";";
            System.out.println("query = "+query);
            ResultSet rs = stmt.executeQuery(query);
            boolean rsq = rs.next();
            System.out.println(rsq);
             if(rsq){
                 String pass = rs.getString("password");
                 System.out.println(pass);
                 System.out.println(pass.equals(password));
                 return pass.equals(password);
             }else{
                 System.out.println("else block 1 false");
                return false;
            }

        }
        catch (SQLException e)
        {
            System.out.println("catch block 1 false");
            return false;
        }
    }


    public boolean modifyPlayer(String player,String team, String type, int matches, int position, int bidStatus)
    {
        try {
            String query = "update users set team = \"" +team+ "\", type = \"" +type +"\", matchesPlayed = "+matches +", position = "+position+ " where userName = \""+player+"\" ;";
            System.out.println(query);
            int rs = stmt.executeUpdate(query);
            System.out.println(rs);

            if(rs>1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            return false;
        }

    }

    public ResultSet getDetails(String email){
        //Gson json = new Gson();

        try {
            String query = "select * from users where email = \""+email+"\"";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            String ret = "";
            if(rs.next()){
                ret += "{ \"firstName\" : \""+rs.getString("firstName");
                ret += "\", \"lastName\" : \""+rs.getString("lastName");
                ret += "\", \"email\" : \""+rs.getString("email");
                ret += "\", \"gender\" :  \""+rs.getString("gender");
                ret += "\", \"team\" : \""+rs.getString("team");
                ret += "\", \"image\" : \""+rs.getString("image");
                ret += "\", \"phone\" : \""+rs.getString("phone");
                ret += "\", \"type\" : \""+rs.getString("type");
                ret += "\", \"shirtSize\" : \""+rs.getString("shirtSize");
                ret += "\", \"empId\" : \" "+rs.getString("empId");
                ret += "\", \"age\" : \" "+rs.getString("age");
                ret += "\", \"matchesPlayed\" : \" "+rs.getString("matchesPlayed");
                ret += "\", \"position\" : \" "+rs.getString("position");
                ret += "\", \"bidStatus\" : \" "+rs.getString("bidStatus");
                ret += "\", \"password\" : \" "+rs.getString("password")+"\" }" ;



            }
            return rs;

        }catch(SQLException s){
            String ret ="";
            ret += "{\"firstName\" : \" null\"";
            ret += "\", \"lastName\" : \" null\"";
            ret += "\", \"email\" : \"null\"";
            ret += "\", \"gender\" :  \"null\"";
            ret += "\", \"team\" : \"null\"";
            ret += "\", \"image\" : \"null\"";
            ret += "\", \"phone\" : \"null\"";
            ret += "\", \"type\" : \"null\"";
            ret += "\", \"shirtSize\" : \"null\"";
            ret += "\", \"empId\" : \" null\"";
            ret += "\", \"age\" : \" null\"";
            ret += "\", \"matchesPlayed\" : \" null\"";
            ret += "\", \"position\" : \" null\"";
            ret += "\", \"bidStatus\" : \" null\"";
            ret += "\", \"password\" : \" null\"" ;
            System.out.println(ret);
            //return null;
            return null;
        }
    }


}
