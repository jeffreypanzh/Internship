package pl.valueadd.equicty.view.dashboard.interfaces;

import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.View;

import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.Task;
import pl.valueadd.equicty.model.dashboard.TasksForHorseInOneDay;
import pl.valueadd.equicty.view.dashboard.adapter.TasksAdapter;


/**
 * Created by piotr on 12/05/17.
 */

public class DragListener implements View.OnDragListener {

    private boolean isDropped = false;

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                //v.setBackgroundColor(Color.LTGRAY);
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                //v.setBackgroundColor(Color.YELLOW);
                break;

            case DragEvent.ACTION_DROP:
                isDropped = true;
                int positionSource;

                View viewSource = (View) event.getLocalState();

                if (v.getId() == R.id.task_textView || v.getId() == R.id.one_day_recyclerView) {
                    RecyclerView target;
                    if (v.getId() == R.id.task_textView) {
                        target = (RecyclerView)
                                v.getParent();
                    } else {
                        target = (RecyclerView) v;
                    }

                    RecyclerView source = (RecyclerView) viewSource.getParent();

                    TasksAdapter adapterSource = (TasksAdapter) source.getAdapter();
                    positionSource = (int) viewSource.getTag();

                    Task movingTask = adapterSource.getTasksForHorseInOneDay().get(positionSource);
                    TasksForHorseInOneDay tasksSource = adapterSource.getTasksForHorseInOneDay();

                    tasksSource.remove(positionSource);
                    adapterSource.setTasksForHorseInOneDay(tasksSource);
                    adapterSource.notifyDataSetChanged();
                    adapterSource.updateRowHeight();

                    TasksAdapter adapterTarget = (TasksAdapter) target.getAdapter();
                    TasksForHorseInOneDay customListTarget = adapterTarget.getTasksForHorseInOneDay();

                    customListTarget.add(movingTask);
                    adapterTarget.setTasksForHorseInOneDay(customListTarget);
                    adapterTarget.updateRowHeight();
                    adapterTarget.notifyDataSetChanged();
                    v.setVisibility(View.VISIBLE);
                    //TasksDashboard.scrollSynchronizer.weekRecyclerView.invalidate();

                }

                break;

            case DragEvent.ACTION_DRAG_ENDED:
                //v.setBackgroundColor(0);
                break;

            default:
                break;
        }

        if (!isDropped) {
            View vw = (View) event.getLocalState();
            vw.setVisibility(View.VISIBLE);
        }

        return true;
    }

}