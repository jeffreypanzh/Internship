package pl.valueadd.equicty.model.dashboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 08/05/17.
 */

public class WeekTasksForAllHorses {

    List<TasksForHorseInWeek> tasksForHorsesInWeek = new ArrayList<>();

    public WeekTasksForAllHorses(List<TasksForHorseInWeek> tasksForHorsesInWeek) {
        this.tasksForHorsesInWeek = tasksForHorsesInWeek;
    }

    public List<TasksForHorseInOneDay> getTasksForHorseInOneDay(){
        List<TasksForHorseInOneDay> listToReturn = new ArrayList<>();
        for (TasksForHorseInWeek tasksForHorseInWeek : tasksForHorsesInWeek){
            for(TasksForHorseInOneDay tasksForHorseInOneDay : tasksForHorseInWeek.getTasksForHorsesinOneDays()){
                listToReturn.add(tasksForHorseInOneDay);
            }
        }
        return listToReturn;
    }

    public TasksForHorseInWeek getTasksForHorseInOneWeek(int horsePosition){
        return tasksForHorsesInWeek.get(horsePosition);
    }

    public int getHorsesCount(){
        return tasksForHorsesInWeek.size();
    }

    public List<Horse> getAllHorses(){
        List<Horse> listToReturn = new ArrayList<>();
        for (TasksForHorseInWeek tasksForHorseInWeek: tasksForHorsesInWeek){
            listToReturn.add(tasksForHorseInWeek.getHorse());
        }
        return listToReturn;
    }

    public Horse getHorseByPosition(int position){
        return tasksForHorsesInWeek.get(position).getHorse();
    }

    public TasksForHorseInOneDay getTasksForHorseInOneDay(int horsePosition, int dayOfWeek){
        return tasksForHorsesInWeek.get(horsePosition).getTasksForHorseinOneDay(dayOfWeek);
    }

}
