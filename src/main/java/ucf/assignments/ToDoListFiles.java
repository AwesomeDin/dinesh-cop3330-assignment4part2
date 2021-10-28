package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ToDoListFiles {

    public static boolean saveFile (TextField folderName, TextField fileName, int size){
        Boolean checkWorked = fileWriter(folderName.getCharacters().toString(), fileName.getCharacters().toString(), size);
        if(checkWorked)
        {
            return true;
        }
        return false;

        //See if the filename is empty else proceed
        //Write to a new file with filewriter
        //write size, elements of the table, and title of the list to a new file
        //Return true if it worked or false if it didn't
    }

    public static boolean fileWriter(String folderName, String fileName, int size)
    {
        PrintWriter writer;
        try {
            FileWriter fw = new FileWriter(folderName + "\\" + fileName + ".txt",false);
            writer = new PrintWriter(fw);
        } catch (IOException e)
        {
            return false;
        }
        writer.println(size);
        for(int i = 0; i <size;i++)
        {
            writer.println(theListController.mainList.get(i).toString());
        }
        writer.close();
        return true;
    }

    public static boolean loadFile (){
        //Access the file using File library
        //Get the items and put them into a ToDoListItem Object
        //Add the title to the list tab
        //Return true if it worked or false if it didn't
        return true;
    }
}
