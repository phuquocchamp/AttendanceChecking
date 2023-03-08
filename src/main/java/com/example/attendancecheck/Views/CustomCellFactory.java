package com.example.attendancecheck.Views;

import com.example.attendancecheck.Controllers.CustomCellController;
import com.example.attendancecheck.Models.Attendance;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class CustomCellFactory extends ListCell<Attendance> {
    @Override
    public void updateItem(Attendance attendance, boolean empty){
        super.updateItem(attendance, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/attendancecheck/Fxml/CustomCell.fxml"));
            CustomCellController controller = new CustomCellController(attendance);
            fxmlLoader.setController(controller);
            setText(null);
            try{
                setGraphic(fxmlLoader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
