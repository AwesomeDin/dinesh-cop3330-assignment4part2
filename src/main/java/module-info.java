module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;

}