module com.example.pathsearch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pathsearch to javafx.fxml;
    exports com.example.pathsearch;
}