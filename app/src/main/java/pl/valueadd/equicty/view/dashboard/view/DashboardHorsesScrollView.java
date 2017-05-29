package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.List;

import butterknife.BindView;
import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.Horse;
import pl.valueadd.equicty.view.BaseViewLinearLayout;
import pl.valueadd.equicty.view.dashboard.rowheighthandler.RowHeightHandler;
import pl.valueadd.equicty.view.tools.ScreenUtils;

/**
 * Created by piotr on 19/05/17.
 */

public class DashboardHorsesScrollView extends BaseViewLinearLayout {

    @BindView(R.id.dashboard_horses_scrollView)
    ScrollView horsesScrollView;
    @BindView(R.id.dashboard_horses_linearLayout)
    LinearLayout horsesLinearLayout;

    public DashboardHorsesScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DashboardHorsesScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.dashboard_horses_scrollview_layout;
    }

    public void setHorses(List<Horse> horses, RowHeightHandler rowHeightHandler){
        removeAllHorses(rowHeightHandler);
        for (int i = 0; i < horses.size(); i++) {
            addHorse(horses.get(i), rowHeightHandler, i);
        }
    }

    private void removeAllHorses(RowHeightHandler rowHeightHandler){
        for (int i = 0; i < horsesLinearLayout.getChildCount(); i++){
            rowHeightHandler.removeHolder((DashboardHorseCell) horsesLinearLayout.getChildAt(i));
        }
        horsesLinearLayout.removeAllViews();
    }

    private void addHorse(Horse horse, RowHeightHandler rowHeightHandler, int horsePosition){
        DashboardHorseCell dashboardHorseCell = new DashboardHorseCell(getContext(), horse, horsePosition);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getLayoutParams().width, rowHeightHandler.getRowHeightForHorse(horsePosition));
        layoutParams.setMargins(0, ScreenUtils.convertDpToPx(getContext(), 2), 0 ,ScreenUtils.convertDpToPx(getContext(), 2));
        dashboardHorseCell.setLayoutParams(layoutParams);
//        dashboardHorseCell.getLayoutParams().width = getLayoutParams().width;
        horsesLinearLayout.addView(dashboardHorseCell);
        rowHeightHandler.addHolder(dashboardHorseCell);
    }

    public void setScrollY(int y){
        horsesScrollView.setScrollY(y);
    }
}
