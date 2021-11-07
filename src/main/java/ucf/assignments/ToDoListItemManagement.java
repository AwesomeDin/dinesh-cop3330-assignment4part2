package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

public class ToDoListItemManagement {
    public static Date time() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;

        //Gets the current tiem for the intial item
    }

    public static ObservableList<ToDoListItem> initialItem(ObservableList<ToDoListItem> theList)
    {
        theList.add(new ToDoListItem("256 Characters", "Incomplete", time().toString()));
        return theList;
        //adds an initial item to the list
        //returns the list when finished
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
        return theList;
        //Loop to find item passed in
        //removes item from the list
        //returns the list when finished
    }

    public static ObservableList<ToDoListItem> clearList(ObservableList<ToDoListItem> toClear)
    {
        return FXCollections.observableArrayList();
        //sets the list equal to a brand new list
    }

    public static String statusChange(String s)
    {
        if(s.equalsIgnoreCase("Incomplete"))
            return ("Complete");
        else
            return ("Incomplete");
        //if the string passed in is complete it will send the opposite
        //vice versa as well
    }

    public static Boolean checkLength(int s)
    {
        if(s >=1 && s <=256)
            return true;
        return false;
        //checks to see if length is valid
        //returns boolean dependent if valid
    }

    public static LocalDate checkDate(String s)
    {
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(s,DTF);
        //checks to see if string passed in is formatted correctly
    }
}
