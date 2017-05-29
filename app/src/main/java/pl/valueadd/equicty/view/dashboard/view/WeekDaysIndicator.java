package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import pl.valueadd.equicty.view.dashboard.interfaces.ScrollListener;


/**
 * Created by piotr on 12/05/17.
 */

public class WeekDaysIndicator extends HorizontalScrollView {

    private ScrollListener scrollListener;

    public WeekDaysIndicator(Context context) {
        super(context);
    }

    public WeekDaysIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeekDaysIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        scrollListener.onScroll();
    }


}
