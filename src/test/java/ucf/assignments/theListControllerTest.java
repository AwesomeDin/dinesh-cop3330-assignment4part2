package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class theListControllerTest {

    //PLEASE READ
    //Please edit the savetest to reflect a path to a folder somewhere on your computer,
    //then the test will work.

    @Test
    void editDueDate() {
        //grab the list
        //grab the details of the item
        //edit duedate
        //check to see if duedate is correct
    }
    @Test
    void editDescription() {
        //grab the list
        //grab the details of the item
        //edit description
        //check to see if the description is correct
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

        Assertions.assertTrue(ToDoListFiles.saveFile("C:\\Users\\rithvik\\Desktop","test",test));

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