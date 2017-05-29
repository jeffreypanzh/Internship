package pl.valueadd.equicty.view.dashboard.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import butterknife.BindView;
import pl.valueadd.equicty.R;
import pl.valueadd.equicty.model.dashboard.Horse;
import pl.valueadd.equicty.view.BaseViewLinearLayout;
import pl.valueadd.equicty.view.dashboard.interfaces.ResizableDashboardView;

/**
 * Created by piotr on 19/05/17.
 */

public class DashboardHorseCell extends BaseViewLinearLayout implements ResizableDashboardView {

    @BindView(R.id.dashboard_horse_linearLayout) LinearLayout dashboardHorseLinearLayout;
    @BindView(R.id.dashboard_horse_name_textView) TextView dashboardHorseTextView;
    @BindView(R.id.dashboard_horse_picture_imageView) ImageView dashboardHorseImageView;

    int horsePosition = -1;
    private Horse mHorse;

    public DashboardHorseCell(Context context, Horse horse, int horsePosition) {
        super(context);
        this.mHorse = horse;
        this.horsePosition = horsePosition;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.dashboard_horse_itemview;
    }

    @Override
    public void setHeight(int heightPx){
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null){
            return;
        }
        layoutParams.height = heightPx;
        setLayoutParams(layoutParams);
        requestLayout();
    }

    @Override
    public int getHorsePosition() {
        return horsePosition;
    }
}
