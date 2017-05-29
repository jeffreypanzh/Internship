package pl.valueadd.equicty.view.dashboard.adapter;

import android.util.SparseArray;

import pl.valueadd.equicty.model.dashboard.TasksForHorseInOneDay;
import pl.valueadd.equicty.model.dashboard.WeekTasksForAllHorses;


/**
 * Created by piotr on 11/05/17.
 */

public class TaskAdapterHandler {

    SparseArray<TasksAdapter> sparseArray = new SparseArray<>();

    public TaskAdapterHandler(WeekTasksForAllHorses weekTasksForAllHorses){
        for (TasksForHorseInOneDay taskForHorseInOneDay : weekTasksForAllHorses.getTasksForHorseInOneDay()){
            //addDaysAdapter(taskForHorseInOneDay.getDayIentifier(), new TasksAdapter(taskForHorseInOneDay));
        }
    }

    public TasksAdapter getDaysAdapter(int identifier){
        return sparseArray.get(identifier);
    }

    public void addDaysAdapter(int identifier, TasksAdapter tasksAdapter){
        sparseArray.append(identifier, tasksAdapter);
    }


}
