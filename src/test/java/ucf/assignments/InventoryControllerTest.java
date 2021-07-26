/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alek Dussuau
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryControllerTest {

    @Test
    public void addItemTest(){
        //Make a new object for Inventory Controller
        //Add an item to the Inventory List
        //assert equals with each part of the item to see if Item was stored to list

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("PS4","A2001L9E2K", 499.99);
        assertEquals("PS4",AppTest.InventoryList.get(0).getName());
        assertEquals("A2001L9E2K",AppTest.InventoryList.get(0).getSerialNum());
        assertEquals(499.99,AppTest.InventoryList.get(0).getValue());
    }

    @Test
    public void removeItemTest(){
        //Make a new object for Inventory Controller
        //Add two items to the Inventory List
        //Check to see if size of Inventory List is 2
        //remove Item from Inventory List
        //Check to see if size of Inventory List is 1

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("PS4","A2001L9E2K", 499.99);
        AppTest.addItem("PS4","A2001L9E2C", 499.99);
        assertEquals(2,AppTest.InventoryList.size());
        AppTest.removeItem(AppTest.InventoryList.get(1));
        assertEquals(1,AppTest.InventoryList.size());
    }

    @Test
    public void editNameTest(){
        //Make a new object for Inventory Controller
        //Add an Item to the Inventory List
        //Edit the name of the Item of the Inventory List
        //Check to see if name of Item in list matches new name

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("PS4","A2001L9E2K", 499.99);
        AppTest.editName("X Box", AppTest.InventoryList.get(0));
        assertEquals("X Box", AppTest.InventoryList.get(0).getName());
    }

    @Test
    public void editSerialNumTest(){
        //Make a new object for Inventory Controller
        //Add an Item to the Inventory List
        //Edit the serial number of the Item of the Inventory List
        //Check to see if serial number of Item in list matches new name

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("PS4","A2001L9E2K", 499.99);
        AppTest.editSerialNum("K2E9L1002A", AppTest.InventoryList.get(0));
        assertEquals("K2E9L1002A", AppTest.InventoryList.get(0).getSerialNum());
    }

    @Test
    public void editValueTest(){
        //Make a new object for Inventory Controller
        //Add an Item to the Inventory List
        //Edit the value of the Item of the Inventory List
        //Check to see if value of Item in list matches new name

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("PS4","A2001L9E2K", 499.99);
        AppTest.editValue(500.00, AppTest.InventoryList.get(0));
        assertEquals(500.00, AppTest.InventoryList.get(0).getValue());
    }

    @Test
    public void LoadTxtTest(){
        //Make a new object of Inventory Controller
        //Load a text File premade in a resource folder
        //compare the data that should've loaded to the data that actually loaded

        InventoryController AppTest = new InventoryController();

        AppTest.loadInventory(new File("resources/TestLoad.txt"));
        assertEquals("VAL", AppTest.InventoryList.get(0).getName());
        assertEquals("A2002L9E2K",AppTest.InventoryList.get(0).getSerialNum());
        assertEquals(199.99,AppTest.InventoryList.get(0).getValue());
    }

    @Test
    public void SaveTxtTest(){
        //Make a new Object of Inventory Controller
        //Add a Item to the Inventory List
        //Save the Inventory List as txt
        //Clear current List
        //Load the list we saved
        //Check if data is still there

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("Testing","TEST12TEST",199.99);
        AppTest.saveInventory(new File("resources/TestSave.txt"));
        AppTest.InventoryList.clear();
        AppTest.loadInventory(new File("resources/TestSave.txt"));
        assertEquals("Testing", AppTest.InventoryList.get(0).getName());
        assertEquals("TEST12TEST",AppTest.InventoryList.get(0).getSerialNum());
        assertEquals(199.99,AppTest.InventoryList.get(0).getValue());
    }

    @Test
    public void LoadHtmlTest(){
        //Make a new object of Inventory Controller
        //Load a html File premade in a resource folder
        //compare the data that should've loaded to the data that actually loaded

        InventoryController AppTest = new InventoryController();

        AppTest.loadInventory(new File("resources/TestLoad.html"));
        assertEquals("VAL", AppTest.InventoryList.get(0).getName());
        assertEquals("A2002L9E2K",AppTest.InventoryList.get(0).getSerialNum());
        assertEquals(199.99,AppTest.InventoryList.get(0).getValue());
    }

    @Test
    public void SaveHtmlTest(){
        //Make a new Object of Inventory Controller
        //Add a Item to the Inventory List
        //Save the Inventory List as html
        //Clear current List
        //Load the list we saved
        //Check if data is still there

        InventoryController AppTest = new InventoryController();

        AppTest.addItem("Testing","TEST12TEST",199.99);
        AppTest.saveInventory(new File("resources/TestSave.html"));
        AppTest.InventoryList.clear();
        AppTest.loadInventory(new File("resources/TestSave.html"));
        assertEquals("Testing", AppTest.InventoryList.get(0).getName());
        assertEquals("TEST12TEST",AppTest.InventoryList.get(0).getSerialNum());
        assertEquals(199.99,AppTest.InventoryList.get(0).getValue());
    }
}
