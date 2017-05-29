package pl.valueadd.equicty.model.dashboard;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.valueadd.equicty.view.dashboard.TasksDashboard;

/**
 * Created by piotr on 08/05/17.
 */

public class FakeDataGenerator {

    static int lastTaskId = 0;

    public static WeekTasksForAllHorses getWeekTasksForAllHorses(){
        List<TasksForHorseInWeek> tasksForHorseInWeeks =  new ArrayList<>();
        for (int i = 0 ;i < 20; i++){
            Horse horse = new Horse(i);
            tasksForHorseInWeeks.add(getTasksForHorseInWeek(horse));
        }
        return new WeekTasksForAllHorses(tasksForHorseInWeeks);
    }

    private static TasksForHorseInWeek getTasksForHorseInWeek(Horse horse){
        List<TasksForHorseInOneDay> tasksForWeek =  new ArrayList<>();
        for (int i = 0; i < TasksDashboard.DASHBOARD_PERIORD; i++){
            tasksForWeek.add(getTasksForHorseInOneDay(horse));
        }
        return new TasksForHorseInWeek(horse, tasksForWeek);
    }

    static int dayIdentifier = 0;
    private static TasksForHorseInOneDay getTasksForHorseInOneDay(Horse horse){
        dayIdentifier++;
        return new TasksForHorseInOneDay(dayIdentifier, getRandomTasks(horse));
    }

    private static List<Task> getRandomTasks(Horse horse){
        List<Task> horsesToReturn = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(4) +1 ; i++){
            horsesToReturn.add(getFakeTask(horse));
        }
        return horsesToReturn;
    }

    private static Task getFakeTask(Horse horse){
        lastTaskId++;
        return new Task(lastTaskId, horse.getId(), horse.name + horse.getId() + " " + lastTaskId);
    }



}
