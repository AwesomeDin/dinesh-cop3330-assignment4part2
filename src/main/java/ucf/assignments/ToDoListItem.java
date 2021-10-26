package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

import javafx.beans.property.SimpleStringProperty;

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
    public void getitemDesc(String fName) {
        itemDesc.set(fName);
    }

    public String getitemStatus() {
        return itemStatus.get();
    }
    public void setitemStatus(String fName) {
        itemStatus.set(fName);
    }

    public String getitemDate() {
        return itemDate.get();
    }
    public void setitemDate(String fName) {
        itemDate.set(fName);
    }

    //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
}
