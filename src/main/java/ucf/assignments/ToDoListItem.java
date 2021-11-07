package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

import javafx.beans.property.SimpleStringProperty;

public class ToDoListItem {
    //variables declarations:
    //descriptions, status, dueDate

    private final SimpleStringProperty itemDescription;
    private final SimpleStringProperty itemStatus;
    private final SimpleStringProperty itemdueDate;

    //Constructor to set all the variables to the incoming values
    public ToDoListItem(String description, String status, String dueDate) {
        this.itemDescription = new SimpleStringProperty(description);
        this.itemStatus = new SimpleStringProperty(status);
        this.itemdueDate = new SimpleStringProperty(dueDate);
    }


    //Setters and getters for every variable
    public String getDescription() {
        return itemDescription.get();
    }

    public void setDescription(String description) {
        this.itemDescription.set(description);
    }

    public String getStatus() {
        return itemStatus.get();
    }

    public void setStatus(String status) {
        this.itemStatus.set(status);
    }

    public String getDueDate() {
        return itemdueDate.get();
    }

    public void setDueDate(String dueDate) {
        this.itemdueDate.set(dueDate);
    }

    public String toWrite() {
        return getDescription()+","+getDueDate()+","+getStatus();
        //used for printing everything to a file
    }
}
