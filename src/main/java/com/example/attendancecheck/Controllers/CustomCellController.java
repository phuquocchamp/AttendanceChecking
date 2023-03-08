package com.example.attendancecheck.Controllers;

import com.example.attendancecheck.Models.Attendance;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomCellController implements Initializable {
    public Label ID_lbl;
    public Label MSv_lbl;
    public Label fullName_lbl;
    public Label AttendanceCount_lbl;
    public Button Status_btn;

    private final Attendance attendance;

    public CustomCellController(Attendance attendance){
        this.attendance = attendance;
    }
    int count = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID_lbl.textProperty().bind(attendance.IDProperty());
        MSv_lbl.textProperty().bind(attendance.MSVProperty());
        fullName_lbl.textProperty().bind(attendance.fullNameProperty());
        AttendanceCount_lbl.textProperty().bind(attendance.AbsentsCountProperty().asString());
        Status_btn.setText("Present");
        Status_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    count++;
                    if(count % 3 == 0){
                        attendance.AbsentsCountProperty().set(0);

                        Status_btn.setText("Present");
                    }else if(count % 3 == 1 ){ // When Absent with notifier
                        attendance.AbsentsCountProperty().set(0.5);
                        Status_btn.setText("Notifier");
                    }else{
                        Status_btn.setText("Absent");
                        attendance.AbsentsCountProperty().set(1);
                    }
//                    attendance.AbsentsCountProperty().addListener((observable, oldValue, newValue) -> {
//
//                    });
                    System.out.println(count);
                }
            }
        });
    }
}
