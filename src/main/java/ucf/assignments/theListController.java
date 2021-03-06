package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

//Resources used
//https://docs.oracle.com/javafx/2/ui_controls/table-view.htm <- bless oracle for this documentation
//https://www.dariawan.com/tutorials/java/java-datetimeformatter-tutorial-examples/

public class theListController {
    public static ObservableList<ToDoListItem> mainList;


    @FXML public TableView<ToDoListItem> tableView;
    @FXML public TableColumn<ToDoListItem, String> itemDescCol;
    @FXML public TableColumn<ToDoListItem, String> itemDateCol;
    @FXML public TableColumn<ToDoListItem, String> itemStatusCol;

    @FXML public AnchorPane anchorPane;

    @FXML public TextField textFolderPath;
    @FXML public TextField textFileName;


    @FXML private void initialize() {
        startTable();
    }

    public void startTable() {
        itemDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        itemDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        itemStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        mainList = FXCollections.observableArrayList();
        tableView.setItems(mainList);

        tableView.setEditable(true);
        itemDescCol.setCellFactory(TextFieldTableCell.forTableColumn());
        itemDateCol.setCellFactory(TextFieldTableCell.forTableColumn());

        //definitions for the observablelist of items

        //definitions for the textfields, filepath and filename

        //initialize the table using setCellValueFactory
        //update the fields to edit in the table itself
    }



    public void buttonAddItem() {
       ToDoListItemManagement.initialItem(mainList);
        //adds a list item to the table
    }

    public void buttonRemoveItem() {
        mainList = ToDoListItemManagement.removeItem(tableView.getSelectionModel().getSelectedItems(),mainList);
        tableView.setItems(mainList);

        //check to see if row was selected
        //removes a listitem from the table
        //refresh the table
    }

    public void buttonChangeStatus() {
        String s = ToDoListItemManagement.statusChange(tableView.getSelectionModel().getSelectedItem().getStatus());
        tableView.getSelectionModel().getSelectedItem().setStatus(s);
        tableView.refresh();
        //check to see if row was selected
        //change status to "complete" or "incomplete"
        //refresh the table
    }

    public void buttonShowIncomplete() {
        tableView.setItems(ToDoListTableManagement.showIncomplete(mainList));
        //create a new ObservableList
        //if the status is incomplete add to the new list
        //refresh the table with that new list
    }

    public void buttonShowComplete() {
        tableView.setItems(ToDoListTableManagement.showComplete(mainList));
        //create a new ObservableList
        //if the status is complete add to the new list
        //refresh the table with that new list
    }
    public void buttonShowAll() {
        tableView.setItems(ToDoListTableManagement.showAll(mainList));
        //The status does not matter
        //refresh the table with the full list
    }

    public void buttonSaveList() {
        if(textFolderPath.getCharacters().toString().length() ==0)
        {
            textFolderPath.setText("Please choose a correct file path using the Browse button.");
        }
        else
        {
            if (ToDoListFiles.saveFile(textFolderPath.getCharacters().toString(),textFileName.getCharacters().toString(), mainList))
            {
                textFolderPath.setText("");
                textFileName.setText("");
            }
            else
            {
                textFolderPath.setText("Please reread the instructions and try again");
                textFileName.setText("Please reread the instructions and try again");
            }
        }
        //Checks to see if path is empty
        //Otherwise saves the file as a text file
        // sets the field to empty
        //if error then tells the user
    }

    public void buttonLoadList() {
        if (ToDoListFiles.loadFile(textFolderPath.getCharacters().toString(),textFileName.getCharacters().toString()))
        {
            textFolderPath.setText("");
            textFileName.setText("");
        }
        else
        {
            textFolderPath.setText("Please reread the instructions and try again");
            textFileName.setText("Please reread the instructions and try again");
        }
        //get external text file
        //import that textfile into the table of the current tab
    }

    public void buttonClearList() {
        mainList = ToDoListItemManagement.clearList(mainList);
        tableView.setItems(mainList);

        //sets the mainlist equal to a new list
    }

    public void buttonBrowse() {
        final DirectoryChooser dirchooser = new DirectoryChooser();

        Stage stage = (Stage) anchorPane.getScene().getWindow();

        File file = dirchooser.showDialog(stage);

        if(file != null)
        {
            textFolderPath.setText(file.getAbsolutePath());
        }

        //uses DirectoryChooser and Stage to open up a new window
        //Allows the user to choose a folder
        //Checks to see if the folder is valid path
    }

    public void changeDueDateColumn(TableColumn.CellEditEvent<ToDoListItem, String> theItemCell) {

        LocalDate date = ToDoListItemManagement.checkDate(theItemCell.getNewValue());
        tableView.getSelectionModel().getSelectedItem().setDueDate(date.toString());
        tableView.refresh();

        //Uses datetimeformatter to get a pattern
        //Grabs selected item
        //Will not allow the user to enter a date if it doesn't match the pattern
        //refreshes table with new date
    }

    public void changeDescriptionColumn(TableColumn.CellEditEvent<ToDoListItem, String> theItemCell) {
        ToDoListItem item = tableView.getSelectionModel().getSelectedItem();
        if(ToDoListItemManagement.checkLength(theItemCell.getNewValue().length()))
            item.setDescription(theItemCell.getNewValue());
        else
        {
            item.setDescription("Please adhere to 256 character limit, please reenter the description.");
            tableView.refresh();
        }

        //Grabs the selected item
        //Checks to see if the description is within range
        //If correct sets the description, else sets it to an error
    }

}