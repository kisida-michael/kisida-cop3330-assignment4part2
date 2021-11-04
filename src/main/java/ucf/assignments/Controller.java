package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private TextField PriorityField;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnComplete;

    @FXML
    private Button btnCreateList;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnLoad1;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnToday1;

    @FXML
    private ListView completeList;

    @FXML
    private ListView dashboardList;

    @FXML
    private DatePicker dateField;

    @FXML
    private ListView incompleteList;

    @FXML
    private TextField newTask;

    @FXML
    private Pane pnlComplete;

    @FXML
    private Pane pnlIncomplete;

    @FXML
    private Pane pnlOverview;

    String task;

    @FXML
    void completePane(MouseEvent event) {
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(true);
        pnlIncomplete.setVisible(false);
    }
    @FXML
    void dashboardPane(MouseEvent event) {
        pnlOverview.setVisible(true);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(false);
    }

    @FXML
    void incompletePane(MouseEvent event) {
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(true);
    }


    @FXML
    void addTask(MouseEvent event) {
        task = newTask.getText();
        dashboardList.getItems().add(task);
    }
}



   /* void newList(){

        *//*list.create.getListInput
        * *//*
    }
    void deleteList(){
        *//*list.remove(list.getSelection.getSelectedItem
         * completeList.remove(list.getSecletion.getSelecteItem)
         * list.getSelection model clear selection*//*
    }
    void editListTitle(){

    }
    void addTask(){
        *//*list.add(new Task TaskInput.get text
        * taskText.setItem(list)*//*
    }
    void markComplete(ActionEvent event){
        *//*if list.isfocused
        *   curTask = list.get selection. get selected item
        * list.remove currTask
        * completeList.add(currTask)*//*

    }
    void deleteTask(ActionEvent event){
        *//*list.remove(list.getSelection.getSelectedItem
        * completeList.remove(list.getSecletion.getSelecteItem)
        * list.getSelection model clear selection*//*
    }
    void viewCompleted(){
        *//*setPanetoCompletedItems. shown completed Items pane on list*//*
    }
    void viewInCompleted(){
        *//*setPanetoinCompletedItems. shown incompleted Items pane on list*//*
    }
    void viewDashboard(){
      *//*  setPanetoDashboard . show all items in List*//*
    }
}*/



