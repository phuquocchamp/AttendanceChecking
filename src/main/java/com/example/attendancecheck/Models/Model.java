package com.example.attendancecheck.Models;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final DatabaseDriver databaseDriver;

    private Model(){
        this.databaseDriver = new DatabaseDriver();

    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
    public DatabaseDriver getDatabaseDriver(){
        return databaseDriver;
    }

//    public ObservableList<Attendance> getAllAttendance(){
//        ResultSet rs = databaseDriver.getAllAttendanceRS();
//        try{
//            while(rs.next()){
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
