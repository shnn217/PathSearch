package com.example.pathsearch.datamodel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class FileData {

    private static FileData instance = new FileData();
    private ArrayList<MyFolder> folderList = new ArrayList<>();
    private ArrayList<MyFile> myFileList = new ArrayList<>();
    private static String filename = "file-structure.txt";
    private static int folderId = 1;
    private static int fileId = 1;

    public static FileData getInstance(){
        return instance;
    }

    public static void getFile(File dir) throws IOException {

        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                MyFolder folderItem = new MyFolder(folderId, file.getName(), null, file.getCanonicalPath());
                instance.folderList.add(folderItem);
//                System.out.printf(" dir: %s\t%s\t%s\t%s\n",folderId, file.getName(), null, file.getAbsolutePath());
                folderId++;
                getFile(file);
            } else {
                MyFile fileItem = new MyFile(fileId, file.getName(), null, file.getAbsolutePath());
                instance.myFileList.add(fileItem);
//                System.out.printf("file: %s\t%s\t%s\t%s\n",fileId, file.getName(), null, file.getAbsolutePath());
                fileId++;
            }
        }
    }

    public void storeFileData() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        //store Folder
        try{
            Iterator<MyFolder> folderIterator = folderList.iterator();
            Iterator<MyFile> fileIterator = myFileList.iterator();
            while(folderIterator.hasNext() || fileIterator.hasNext()){
                if (folderIterator.hasNext()){
                    MyFolder folderItem = folderIterator.next();
                    bw.write(String.format("%s\t%s\t%s\t%s",
                            folderItem.getFolderId(),
                            folderItem.getFolderName(),
                            folderItem.getParentId(),
                            folderItem.getPath()));

                    bw.newLine();
                }else {
                    MyFile fileItem = fileIterator.next();
                    bw.write(String.format("%s\t%s\t%s\t%s",
                            fileItem.getFileId(),
                            fileItem.getFileName(),
                            fileItem.getFolderId(),
                            fileItem.getPath()));

                    bw.newLine();
                }

            }
        }finally {
            if (bw != null)
                bw.close();
        }

    }
//    public static Integer
    public static void main(String[] args) throws IOException {
        File currentDir = new File("/Users/eric/test_dir"); // current directory
        getFile(currentDir);
        instance.storeFileData();
    }

}
