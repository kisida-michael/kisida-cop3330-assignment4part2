/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Kisida
 */
package ucf.assignments;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SaveData implements Serializable {
    private ArrayList<Task> list;


    public SaveData(ArrayList<Task> list) {
        this.list = list;

    }

    public ArrayList<Task> getList() {
        return list;
    }
}


