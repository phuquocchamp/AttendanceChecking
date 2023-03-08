package com.example.attendancecheck.Models;


import java.sql.*;
public class DatabaseDriver {
    private Connection conn;
    public DatabaseDriver(){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:attendance.db");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet getAllAttendanceRS(){
        ResultSet resultSet = null;
        try{
            String sql = "SELECT * FROM AttendanceSV_View";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

}
