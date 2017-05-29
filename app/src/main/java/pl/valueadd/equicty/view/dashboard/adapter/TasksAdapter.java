package pl.valueadd.equicty.view.dashboard.adapter;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.TasksForHorseInOneDay;
import pl.valueadd.equicty.view.dashboard.interfaces.DragListener;
import pl.valueadd.equicty.view.dashboard.interfaces.TasksCountChangeListener;


/**
 * Created by piotr on 11/05/17.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    TasksForHorseInOneDay mTasksForHorseInOneDay;
    int horsePosition;
    TasksCountChangeListener tasksCountChangeListener;

    public TasksAdapter(TasksForHorseInOneDay mTasksForHorseInOneDay, int horsePosition, TasksCountChangeListener tasksCountChangeListener) {
        this.mTasksForHorseInOneDay = mTasksForHorseInOneDay;
        this.horsePosition = horsePosition;
        this.tasksCountChangeListener = tasksCountChangeListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_itemview, null);
        TasksAdapter.TaskViewHolder dayViewHolder = new TasksAdapter.TaskViewHolder(layoutView);
        return dayViewHolder;
    }

    public void updateRowHeight(){
        tasksCountChangeListener.onTasksCountChange(horsePosition);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.taskTextView.setText(mTasksForHorseInOneDay.getTasks().get(position).getText());
        holder.taskTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        holder.taskTextView.setOnDragListener(new DragListener());
        holder.taskTextView.setTag(position);
    }

    public TasksForHorseInOneDay getTasksForHorseInOneDay() {
        return mTasksForHorseInOneDay;
    }

    public void setTasksForHorseInOneDay(TasksForHorseInOneDay tasksForHorseInOneDay) {
        mTasksForHorseInOneDay = tasksForHorseInOneDay;
    }

    @Override
    public int getItemCount() {
        return mTasksForHorseInOneDay.getTasks().size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.task_textView) TextView taskTextView;

        public TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}