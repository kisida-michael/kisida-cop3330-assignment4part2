package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import ucf.assignments.Task;
import static org.junit.jupiter.api.Assertions.*;


class ControllerTest {
    String task;
    String description;
    String dueDateStr;
    String priority;

    private ObservableList<Task> testTasks = FXCollections.observableArrayList();
    Task testTask = new  Task(task, description, dueDateStr, priority);
    @Test
    void test100Tasks(){
        assertEquals(0, testTasks.size());
        for(int i = 0; i < 100; i++){
            testTask = new Task("100TaskTest", "Do", "11-24-21", "yes");
            testTasks.add(testTask);
        }
        assertEquals(100, testTasks.size());
        testTasks = null;

    }
    @Test
    void addTask() {

        assertEquals(0, testTasks.size());
        testTask = new Task("Test", "Do", "11-24-21", "yes");
        testTasks.add(testTask);
        testTask = new Task("Test2", "Do2", "11-25-21", "no");
        testTasks.add(testTask);
        assertEquals(2, testTasks.size());


    }

    @Test
    void editTask() {
    }

    @Test
    void deleteTask() {
        Task testTask = new  Task(task, description, dueDateStr, priority);

    }

    @Test
    void removeList() {
    }

    @Test
    void saveList() {
    }

    @Test
    void loadList() {
    }
}