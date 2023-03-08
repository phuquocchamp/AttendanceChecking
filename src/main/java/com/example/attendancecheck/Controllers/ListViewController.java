package com.example.attendancecheck.Controllers;

import com.example.attendancecheck.Models.Model;
import com.example.attendancecheck.Views.CustomCellFactory;
import com.example.attendancecheck.Models.Attendance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    public ListView<Attendance> AttendanceCheck_listView;
    ObservableList<Attendance> attendancesData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Attendance> Items = FXCollections.observableArrayList(
                new Attendance("1", "22IT239", "Hoang Tan Phu Quoc", 1, 0),
                new Attendance("2","22IT256", "Truong Ngoc Khanh Linh", 0, 0)
        );
        getAttendanceData();
        AttendanceCheck_listView.setItems(attendancesData);
        AttendanceCheck_listView.setCellFactory(e -> new CustomCellFactory());
    }

    public void getAttendanceData(){
//        ObservableList<Attendance> attendancesData = FXCollections.observableArrayList();
        ResultSet resultSet = Model.getInstance().getDatabaseDriver().getAllAttendanceRS();
        try{
            while (resultSet.next()){
                String ID = resultSet.getString("ID");
                String MSV = resultSet.getString("MSV");
                String fullName = resultSet.getString("fullName");
                int Status = resultSet.getInt("Status");
                double absentCount = resultSet.getDouble("AttendanceCount");
                attendancesData.add(new Attendance(ID, MSV,fullName,Status, absentCount));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
