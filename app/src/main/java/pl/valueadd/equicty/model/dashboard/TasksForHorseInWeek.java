package pl.valueadd.equicty.model.dashboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 08/05/17.
 */

public class TasksForHorseInWeek {

    private Horse horse;
    private List<TasksForHorseInOneDay> tasksForHorsesinOneDays = new ArrayList<>();

    public TasksForHorseInWeek(Horse horse, List<TasksForHorseInOneDay> tasksForHorsesinOneDays) {
        this.horse = horse;
        this.tasksForHorsesinOneDays = tasksForHorsesinOneDays;
    }

    public Horse getHorse() {
        return horse;
    }

    public List<TasksForHorseInOneDay> getTasksForHorsesinOneDays() {
        return tasksForHorsesinOneDays;
    }

    public TasksForHorseInOneDay getTasksForHorseinOneDay(int dayOfWeek) {
        return tasksForHorsesinOneDays.get(dayOfWeek);
    }

    public int getHigestNumberOfTasksInOneDay(){
        int higestNumberOfTasks = 0;
        for (TasksForHorseInOneDay tasksForHorseInOneDay : tasksForHorsesinOneDays){
            if (tasksForHorseInOneDay.getSize() > higestNumberOfTasks){
                higestNumberOfTasks = tasksForHorseInOneDay.getSize();
            }
        }
        return higestNumberOfTasks;
    }

}
