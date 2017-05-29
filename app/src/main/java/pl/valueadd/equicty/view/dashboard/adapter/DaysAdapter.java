package pl.valueadd.equicty.view.dashboard.adapter;

import android.content.Context;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import butterknife.BindView;
import butterknife.ButterKnife;
import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.WeekTasksForAllHorses;
import pl.valueadd.equicty.view.dashboard.TasksDashboard;
import pl.valueadd.equicty.view.dashboard.interfaces.ResizableDashboardView;
import pl.valueadd.equicty.view.dashboard.interfaces.TasksCountChangeListener;
import pl.valueadd.equicty.view.dashboard.rowheighthandler.RowHeightHandler;
import pl.valueadd.equicty.view.tools.ScreenUtils;

/**
 * Created by piotr on 08/05/17.
 */

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> implements TasksCountChangeListener {

    private WeekTasksForAllHorses weekTasksForAllHorses;
    private Context mContext;
    //private TaskAdapterHandler taskAdapterHandler;
    RowHeightHandler rowHeightHandler;

    public DaysAdapter(Context context, WeekTasksForAllHorses weekTasksForAllHorses, RowHeightHandler rowHeightHandler) {
        mContext = context;
        this.weekTasksForAllHorses = weekTasksForAllHorses;
        //taskAdapterHandler = new TaskAdapterHandler(weekTasksForAllHorses);
        this.rowHeightHandler = rowHeightHandler;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_itemview, null);
        return new DayViewHolder(layoutView, mContext);
    }

    @Override
    public void onBindViewHolder(final DayViewHolder holder, int position) {
        int horsePosition = position / TasksDashboard.DASHBOARD_PERIORD;
        int dayOfWeek = position % TasksDashboard.DASHBOARD_PERIORD;
        int holderIdentifier =  holder.identifier;
        rowHeightHandler.removeHolder(holder);
        int rowHeight = rowHeightHandler.getRowHeightForHorse(horsePosition);
        int identifier = weekTasksForAllHorses.getTasksForHorseInOneDay(horsePosition, dayOfWeek).getDayIentifier();
        //holder.dayTasksRecyclerView.setAdapter(taskAdapterHandler.getDaysAdapter(identifier));
        TasksAdapter tasksAdapter = new TasksAdapter(weekTasksForAllHorses.getTasksForHorseInOneDay(horsePosition, dayOfWeek), horsePosition, this);
        holder.setHeight(rowHeight);
        holder.identifier = identifier;
        holder.horsePosition = horsePosition;
        holder.dayTasksRecyclerView.setAdapter(tasksAdapter);
        rowHeightHandler.addHolder(holder);
    }

    @Override
    public int getItemCount() {
        return weekTasksForAllHorses.getHorsesCount() * TasksDashboard.DASHBOARD_PERIORD;
    }

    @Override
    public void onTasksCountChange(int horsePossition) {
        rowHeightHandler.updateHoldersHeight(horsePossition);
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder implements ResizableDashboardView {
        @BindView(R.id.one_day_recyclerView) RecyclerView dayTasksRecyclerView;
        @BindView(R.id.one_day_linearLayout) LinearLayout oneDayLinearLayout;
        int identifier = -1;
        int horsePosition = -1;
        Context context;

        DayViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
            dayTasksRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        @Override
        public void setHeight(int heightPx){
            ViewGroup.LayoutParams layoutParams = oneDayLinearLayout.getLayoutParams();
            if (layoutParams == null){
                layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightPx);
            }
            layoutParams.height = heightPx;
            oneDayLinearLayout.setLayoutParams(layoutParams);
        }

        public int getIdentifier() {
            return identifier;
        }

        public int getHorsePosition() {
            return horsePosition;
        }


    }
}
