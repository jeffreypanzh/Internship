package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by piotr on 16/05/17.
 */

public class TouchPassingLinearLayout extends LinearLayout {
    public TouchPassingLinearLayout(Context context) {
        super(context);
    }

    public TouchPassingLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchPassingLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
/*        if (ev.getAction() == MotionEvent.ACTION_MOVE || ev.getAction() == MotionEvent.ACTION_SCROLL){
            return true;
        }*/
        return false;
    }
}
