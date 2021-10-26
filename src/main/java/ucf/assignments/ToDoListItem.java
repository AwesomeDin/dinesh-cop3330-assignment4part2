package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

import javafx.beans.property.SimpleStringProperty;

public class ToDoListItem {
    private final SimpleStringProperty itemDescription;
    private final SimpleStringProperty itemStatus;
    private final SimpleStringProperty itemdueDate;

    public ToDoListItem(String description, String status, String dueDate) {
        this.itemDescription = new SimpleStringProperty(description);
        this.itemStatus = new SimpleStringProperty(status);
        this.itemdueDate = new SimpleStringProperty(dueDate);
    }


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

    @Override
    public String toString() {
        return getDescription()+"|"+getDueDate()+"|"+getStatus();
    }
}
