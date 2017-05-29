package pl.valueadd.equicty.view.dashboard.view;

import android.support.v7.widget.RecyclerView;

/**
 * Created by piotr on 12/05/17.
 */

public class ScrollSynchronizer {

    private WeekRecyclerView weekRecyclerView ;
    private DashboardHorsesScrollView dashboardHorsesScrollView;

    public ScrollSynchronizer(WeekRecyclerView weekRecyclerView, DashboardHorsesScrollView dashboardHorsesScrollView) {
        this.weekRecyclerView = weekRecyclerView;
        this.dashboardHorsesScrollView = dashboardHorsesScrollView;
    }

    public void addListeners(){
        weekRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //horsesRecyclerView.onScrollStateChanged(newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mTotalScrolled += dy;
                centerHorsesRecyclerView();
            }
        });
    }

    private int mTotalScrolled = 0;
    public void centerHorsesRecyclerView(){
        //int actualWeekRecyclerView = weekRecyclerView.computeVerticalScrollOffset();
        dashboardHorsesScrollView.setScrollY(mTotalScrolled);
    }



}
