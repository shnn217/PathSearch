package com.example.pathsearch;

import com.example.pathsearch.datamodel.FileData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Path Search");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        try{ //load the data in

            File currentDir = new File("/Users/eric/test_dir");

            FileData.getInstance().getFile(currentDir);
            FileData.getInstance().storeFileData();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}