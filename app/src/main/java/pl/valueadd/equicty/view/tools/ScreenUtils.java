package pl.valueadd.equicty.view.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by piotr on 29/05/17.
 */

public class ScreenUtils {

    public static int convertDpToPx(Context context, int dp){
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return Math.round(px);
    }
}
