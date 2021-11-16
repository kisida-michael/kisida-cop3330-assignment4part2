/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Kisida
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller  {

    @FXML
    private TextField PriorityField;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Label incompleteWidget;
    @FXML
    private Label totalTasksWidget;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField newTask;
    @FXML
    private TextField descriptionField;
    @FXML
    private Pane pnlComplete;
    @FXML
    private Pane pnlIncomplete;
    @FXML
    private Text errorLabel;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TableView<Task> incompletedTbl;
    @FXML
    private TableView<Task> todoListTbl;
    @FXML
    private TableView<Task> completedTbl;
    @FXML
    private TableColumn tcTask;
    @FXML
    private TableColumn tcDescription;
    @FXML
    private TableColumn tcDueDate;
    @FXML
    private TableColumn<Object, Object> tcPriority;
    @FXML
    private TableColumn<Object, Object> iTask;
    @FXML
    private TableColumn<Object, Object> iDescription;
    @FXML
    private TableColumn<Object, Object> iDueDate;
    @FXML
    private TableColumn<Object, Object> iPriority;
    @FXML
    private TableColumn<Object, Object> cTask;
    @FXML
    private TableColumn<Object, Object> cDescription;
    @FXML
    private TableColumn<Object, Object> cDueDate;
    @FXML
    private TableColumn<Object, Object> cPriority;
    @FXML
    private ScrollPane helpPane;

    //create observable list for allTasks
    private ObservableList<Task> todoTasks = FXCollections.observableArrayList();
    private ObservableList<Task> incompleteTasks = FXCollections.observableArrayList();
    private ObservableList<Task> completeTasks = FXCollections.observableArrayList();


    @FXML
    //switch to completed Task pane
    void completePane(MouseEvent event) {
        refreshValues();
        helpPane.setVisible(false);
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(true);
        pnlIncomplete.setVisible(false);
    }
    @FXML
    //switches to help Pane to view how to use
    void helpPane(MouseEvent event) {

        helpPane.setVisible(true);
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(false);
    }
    @FXML
    // switches to dashboard pane
    void dashboardPane(MouseEvent event) {
        refreshValues();
        helpPane.setVisible(false);
        pnlOverview.setVisible(true);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(false);
    }


    @FXML
    //switch to incomplete Tasks pane
    void incompletePane(MouseEvent event) {
        helpPane.setVisible(false);
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(true);
    }
    // null String values
    String task;
    String description;
    String dueDateStr;
    String priority;

    @FXML
    // add a new Task
    //validates description to be under 256 characters
    void addTask(MouseEvent event) {
        refreshValues();
        task = newTask.getText();
        description = descriptionField.getText();
        if(description.length() > 256){
            errorLabel.setText("Description too Long");
            return;
        }
        if(description.length() < 1){
            errorLabel.setText("Description needs Value");
            return;
        }

        priority = PriorityField.getText();
        LocalDate dueDate = dateField.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dueDateStr = dueDate.format(formatter);

        clearFields();
        Task newTask = new Task(task, description, dueDateStr, priority);
        ObservableList<Task> todoTasks = todoListTbl.getItems();
        incompleteTasks.add(newTask);
        todoTasks.add(newTask);
        todoListTbl.setItems(todoTasks);
        incompletedTbl.setItems(incompleteTasks);

        refreshValues();

    }
    @FXML
    void doneTask(MouseEvent event){
        //sets a task to the done Table
       completeTasks.add(incompletedTbl.getSelectionModel().getSelectedItem());
       completedTbl.setItems(completeTasks);
       ObservableList<Task> completeTasks = completedTbl.getItems();
       incompletedTbl.getItems().remove(incompletedTbl.getSelectionModel().getSelectedItem());
       refreshValues();

    }
    @FXML
    void clearFields(){
        //clears all input fields
        dateField.setValue(null);
        newTask.clear();
        descriptionField.clear();
        PriorityField.clear();
    }
    @FXML
    void editTask(MouseEvent event){
        //edits the task
        Task edit = todoListTbl.getSelectionModel().getSelectedItem();
        newTask.setText(edit.getTask());
        descriptionField.setText(edit.getDescription());
        PriorityField.setText(edit.getPriority());
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);


    }
    @FXML
    void deleteTask(MouseEvent event) {
        //deletes the current selected Task
        int selectedId = todoListTbl.getSelectionModel().getSelectedIndex();
        todoListTbl.getItems().remove(selectedId);
        incompletedTbl.getItems().remove(selectedId);
        completedTbl.getItems().remove(selectedId);
        refreshValues();

    }
    @FXML
    void refreshValues(){
        //sets values of all Tasks and incomplete Tasks
        errorLabel.setText("");
        int totalTask =  todoListTbl.getItems().size();
        int incompleteTask = incompletedTbl.getItems().size();
        totalTasksWidget.setText(String.valueOf(totalTask));
        incompleteWidget.setText(String.valueOf(incompleteTask));
    }

    @FXML
    void removeList(MouseEvent event){
        //removes the entire list
        todoListTbl.getItems().clear();
        incompletedTbl.getItems().clear();
        completedTbl.getItems().clear();
        refreshValues();
    }
    @FXML
    void saveList(MouseEvent event){
        // Saves the Arraylist to a text file
        //Converts to arraylist and adds all tasks from todoTable
       Task task = new Task();

       List <List<String>> arrList = new ArrayList<>();

       for(int i = 0; i <  todoListTbl.getItems().size(); i++){
          task = todoListTbl.getItems().get(i);
          arrList.add(new ArrayList<>());
          arrList.get(i).add(task.Task.get());
          arrList.get(i).add(task.Description.get());
          arrList.get(i).add(task.DueDate.get());
          arrList.get(i).add(task.Priority.get());
       }
        for (List<String> strings : arrList) {
            for (String string : strings) {
                System.out.print(string);
            }
        }
        try{
            FileOutputStream writeData = new FileOutputStream("appData.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(arrList);
            writeStream.flush();
            writeStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void loadList(MouseEvent event){
        //load
        try{
            FileInputStream readData = new FileInputStream("appData.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Task> savedData = (ArrayList<Task>) readStream.readObject();
            readStream.close();
            String list = Arrays.toString(savedData.toArray()).replace("[", "").replace("]", "").replace(" ", "");

            String[] listArray =list.split(",");
            // For loop to add String array
            for(int i = 0; i < listArray.length; ){
                String tempTask = listArray[i];
                String tempDescription = listArray[i+1];
                String tempDueDate = listArray[i+2];
                String tempPriority = listArray[i+ 3];
               Task loadTasks = new Task(tempTask, tempDescription, tempDueDate, tempPriority);
                todoTasks.add(loadTasks);
                incompleteTasks.add(loadTasks);
                todoListTbl.setItems(todoTasks);
                incompletedTbl.setItems(incompleteTasks);
                i = i+4;

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void setEditable(){
        //allows the table rows to be edited
        tcTask.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Task, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setTask(t.getNewValue())
        );
        tcDescription.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Task, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setDescription(t.getNewValue())
        );
        tcDueDate.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Task, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setDueDate(t.getNewValue())
        );
    }
    public void initialize() {
        //intializes all column values
        todoListTbl.setEditable(true);
        setEditable();
        //todoListTbl.getSelectionModel().cellSelectionEnabledProperty().set(true);
        tcTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("Description"));
        tcDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        tcPriority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        iTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        iDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        iDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        iPriority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        cTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        cDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        cDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        cPriority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        tcTask.setCellFactory(TextFieldTableCell.forTableColumn());
        tcDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        tcDueDate.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}





