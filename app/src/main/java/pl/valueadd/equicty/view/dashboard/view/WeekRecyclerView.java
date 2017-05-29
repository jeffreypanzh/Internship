package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by piotr on 11/05/17.
 */

public class WeekRecyclerView extends RecyclerView {


    public WeekRecyclerView(Context context) {
        super(context);
    }

    public WeekRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WeekRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_MOVE || ev.getAction() == MotionEvent.ACTION_SCROLL){
            return true;
        }
        return false;
    }
}
