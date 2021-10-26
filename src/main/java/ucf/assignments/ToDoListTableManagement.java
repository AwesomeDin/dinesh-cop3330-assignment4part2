package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class ToDoListTableManagement {
    public static ObservableList<ToDoListItem> starter() {
        return FXCollections.observableArrayList();
    }
    public static ObservableList<ToDoListItem> showComplete(ObservableList<ToDoListItem> theList) {
        ObservableList<ToDoListItem> listComplete = FXCollections.observableArrayList();
        for(ToDoListItem item: theList)
        {
            if(item.getStatus().toUpperCase().equals("COMPLETE"))
                listComplete.add(item);
        }
        return theList;
        //Uses a for loop to find where the status of the item is equal to "complete"
        //adds the items to a brand new list
        //returns the brand new list
    }
    public static ObservableList<ToDoListItem> showIncomplete(ObservableList<ToDoListItem> theList) {
        ObservableList<ToDoListItem> listIncomplete = FXCollections.observableArrayList();
        for(ToDoListItem item: theList)
        {
            if(item.getStatus().toUpperCase().equals("INCOMPLETE"))
                listIncomplete.add(item);
        }
        return theList;
        //Uses a for loop to find where the status of the item is equal to "incomplete"
        //adds the items to a brand new list
        //returns the brand new list

    }
}
