package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField PriorityField;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAll;

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
    private Button btnToday1;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField newTask;

    @FXML
    private VBox pnItems;

    @FXML
    private Pane pnlIncomplete;

    @FXML
    private Pane pnlList;


    @FXML
    private ListView<?> list;


    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlTasks;

    @FXML
    private Text taskSample;

    void newList(){

        /*list.create.getListInput
        * */
    }
    void deleteList(){
        /*list.remove(list.getSelection.getSelectedItem
         * completeList.remove(list.getSecletion.getSelecteItem)
         * list.getSelection model clear selection*/
    }
    void editListTitle(){

    }
    void addTask(){
        /*list.add(new Task TaskInput.get text
        * taskText.setItem(list)*/
    }
    void markComplete(ActionEvent event){
        /*if list.isfocused
        *   curTask = list.get selection. get selected item
        * list.remove currTask
        * completeList.add(currTask)*/

    }
    void deleteTask(ActionEvent event){
        /*list.remove(list.getSelection.getSelectedItem
        * completeList.remove(list.getSecletion.getSelecteItem)
        * list.getSelection model clear selection*/
    }
    void viewCompleted(){
        /*setPanetoCompletedItems. shown completed Items pane on list*/
    }
    void viewInCompleted(){
        /*setPanetoinCompletedItems. shown incompleted Items pane on list*/
    }
    void viewDashboard(){
      /*  setPanetoDashboard . show all items in List*/
    }
}



