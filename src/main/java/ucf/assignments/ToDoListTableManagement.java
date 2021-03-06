package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class ToDoListTableManagement {

    public static ObservableList<ToDoListItem> showComplete(ObservableList<ToDoListItem> theList) {
        ObservableList<ToDoListItem> listComplete = FXCollections.observableArrayList();
        for(ToDoListItem item: theList)
        {
            if(item.getStatus().equalsIgnoreCase("Complete"))
                listComplete.add(item);
        }
        return listComplete;
        //Uses a for loop to find where the status of the item is equal to "complete"
        //adds the items to a brand new list
        //returns the brand new list
    }

    public static ObservableList<ToDoListItem> showIncomplete(ObservableList<ToDoListItem> theList) {
        ObservableList<ToDoListItem> listIncomplete = FXCollections.observableArrayList();
        for(ToDoListItem item: theList)
        {
            if(item.getStatus().equalsIgnoreCase("Incomplete"))
                listIncomplete.add(item);
        }
        return listIncomplete;
        //Uses a for loop to find where the status of the item is equal to "incomplete"
        //adds the items to a brand new list
        //returns the brand new list

    }

    public static ObservableList<ToDoListItem> showAll(ObservableList<ToDoListItem> theList) {
        ObservableList<ToDoListItem> newList = FXCollections.observableArrayList();
        for (ToDoListItem item : theList) {
            newList.add(item);
        }
        return newList;
        //adds all the items to a new list
        //returns that new list to show all
    }

}
