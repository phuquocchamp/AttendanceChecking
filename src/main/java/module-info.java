module com.example.attendancecheck {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.example.attendancecheck to javafx.fxml;
    exports com.example.attendancecheck;
    exports com.example.attendancecheck.Models;
    opens com.example.attendancecheck.Models to javafx.fxml;
    exports com.example.attendancecheck.Controllers;
    opens com.example.attendancecheck.Controllers to javafx.fxml;
    exports com.example.attendancecheck.Views;
    opens com.example.attendancecheck.Views to javafx.fxml;

}