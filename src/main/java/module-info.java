module com.example.pathsearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;



    opens com.example.pathsearch to javafx.fxml;
    exports com.example.pathsearch;
}