package pl.valueadd.equicty.view.dashboard.rowheighthandler;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.TypedValue;



import java.util.ArrayList;
import java.util.List;

import pl.valueadd.equicty.model.dashboard.WeekTasksForAllHorses;
import pl.valueadd.equicty.view.dashboard.interfaces.ResizableDashboardView;


/**
 * Created by piotr on 15/05/17.
 */

public class RowHeightHandler {

    SparseArray<List<ResizableDashboardView>> dayViewHoldersSparseArray = new SparseArray<>();
    private WeekTasksForAllHorses weekTasksForAllHorses;
    private Context context;
    public static final int DEFAULT_DAY_ROW_HEIGHT = 200;
    public static final int DEFAULT_TASK_HEIGHT = 40;
    private int rowHeightInDp;
    private int taskHeightInDp;

    public RowHeightHandler(WeekTasksForAllHorses weekTasksForAllHorses, Context context) {
        this.weekTasksForAllHorses = weekTasksForAllHorses;
        this.context = context;
        rowHeightInDp = convertDpToPx(DEFAULT_DAY_ROW_HEIGHT);
        taskHeightInDp = convertDpToPx(DEFAULT_TASK_HEIGHT);
    }

    public int getRowHeightForHorse(int horsePosition){
        int higestTaskCountInWeek = weekTasksForAllHorses.getTasksForHorseInOneWeek(horsePosition).getHigestNumberOfTasksInOneDay();
        if (higestTaskCountInWeek * taskHeightInDp < rowHeightInDp){
            return rowHeightInDp;
        }
        return higestTaskCountInWeek * taskHeightInDp;
    }

    public void updateHoldersHeight(int horsePosition){
        List<ResizableDashboardView> resizableViews = dayViewHoldersSparseArray.get(horsePosition);
        if (resizableViews == null){
            return;
        }
        int height = getRowHeightForHorse(horsePosition);
        for (ResizableDashboardView dayViewHolder : resizableViews){
            dayViewHolder.setHeight(height);
        }
    }

    public void removeHolder(ResizableDashboardView resizableDashboardView){
        List<ResizableDashboardView> resizableViews = dayViewHoldersSparseArray.get(resizableDashboardView.getHorsePosition());
        if (resizableViews == null){
            return;
        }
        resizableViews.remove(resizableDashboardView);
        dayViewHoldersSparseArray.append(resizableDashboardView.getHorsePosition(), resizableViews);
    }

    public void addHolder(ResizableDashboardView resizableDashboardView){
        List<ResizableDashboardView> resizableViews = dayViewHoldersSparseArray.get(resizableDashboardView.getHorsePosition());
        if (resizableViews == null){
            resizableViews = new ArrayList<>();
        }
        resizableViews.add(resizableDashboardView);
        dayViewHoldersSparseArray.append(resizableDashboardView.getHorsePosition(), resizableViews);
    }

    private int convertDpToPx(int dp){
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return Math.round(px);
    }

}
