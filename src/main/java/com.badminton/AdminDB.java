package com.badminton;

import com.badminton.Servlets.Adminlog;

import java.sql.*;


public class AdminDB {
    private static Statement stmt;

    Database db = new Database();
    public AdminDB(){
        stmt = db.dbConnection();
    }

    public void createOrUpdateDB(Admin admin){
        try {
            // stmt.executeUpdate("truncate table TaskList");
            String query = "create table admintable(" +
                    "Id INT PRIMARY KEY AUTO_INCREMENT, FirstName VARCHAR(255),LastName VARCHAR(255), UserName VARCHAR(255) UNIQUE, Email VARCHAR(255) UNIQUE, Password VARCHAR(255) UNIQUE )";
            stmt.executeUpdate(query);
            query = "insert into admintable values(" + admin.getId() + ",'" + admin.getFirstName() + "','" + admin.getLastName() + "', '" + admin.getUserName() + "','" + admin.getEmail() + "','" + admin.getPassword() + "' )";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            try {
                String query = "insert into admintable values(" + admin.getId() + ",'" + admin.getFirstName() + "','" + admin.getLastName() + "', '" + admin.getUserName() + "','" + admin.getEmail() + "','" + admin.getPassword() + "' )";
                System.out.println(query);
                stmt.executeUpdate(query);
            } catch (SQLException q) {
                String response = "Sql query not correct or no such data.";
                System.out.println(response);
            }
        }
    }

    public boolean verification(Adminlog al){
        try{
            String query = "select Password from admintable where Email = '"+ al.getEmail()+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) {
                String pass = rs.getString("Password");
                System.out.println(pass);
                return pass.equals(al.getPassword());
            }else{
                return false;
            }
        }catch (SQLException e){
            String response = "Sql query not correct or no such data.";
            System.out.println(response);
            return false;
        }
    }

}
