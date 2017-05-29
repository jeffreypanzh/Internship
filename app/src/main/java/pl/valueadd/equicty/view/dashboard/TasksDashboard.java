package pl.valueadd.equicty.view.dashboard;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;



import butterknife.BindView;
import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.FakeDataGenerator;
import pl.valueadd.equicty.model.dashboard.WeekTasksForAllHorses;
import pl.valueadd.equicty.view.BaseViewLinearLayout;
import pl.valueadd.equicty.view.dashboard.adapter.DaysAdapter;
import pl.valueadd.equicty.view.dashboard.rowheighthandler.RowHeightHandler;
import pl.valueadd.equicty.view.dashboard.view.DashboardHorsesScrollView;
import pl.valueadd.equicty.view.dashboard.view.ScrollSynchronizer;
import pl.valueadd.equicty.view.dashboard.view.TouchPassingHorizontalScrollView;
import pl.valueadd.equicty.view.dashboard.view.WeekRecyclerView;

/**
 * Created by piotr on 08/05/17.
 */

public class TasksDashboard extends BaseViewLinearLayout {

    public static final int DASHBOARD_PERIORD = 7;

    @BindView(R.id.days_recyclerView) WeekRecyclerView daysRecyclerView;
    @BindView(R.id.scrollViewDash) TouchPassingHorizontalScrollView scrollView;
    @BindView(R.id.dashboard_horses_dashboardHorsesScrollView) DashboardHorsesScrollView dashboardHorsesScrollView;

    WeekTasksForAllHorses weekTasksForAllHorses = FakeDataGenerator.getWeekTasksForAllHorses();
    ScrollSynchronizer scrollSynchronizer;

    public TasksDashboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTasksDashboard();
    }

    public TasksDashboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTasksDashboard();
    }

/*
    @OnClick(R.id.viewsa)
    public void onClick(){
        daysRecyclerView.invalidate();
    }
*/

    @Override
    protected int getLayoutResource() {
        return R.layout.tasks_dashboard;
    }

    private void setupTasksDashboard(){
        scrollSynchronizer = new ScrollSynchronizer(daysRecyclerView, dashboardHorsesScrollView);
        scrollSynchronizer.addListeners();
        setupDaysRecyclerView();
        setupHorsesRecyclerView();
        scrollView.setTouchToParentSendingDisabledRecyclerView(daysRecyclerView);
        setWeekTasksForAllHorses(weekTasksForAllHorses);
    }

    private void setupDaysRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 7, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        daysRecyclerView.setLayoutManager(gridLayoutManager);
        daysRecyclerView.setItemViewCacheSize(20*7*2);
        daysRecyclerView.setDrawingCacheEnabled(true);
        daysRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    private void setupHorsesRecyclerView(){
       /* LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        dashboardHorsesRecyclerView.setLayoutManager(linearLayoutManager);
        daysRecyclerView.setItemViewCacheSize(20);
        daysRecyclerView.setDrawingCacheEnabled(true);
        daysRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_AUTO);*/
    }

    public void setWeekTasksForAllHorses(WeekTasksForAllHorses weekTasksForAllHorses){
        RowHeightHandler rowHeightHandler = new RowHeightHandler(weekTasksForAllHorses, getContext());
        DaysAdapter daysAdapter = new DaysAdapter(getContext(), weekTasksForAllHorses, rowHeightHandler);
        daysRecyclerView.setAdapter(daysAdapter);
        dashboardHorsesScrollView.setHorses(weekTasksForAllHorses.getAllHorses(), rowHeightHandler);

    }

}
