package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

        String str1 = NameField.getText();
        String str2 = SerialNumField.getText();
        Double x = Double.parseDouble(ValueField.getText());

        InventoryList.add(addItem(str1,str2,x));
        displayItems();

    }

    @FXML
    public void editNameButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void editSerialNumberButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void editValueButtonClicked(ActionEvent actionEvent){

    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent){

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

    public void displayItems(){
        //clears the table display
        //loads list to table display
        if(this.TableDisplay != null){
            TableDisplay.getItems().clear();
            TableDisplay.setItems(InventoryList);
        }

    }
}
