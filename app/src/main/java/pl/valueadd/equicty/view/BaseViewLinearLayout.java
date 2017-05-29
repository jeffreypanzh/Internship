package pl.valueadd.equicty.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * Created by piotr on 29/05/17.
 */

public abstract class BaseViewLinearLayout extends LinearLayout {

    protected AttributeSet mAttributeSet;

    public BaseViewLinearLayout(Context context) {
        super(context);
        attachView(getLayoutResource());
    }

    public BaseViewLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAttributeSet = attrs;
        attachView(getLayoutResource());
    }

    public BaseViewLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAttributeSet = attrs;
        attachView(getLayoutResource());
    }

    protected void attachView(int resId) {
        ViewGroup mContent = new RelativeLayout(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(resId, mContent);
        addView(mContent);
        bindViews();
    }

    private void bindViews(){
        ButterKnife.bind(this);
    }

    protected abstract @LayoutRes
    int getLayoutResource();

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return super.onTouchEvent(event);
    }

}