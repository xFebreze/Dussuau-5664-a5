/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alek Dussuau
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

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

    public ObservableList<Item>  loadTxt(File file){
        ObservableList<Item> ret = FXCollections.observableArrayList();

        Scanner reader = null;

        try{
            reader = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        while(reader.hasNextLine()){
            String fileLine = reader.nextLine();
            String[] temp = fileLine.split("\t",3);
            ret.add(new Item(temp[0],temp[1],Double.parseDouble(temp[2])));
        }
        reader.close();
        return ret;
    }

    public void saveAsHtml(File file, ObservableList<Item> InventoryList){

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

    public ObservableList<Item> loadHtml(File file){
        ObservableList<Item> ret = FXCollections.observableArrayList();


        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        Document htmlDoc = Jsoup.parse(content);
        Element table = htmlDoc.selectFirst("table");

        Iterator<Element> row = table.select("tr").iterator();

        row.next();

        while(row.hasNext()){
            Iterator<Element> item = ((Element)row.next()).select("td").iterator();
            ret.add(new Item(item.next().text(),item.next().text(),Double.parseDouble(item.next().text())));
        }
        return ret;
    }

    public void saveAsJson(File file, ObservableList<Item> InventoryList){

    }

    public void loadJson(File file, ObservableList<Item> InventoryList){

    }
}
