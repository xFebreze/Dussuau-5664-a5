/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alek Dussuau
 */
package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public void saveAsTxt(File file, ObservableList<Item> InventoryList){
        FileWriter fileWrite = null;
        String fileData = "";

        for(int i = 0; i < InventoryList.size(); i++){
            fileData += InventoryList.get(i).getName() + "\t" +
                    InventoryList.get(i).getSerialNum() + "\t" +
                    InventoryList.get(i).getValue() + "\n";
        }

        try
        {
            fileWrite = new FileWriter(file);
            fileWrite.write(fileData);
            fileWrite.close();
        }
        catch (Exception ex)
        {

        }
    }

    public void saveAsHtml(File file, ObservableList<Item> InventoryList){
        System.out.println("TEST");

        BufferedWriter bufferedWrite = null;
        String html = "<html>\n<body>\n<table>\n" +
                "<tr><th>Product_Name</th><th>Serial_Number</th><th>Product_Value</th></tr>\n";

        for(int i = 0; i < InventoryList.size(); i++){
            html += String.format("<tr><td>%s</td><td>%s</td><td>%.2f</td></tr>\n",InventoryList.get(i).getName(),InventoryList.get(i).getSerialNum(),InventoryList.get(i).getValue());
        }
        html += "</table>\n</body>\n</html>";


        try{
            bufferedWrite = new BufferedWriter(new FileWriter(file));
            bufferedWrite.write(html);
            bufferedWrite.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveAsJson(File file, ObservableList<Item> InventoryList){

    }
}
