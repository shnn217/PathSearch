package com.example.pathsearch;

import com.example.pathsearch.datamodel.FileData;
import com.example.pathsearch.datamodel.FinalInput;
import com.example.pathsearch.datamodel.MyInput;
import com.example.pathsearch.datamodel.ToDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller{
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;




    @FXML
    protected void onButtonClick(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/file","root","password");

            PreparedStatement statement = connection.prepareStatement("SELECT path from node WHERE name LIKE ?");
            statement.setString(1,"%" + textField.getText() + "%");
            ResultSet rs = statement.executeQuery();
            textArea.setPrefRowCount(100);
            textArea.setPrefColumnCount(100);
            textArea.setWrapText(true);
            textArea.setText("");
            while(rs.next()){
//                System.out.println(rs.getString(1));

                textArea.appendText(rs.getString(1) + "\n");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void initialize() throws IOException{

        ToDatabase toDatabase = new ToDatabase();

        ArrayList<MyInput> myInputArrayList = toDatabase.readFile();
        HashMap<String, Integer> idMap = toDatabase.generateID(myInputArrayList);
        ArrayList<FinalInput> finalInputs = toDatabase.generateFinalInput(myInputArrayList, idMap);
        toDatabase.insertArrayListofFinalInput(finalInputs);

    }
}