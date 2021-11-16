/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Kisida
 */
package ucf.assignments;


import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;


public class Task implements Serializable {
    protected SimpleStringProperty Task;
    protected SimpleStringProperty Description;
    protected SimpleStringProperty DueDate;
    protected SimpleStringProperty Priority;


    public Task(String Task, String Description, String DueDate, String Priority) {
        this.Task = new SimpleStringProperty(Task);
        this.Description = new SimpleStringProperty(Description);
        this.DueDate = new SimpleStringProperty(DueDate);
        this.Priority = new SimpleStringProperty(Priority);
    }

    public Task() {

    }

    public String getTask() {
        return Task.get();
    }


    public void setTask(String task) {
        this.Task.set(task);
    }

    public String getDescription() {
        return Description.get();
    }


    public void setDescription(String description) {
        this.Description.set(description);
    }

    public String getDueDate() {
        return DueDate.get();
    }


    public void setDueDate(String dueDate) {
        this.DueDate.set(dueDate);
    }

    public String getPriority() {
        return Priority.get();
    }


    public void setPriority(String priority) {
        this.Priority.set(priority);
    }
}
