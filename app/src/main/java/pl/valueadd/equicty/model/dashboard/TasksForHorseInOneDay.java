package pl.valueadd.equicty.model.dashboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 08/05/17.
 */

public class TasksForHorseInOneDay {

    int dayIentifier;
    List<Task> tasks = new ArrayList<>();

    public TasksForHorseInOneDay(int dayIentifier, List<Task> tasks) {
        this.dayIentifier = dayIentifier;
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getDayIentifier() {
        return dayIentifier;
    }

    public Task get(int position){
        return tasks.get(position);
    }

    public void remove(int position){
        tasks.remove(position);
    }

    public void add(Task task){
        tasks.add(task); //TODO sort by date
    }

    public int getSize(){
        return tasks.size();
    }

}
