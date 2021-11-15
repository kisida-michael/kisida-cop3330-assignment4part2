package ucf.assignments;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SaveData implements Serializable
{
    private ArrayList<Task> list;
    private ArrayList<Task> listCompleted;
    private ArrayList<Task> listIncompleted;

    public SaveData(ArrayList<Task> list, ArrayList<Task> listCompleted, ArrayList<Task>listIncompleted)
    {
        this.list = list;
        this.listCompleted = listCompleted;
        this.listIncompleted = listIncompleted;
    }

    public ArrayList<Task> getList()
    {
        return list;
    }

    public ArrayList<Task> getListCompleted()
    {
        return listCompleted;
    }

    public ArrayList<Task> getListIncompleted()
    {
        return listIncompleted;
    }
}
