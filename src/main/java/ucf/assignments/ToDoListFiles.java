package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rithvik Dinesh
 */

import javafx.collections.ObservableList;

import java.io.*;
import java.util.Scanner;

public class ToDoListFiles {

    public static boolean saveFile (String folderName, String fileName, ObservableList<ToDoListItem> theList){
        if(fileWriter(folderName, fileName, theList))
            return true;
        return false;

        //See if the filename is empty else proceed
        //Return true if it worked or false if it didn't
    }

    public static boolean fileWriter(String folderName, String fileName, ObservableList<ToDoListItem> theList)
    {
        PrintWriter w;
        try {
            FileWriter fw = new FileWriter(folderName + "\\" + fileName + ".txt",false);
            w = new PrintWriter(fw);
        } catch (IOException e)
        {
            return false;
        }
        w.println(theList.size());
        for(int i = 0; i <theList.size();i++)
            w.println(theList.get(i).toString());
        w.close();
        return true;

        //Write to a new file with filewriter
        //write size, elements of the table, and title of the list to a new file
    }

    public static boolean loadFile (String folderPath, String fileName){
        int size;
        try {
            File file = new File(folderPath+"//"+fileName +".txt");
            Scanner myinput = new Scanner(file);
            if(myinput.hasNextInt())
                size = myinput.nextInt();
            else
                return false;
            myinput.nextLine();

            for(int i = 0;i<size;i++)
            {
                String next = myinput.nextLine();
                String items[] = next.split("\\,");
                String desc = items[0];
                String status = items[1];
                String date = items[2];

                ToDoListItemManagement.addItem(desc,date,status);
            }
            myinput.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
        //Access the file using File library
        //Get the items and put them into a ToDoListItem Object
        //Add the title to the list tab
        //Return true if it worked or false if it didn't
    }
}
