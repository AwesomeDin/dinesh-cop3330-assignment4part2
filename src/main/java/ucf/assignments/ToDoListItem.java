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







/*
public class ToDoListItem {
    private final SimpleStringProperty itemDesc;
    private final SimpleStringProperty itemStatus;
    private final SimpleStringProperty itemDate;

    public ToDoListItem(String itemDesc, String itemStatus, String itemDate) {
        this.itemDesc = new SimpleStringProperty(itemDesc);
        this.itemStatus = new SimpleStringProperty(itemStatus);
        this.itemDate = new SimpleStringProperty(itemDate);
    }

    public String getitemDesc() {
        return itemDesc.get();
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc.set(itemDesc);
    }

    public String getitemStatus() {
        return itemStatus.get();
    }
    public void setitemStatus(String itemStatus) {
        this.itemStatus.set(itemStatus);
    }

    public String getitemDate() {
        return itemDate.get();
    }
    public void setitemDate(String itemDate) {
        this.itemDate.set(itemDate);
    }

    @Override
    public String toString() {
        return getitemDesc() + "|"+getitemDate()+"|"+getitemStatus();
    }

    //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
}
*/
