package ucf.assignments;

import com.sun.jdi.Value;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class InventoryController implements Initializable {

    ObservableList<Item> InventoryList = FXCollections.observableArrayList();

    @FXML TextField SearchField;
    @FXML TextField NameField;
    @FXML TextField SerialNumField;
    @FXML TextField ValueField;
    @FXML TableView<Item> TableDisplay;
    @FXML TableColumn<Item, String> TableName;
    @FXML TableColumn<Item, String> TableSerialNumber;
    @FXML TableColumn<Item, String> TableValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableName.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        TableSerialNumber.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNum"));
        TableValue.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));
    }

    @FXML
    public void helpButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void searchItemButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent){
        //collects data from text fields
        //checks if data is valid
        //if data is valid we pass it onto our addItem function
        //if data is not valid we prompt the user and alert
        //then we close the addItem window

        String name = NameField.getText();
        String SN = SerialNumField.getText();
        String valueStr = ValueField.getText();

        if(checkValidName(name)){
            return;
        }
        if(checkValidSN(SN)){
            return;
        }
        if(checkValidValue(valueStr)){
            return;
        }

        double value = Double.parseDouble(valueStr);

        InventoryList.add(addItem(name,SN,value));
        displayItems();
        NameField.clear();
        SerialNumField.clear();
        ValueField.clear();
    }

    @FXML
    public void editNameButtonClicked(ActionEvent actionEvent){

        //Collect the data from the name text field
        //Collect the data from the table display on the selected item
        //Check if the name is valid
        //if so edit the name and clear the name text field

        String str = NameField.getText();
        Item temp = TableDisplay.getSelectionModel().getSelectedItem();
        if(checkValidName(str)){
            return;
        }
        editName(str, temp);
        NameField.clear();
        displayItems();
    }

    @FXML
    public void editSerialNumberButtonClicked(ActionEvent actionEvent){

        //Collect the data from the SN text field
        //Collect the data from the table display on selected item
        //Check is SN is valid
        //if so edit the SN and clear the SN text field

        String str = SerialNumField.getText();
        Item temp = TableDisplay.getSelectionModel().getSelectedItem();
        if(checkValidSN(str)){
            return;
        }
        editSerialNum(str, temp);
        SerialNumField.clear();
        displayItems();
    }

    @FXML
    public void editValueButtonClicked(ActionEvent actionEvent){

        //Collect the data from the Value text field
        //collect the data from the table display on selected item
        //Check if the value is valid
        //if so edit the value and clear the value text field

        String str = ValueField.getText();
        Item temp = TableDisplay.getSelectionModel().getSelectedItem();
        if(checkValidValue(str)){
            return;
        }
        double value = Double.parseDouble(str);
        editValue(value, temp);
        ValueField.clear();
        displayItems();
    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent){
        //grab the selected item
        //call remove item given the selected item

        Item temp = TableDisplay.getSelectionModel().getSelectedItem();
        removeItem(temp);
        displayItems();
    }

    @FXML
    public void sortByValueButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void sortBySerialNumberButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void sortByNameButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void saveAsHtmlButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void saveAsTxtButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void saveAsJsonButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void LoadButtonClicked(ActionEvent actionEvent){

    }

    public Item addItem(String name, String serialNum, Double value){

        //takes inputs from text field and turns them into an item

        return new Item(name, serialNum, value);
    }

    public void editName(String tempName, Item tempItem){

        //find list index
        //edit name of item on list
        //update display

        int tempIndex = InventoryList.indexOf(tempItem);
        InventoryList.set(tempIndex, new Item (tempName, tempItem.getSerialNum(), tempItem.getValue()));
        //displayItems();
    }

    public void editSerialNum(String tempSN, Item tempItem){

        //find list index
        //edit serial number of item on list
        //update display

        int tempIndex = InventoryList.indexOf(tempItem);
        InventoryList.set(tempIndex, new Item (tempItem.getName(), tempSN, tempItem.getValue()));
        //displayItems();
    }

    public void editValue(double tempValue, Item tempItem){

        //find list index
        //edit Value of item on list
        //update display

        int tempIndex = InventoryList.indexOf(tempItem);
        InventoryList.set(tempIndex, new Item (tempItem.getName(), tempItem.getSerialNum(), tempValue));
        //displayItems();
    }

    public void removeItem(Item tempItem){

        //remove item from list
        //update display

        InventoryList.remove(tempItem);
        //displayItems();
    }

    public void displayItems(){

        //clears the table display
        //loads list to table display

        if(this.TableDisplay != null){
            TableDisplay.getItems().clear();
            for(int i = 0; i < InventoryList.size(); i++){
                TableDisplay.getItems().add(InventoryList.get(i));
            }
        }

    }

    public boolean checkValidName(String name){
        if(name.length() < 2 || name.length() > 256){
            NameField.clear();
            alerts("Warning","Make sure product name is between 2-256 characters long.");
            return true;
        }

        return false;
    }

    public boolean checkValidSN(String SN){
        if(SN.length() != 10 || (!SN.matches("^[a-zA-Z0-9]*$"))){
            SerialNumField.clear();
            alerts("Warning","Make sure that entered serial number is 10 characters long\n" +
                    "and only contains alphanumerical values");
            return true;
        }

        return false;
    }

    public boolean checkValidValue(String str){
        char[] valueStrArr= str.toCharArray();
        int valueStrDec = str.length()-3;

        for(int i = 0; i < valueStrDec; i++){
            if(!Character.isDigit(valueStrArr[i])){
                ValueField.clear();
                alerts("Warning","Make sure the value is in format XXX.XX where X's\n" +
                        "are numbers.111");
                return true;
            }
        }
        if(valueStrArr[valueStrDec] != '.'){
            ValueField.clear();
            alerts("Warning","Make sure the value is in format XXX.XX where X's\n" +
                    "are numbers.222");
            return true;
        }
        for(int i = valueStrDec+1; i < str.length(); i++){
            if(!Character.isDigit(valueStrArr[i])){
                ValueField.clear();
                alerts("Warning","Make sure the value is in format XXX.XX where X's\n" +
                        "are numbers.333");
                return true;
            }
        }

        return false;
    }

    public void alerts(String title, String msg){
        //used for alerts when user does something wrong or needs help etc.
        Stage temp = new Stage();

        temp.initModality(Modality.APPLICATION_MODAL);
        temp.setTitle(title);
        temp.setMinWidth(250);

        Label label = new Label();
        label.setText(msg);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(event -> temp.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        temp.setScene(scene);
        temp.showAndWait();
    }
}
