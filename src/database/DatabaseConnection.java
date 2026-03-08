package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/cine?serverTimezone=Europe/Madrid&useSSL=false";
            String user="admin";
            String pass="admin123";
            return DriverManager.getConnection(url,user,pass);
        }catch(Exception e){  return null;}
    }
}