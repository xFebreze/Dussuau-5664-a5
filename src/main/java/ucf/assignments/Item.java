/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alek Dussuau
 */
package ucf.assignments;

public class Item {
    private String Name;
    private String SerialNum;
    private Double Value;

    //constructors
    public Item(String name, String serialNum, Double value) {
        Name = name;
        SerialNum = serialNum;
        Value = value;
    }

    //getters and setters
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getSerialNum() { return SerialNum; }
    public void setSerialNum(String serialNum) { SerialNum = serialNum; }

    public Double getValue() { return Value; }
    public void setValue(Double value) { Value = value; }
}
