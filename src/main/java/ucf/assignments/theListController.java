package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class theListController {
    public static ObservableList<ToDoListItem> mainList;


    @FXML public TableView<ToDoListItem> tableView;
    @FXML public TableColumn<ToDoListItem, String> itemDescCol;
    @FXML public TableColumn<ToDoListItem, String> itemDateCol;
    @FXML public TableColumn<ToDoListItem, String> itemStatusCol;

    @FXML public TextField textFolderPath;
    @FXML public TextField textFileName;


    @FXML private void initialize() {
        startTable();
    }

    public void startTable() {
        itemDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        itemDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        itemStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        mainList = ToDoListTableManagement.starter();
        tableView.setItems(mainList);

        //allow fields to be edited
        tableView.setEditable(true);
        itemDescCol.setCellFactory(TextFieldTableCell.forTableColumn());
        itemDateCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
    //definitions for the observablelist of items

    //definitions for the textfields, filepath and filename

    //definitions for the table using hashmaps

    //definitions for the tab, creating new tabs

    //initialize the table using setCellValueFactory
    //update the fields to edit in the table itself


    public void buttonAddItem() {
       ToDoListItemManagement.initialItem(mainList);
        //adds a list item to the table
    }

    public void buttonRemoveItem() {
        //going to have to add an error to make sure they have actually clicked something
        mainList = ToDoListItemManagement.removeItem(tableView.getSelectionModel().getSelectedItems(),mainList);
        tableView.setItems(mainList);

        //check to see if row was selected
        //removes a listitem from the table
        //refresh the table
    }

    public void buttonChangeStatus() {
        //check to see if row was selected
        //change status to "complete" or "incomplete"
        //refresh the table
    }

    public void buttonShowIncomplete() {
         /*
        tableView.setItems(ToDoListTableManagement.showIncomplete(mainList));
        //create a new ObservableList
        //if the status is incomplete add to the new list
        //refresh the table with that new list

         */
    }

    public void buttonShowComplete() {
        /*
        tableView.setItems(ToDoListTableManagement.showComplete(mainList));
        //create a new ObservableList
        //if the status is complete add to the new list
        //refresh the table with that new list

         */
    }
    public void buttonShowAll() {
        /*
        tableView.setItems(mainList);
        //The status does not matter
        //refresh the table with the full list

         */
    }

    public void buttonSaveList() {
        //export current tab table as text file
    }

    public void buttonLoadList() {
        //get external text file
        //import that textfile into the table of the current tab
    }

    public void buttonClearLIst() {
    }

    public void buttonBrowse() {
    }

    public void changeDueDateColumn(TableColumn.CellEditEvent<ToDoListItem, String> toDoListItemStringCellEditEvent) {

    }

    public void changeDescriptionColumn(TableColumn.CellEditEvent<ToDoListItem, String> theItemCell) {
        /*
        ToDoListItem item = tableView.getSelectionModel().getSelectedItem();
        if(theItemCell.getNewValue().toString().length() <=256 &&
                theItemCell.getNewValue().toString().length() >=1)
        {
            item.setItemDesc(theItemCell.getNewValue().toString());
        }
        //Did not add an error yet, but going to have to if they don't follow the rules

         */
    }

}