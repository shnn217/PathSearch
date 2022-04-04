package com.example.pathsearch;

import com.example.pathsearch.datamodel.FinalInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;




    @FXML
    protected void onButtonClick(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc3","root","password");

            PreparedStatement statement = connection.prepareStatement("SELECT path from node WHERE name LIKE ?");
            statement.setString(1,"%" + textField.getText() + "%");
            ResultSet rs = statement.executeQuery();
            textArea.setPrefRowCount(100);
            textArea.setPrefColumnCount(100);
            textArea.setWrapText(true);
            while(rs.next()){
//                System.out.println(rs.getString(1));
                textArea.appendText(rs.getString(1) + "\n");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}