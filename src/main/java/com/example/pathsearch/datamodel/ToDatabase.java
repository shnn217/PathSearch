package com.example.pathsearch.datamodel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class ToDatabase {

//    private static ToDatabase instance = new ToDatabase();
//
//    public static ToDatabase getInstance(){
//        return instance;
//    }

    public HashMap<String, Integer> generateID(ArrayList<MyInput> o){
        HashMap<String, Integer> id = new HashMap<>();
        Integer j = 1;
        int k = 1;
        for(MyInput i: o){
            if (id.containsKey(i.getName())){
                i.setName(i.getName() +"("+ k + ")");
                id.put(i.getName(), j);
                k++;
            }else{
                id.put(i.getName(), j);
            }

//            System.out.println(i.getName() + "    "+j);
            j++;
        }

        return id;
    }


    public ArrayList<MyInput> readFile() throws IOException {
        Path path = Paths.get("file-structure.txt");
        BufferedReader br = Files.newBufferedReader(path);
        ArrayList<MyInput> myInputArrayList = new ArrayList<>();

        String input;
        try {

            while ((input = br.readLine()) != null) {

                String[] inputItem = input.split("\t");
                String pathString = inputItem[inputItem.length - 1];
                String[] pathComp = inputItem[inputItem.length - 1].split("/");
                String name = pathComp[pathComp.length - 1];
                String preD;
                if (pathComp.length >= 2){
                    preD = pathComp[pathComp.length - 2];
                }else{
                    preD = null;
                }
                String type = inputItem[0];
                myInputArrayList.add(new MyInput(name, preD, type, pathString));
            }

        } finally {
            if (br != null) {
                br.close();
            }
        }
        return myInputArrayList;
    }

    public ArrayList<FinalInput> generateFinalInput(ArrayList<MyInput> o, HashMap<String, Integer> map){
        ArrayList<FinalInput> finalInputArrayList = new ArrayList<>();
        for (MyInput i: o){
            if (map.containsKey(i.getPreD())){
                FinalInput finalInput = new FinalInput(map.get(i.getName()),i.getName(),map.get(i.getPreD()), i.getPath(), i.getType());
//                System.out.println(map.get(i.getName())+"  "+i.getName());
                finalInputArrayList.add(finalInput);
            }else{
                FinalInput finalInput = new FinalInput(map.get(i.getName()),i.getName(),null, i.getPath(), i.getType());
//                System.out.println(map.get(i.getName())+"  "+i.getName());
                finalInputArrayList.add(finalInput);
            }
        }

        return finalInputArrayList;
    }

    public void insertArrayListofFinalInput(ArrayList<FinalInput> o){
        String query = "insert into node (id, name, parent_id, type, path) values (?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/file","root","password");

            PreparedStatement statement = connection.prepareStatement(query);
            int j = 0;
            for(FinalInput i : o){
//                String idString = i.getId().toString().replaceAll("-","");
//                String parentString;
//                if (i.getParent_id() != null){
//                    parentString = i.getParent_id().toString().replaceAll("-","");
//                }else{
//                    parentString = "null";
//                }

                statement.setObject(1, i.getId());
                statement.setString(2, i.getName());
                if (i.getParent_id() != null){
                    statement.setObject(3, i.getParent_id());
                }else{
                    statement.setObject(3, null);
                }
                statement.setString(4, i.getType());
                statement.setString(5, i.getPath());
                statement.addBatch();
                j++;

                if (j % 1000 == 0 || j == o.size()){
                    statement.executeBatch();
                }
            }
            statement.executeBatch();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
