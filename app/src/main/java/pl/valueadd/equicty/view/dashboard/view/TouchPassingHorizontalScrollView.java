package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import pl.valueadd.equicty.view.dashboard.interfaces.ScrollListener;


/**
 * Created by piotr on 11/05/17.
 */

public class TouchPassingHorizontalScrollView extends HorizontalScrollView {

    private WeekRecyclerView mWeekRecyclerView;
    private ScrollListener scrollListener;


    public TouchPassingHorizontalScrollView(Context context) {
        super(context);
    }

    public TouchPassingHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchPassingHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setTouchToParentSendingDisabledRecyclerView(WeekRecyclerView weekRecyclerView) {
        this.mWeekRecyclerView = weekRecyclerView;
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //scrollListener.onScroll();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        mWeekRecyclerView.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_SCROLL){
            return true;
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        super.onInterceptTouchEvent(event);
        mWeekRecyclerView.onInterceptTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_SCROLL){
            return true;
        }
        return false;
    }


}