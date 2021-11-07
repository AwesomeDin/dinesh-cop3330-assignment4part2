package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

class theListControllerTest {

    @Test
    void checkCapacity () {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        for(int i = 0; i< 110;i++){
            test.add(new ToDoListItem("test" + i,"Incomplete","2021-10-28"));
        }
        Assertions.assertTrue(test.size()>100);

        //checks to see if the list can hold more than 100 items
    }

    @Test
    void editDueDate() {
        LocalDate date = LocalDate.parse("1995-01-01");
        Assertions.assertEquals(date,ToDoListItemManagement.checkDate("1995-01-01"));
        //grab the list
        //grab the details of the item
        //check to see if duedate is correct format
    }
    @Test
    void editDescription() {
        Assertions.assertTrue(ToDoListItemManagement.checkLength(30));
        //grab the list
        //grab the details of the item
        //check to see if description is within range
    }

    @Test
    void buttonAddItem() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        ToDoListItemManagement.initialItem(test);
        Assertions.assertTrue(test.size()>0);
        //grab the observablelist of items
        //grab the details of the items
        //add the item to the list
        //check to see if the size has increased
    }

    @Test
    void buttonRemoveItem() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        ToDoListItemManagement.initialItem(test);
        test.remove(0);
        Assertions.assertTrue(test.size()<1);
        //grab the list of items
        //grab the details of the item
        //search for the item in the list and delete
        //check to see if the item in list
    }

    @Test
    void buttonChangeStatus() {
        Assertions.assertEquals("Complete",ToDoListItemManagement.statusChange("Incomplete"));
        //grab the list of items
        //grab the details of the item
        //search for the item in the list and change status
        //check to see if status has changed
    }

    @Test
    void buttonShowIncomplete() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        test.add(new ToDoListItem("test","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("test","Complete","2021-10-28"));
        test.add(new ToDoListItem("testttttt","Complete","2021-10-28"));
        Assertions.assertEquals(1,ToDoListTableManagement.showIncomplete(test).size());
        //grab the list of items
        //loop to grab only the incomplete items
        //check to see if the amount of incomplete is equal to what was expected
    }

    @Test
    void buttonShowComplete() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        test.add(new ToDoListItem("test","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("testttttt","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("test","Complete","2021-10-28"));
        Assertions.assertEquals(1,ToDoListTableManagement.showComplete(test).size());

        //grab the list of items
        //loop to grab only the complete items
        //check to see if the amount of complete is equal to what was expected
    }

    @Test
    void buttonShowAll() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        test.add(new ToDoListItem("test","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("testttttt","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("test","Complete","2021-10-28"));
        Assertions.assertEquals(3,ToDoListTableManagement.showAll(test).size());
        //grab the list of items
        //check to see if the items displayed are equal to size of list
    }

    @Test
    void buttonLoadList() {
        Assertions.assertFalse(ToDoListFiles.loadFile("C:\\Users\\rithvik\\Deskto","test"));

        //grab the file and file path
        //read in all items to a list
        //check to see if list matches our expected list
    }

    @Test
    void buttonSaveList() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        test.add(new ToDoListItem("test","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("testttttt","Incomplete","2021-10-28"));
        test.add(new ToDoListItem("test","Complete","2021-10-28"));

        Assertions.assertTrue(ToDoListFiles.saveFile("src/main/java","test",test));

        //grab the list of items and filepath
        //write all items in the list to a file
        //check to see if file matches our test file
    }

    @Test
    void buttonClearList() {
        ObservableList<ToDoListItem> test = FXCollections.observableArrayList();
        ToDoListItemManagement.initialItem(test);
        ToDoListItemManagement.initialItem(test);

        Assertions.assertTrue(ToDoListItemManagement.clearList(test).size() < 1);
        //restart the currentlist
        //check to see that the currentlist is empty
    }
}