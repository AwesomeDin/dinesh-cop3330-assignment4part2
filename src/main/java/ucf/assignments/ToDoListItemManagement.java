package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Date;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class ToDoListItemManagement {
    public static Date time() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;
    }

    public static ObservableList<ToDoListItem> initialItem(ObservableList<ToDoListItem> theList)
    {
        theList.add(new ToDoListItem("256 Characters", "Incomplete", time().toString()));
        return theList;
    }

    public static void addItem(String desc, String dueDate, String status) {
        theListController.mainList.add(new ToDoListItem(desc,dueDate,status));
        //Will take in the incoming values and create an item
        //Will add the item to the ObservableList of items

    }

    public static ObservableList<ToDoListItem> removeItem(ObservableList<ToDoListItem> toDelete, ObservableList<ToDoListItem> theList) {
        for(ToDoListItem item: toDelete)
        {
            theList.remove(item);
        }
        //loop to delete the item that was selected from the list passed in
        return theList;
    }

    public static ObservableList<ToDoListItem> clearList(ObservableList<ToDoListItem> toClear)
    {
        return FXCollections.observableArrayList();
    }

    public static TableView<ToDoListItem> statusChange(TableView<ToDoListItem> tableView)
    {
        if(tableView.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Incomplete"))
        {
            tableView.getSelectionModel().getSelectedItem().setStatus("Complete");
        }
        else
        {
            tableView.getSelectionModel().getSelectedItem().setStatus("Incomplete");
        }
        return tableView;
    }
}
