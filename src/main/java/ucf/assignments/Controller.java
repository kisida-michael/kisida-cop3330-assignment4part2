package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Controller  {

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
    private Button btnSave;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnToday1;

    @FXML
    private Label incompleteWidget;

    @FXML
    private Label totalTasksWidget;

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
    private TextField descriptionField;

    @FXML
    private Pane pnlComplete;

    @FXML
    private Pane pnlIncomplete;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableView<Task> incompletedTbl;

    @FXML
    private TableView<Task> todoListTbl;

    @FXML
    private TableColumn<Task, Task> tcTask;

    @FXML
    private TableColumn<Task, String> tcDescription;

    @FXML
    private TableColumn<Task, String> tcDueDate;

    @FXML
    private TableColumn<Task, String> tcPriority;

    @FXML
    private TableColumn<Task, Task> iTask;

    @FXML
    private TableColumn<Task, String> iDescription;

    @FXML
    private TableColumn<Task, String> iDueDate;

    @FXML
    private TableColumn<Task, String> iPriority;


    private ObservableList<Task> todoTasks = FXCollections.observableArrayList();
    private ObservableList<Task> incompleteTasks = FXCollections.observableArrayList();;
    private ObservableList<Task> completeTbl = FXCollections.observableArrayList();;




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
        refreshValues();
        pnlOverview.setVisible(false);
        pnlComplete.setVisible(false);
        pnlIncomplete.setVisible(true);
    }

    String task;
    String description;
    String dueDateStr;
    String priority;

    @FXML
    void addTask(MouseEvent event) {

        task = newTask.getText();
        description = descriptionField.getText();
        priority = PriorityField.getText();
        LocalDate dueDate = dateField.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        dueDateStr = dueDate.format(formatter);

        clearFields();
        Task newTask = new Task(task, description, dueDateStr, priority);
        ObservableList<Task> todoTasks = todoListTbl.getItems();
        incompleteTasks.add(newTask);
        todoTasks.add(newTask);
        todoListTbl.setItems(todoTasks);
        incompletedTbl.setItems(todoTasks);

        refreshValues();

    }
    @FXML
    void clearFields(){
        dateField.setValue(null);
        newTask.clear();
        descriptionField.clear();
        PriorityField.clear();
    }
    @FXML
    void editTask(MouseEvent event){
        Task edit = todoListTbl.getSelectionModel().getSelectedItem();
        newTask.setText(edit.getTask());
        descriptionField.setText(edit.getDescription());
        PriorityField.setText(edit.getPriority());
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);
        

    }
    @FXML
    void deleteTask(MouseEvent event) {
        int selectedId = todoListTbl.getSelectionModel().getSelectedIndex();
        todoListTbl.getItems().remove(selectedId);

    }
    @FXML
    void refreshValues(){
        int totalTask =  todoListTbl.getItems().size();
        totalTasksWidget.setText(String.valueOf(totalTask));
    }
    @FXML
    void editConfirm(){

    }
    @FXML
    void handleButtonClick(ActionEvent event) {
        if(event.getSource() ==btnAdd){

        }
        if(event.getSource() ==btnLoad){

        }
        if(event.getSource() ==btnDelete){

        }
        if(event.getSource() ==btnSave){

        }
        if(event.getSource() == btnDone){
          editConfirm();
        }
    }
    @FXML
    void removeList(MouseEvent event){
        todoListTbl.getItems().clear();
    }
    @FXML
    void saveList(MouseEvent event){
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
        for (int i = 0; i < arrList.size();  i++){
            for (int j = 0; j < arrList.get(i).size(); j++){
                System.out.print(","+arrList.get(i).get(j));
            }
        }
        try{
            FileOutputStream writeData = new FileOutputStream("test.txt");
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
        try{
            FileInputStream readData = new FileInputStream("test.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Task> savedData = (ArrayList<Task>) readStream.readObject();
            readStream.close();
            System.out.println(savedData.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
       // System.out.println("Y");
        tcTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tcDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        tcPriority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        iTask.setCellValueFactory(new PropertyValueFactory<>("Task"));
        iDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        iDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        iPriority.setCellValueFactory(new PropertyValueFactory<>("Priority"));

        //todoListTbl.setItems(dashboardTbl);
    }

}





