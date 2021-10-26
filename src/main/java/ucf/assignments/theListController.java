package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class theListController {
    public static ObservableList<ToDoListItem> mainList;

    @FXML public TextField textFolderPath;
    @FXML public TextField textFileName;

    @FXML public TableView<ToDoListItem> tableView;
    @FXML public TableColumn<ToDoListItem,String> descCol;
    @FXML public TableColumn<ToDoListItem,String> staCol;
    @FXML public TableColumn<ToDoListItem,String> dateCol;

    public void startTable() {
        descCol.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
        staCol.setCellValueFactory(new PropertyValueFactory<>("itemStatus"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("itemDate"));

        mainList = ToDoListTableManagement.starter();
        tableView.setItems(mainList);

        tableView.setEditable(true);
        descCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    //definitions for the observablelist of items

    //definitions for the textfields, filepath and filename

    //definitions for the table using hashmaps

    //definitions for the tab, creating new tabs

    //initialize the table using setCellValueFactory
    //update the fields to edit in the table itself

    @FXML
    public void buttonAddItem(ActionEvent actionEvent) {
        //adds a list item to the table
    }

    public void buttonRemoveItem(ActionEvent actionEvent) {
        //going to have to add an error to make sure they have actually clicked something
        mainList = ToDoListItemManagement.removeItem(tableView.getSelectionModel().getSelectedItems(),mainList);
        tableView.setItems(mainList);

        //check to see if row was selected
        //removes a listitem from the table
        //refresh the table
    }

    public void buttonChangeStatus(ActionEvent actionEvent) {
        //check to see if row was selected
        //change status to "complete" or "incomplete"
        //refresh the table
    }

    public void buttonShowIncomplete(ActionEvent actionEvent) {
        tableView.setItems(ToDoListTableManagement.showIncomplete(mainList));
        //create a new ObservableList
        //if the status is incomplete add to the new list
        //refresh the table with that new list
    }

    public void buttonShowComplete(ActionEvent actionEvent) {
        tableView.setItems(ToDoListTableManagement.showComplete(mainList));
        //create a new ObservableList
        //if the status is complete add to the new list
        //refresh the table with that new list
    }
    public void buttonShowAll(ActionEvent actionEvent) {
        tableView.setItems(mainList);
        //The status does not matter
        //refresh the table with the full list
    }

    public void buttonSaveList(ActionEvent actionEvent) {
        //export current tab table as text file
    }

    public void buttonLoadList(ActionEvent actionEvent) {
        //get external text file
        //import that textfile into the table of the current tab
    }

    public void buttonClearLIst(ActionEvent actionEvent) {
    }

    public void buttonBrowse(ActionEvent actionEvent) {
    }

    public void changeDueDateColumn(TableColumn.CellEditEvent<ToDoListItem, String> toDoListItemStringCellEditEvent) {

    }

    public void changeDescriptionColumn(TableColumn.CellEditEvent<ToDoListItem, String> theItemCell) {
        ToDoListItem item = tableView.getSelectionModel().getSelectedItem();
        if(theItemCell.getNewValue().toString().length() <=256 &&
                theItemCell.getNewValue().toString().length() >=1)
        {
            item.setItemDesc(theItemCell.getNewValue().toString());
        }
        //Did not add an error yet, but going to have to if they don't follow the rules
    }
}