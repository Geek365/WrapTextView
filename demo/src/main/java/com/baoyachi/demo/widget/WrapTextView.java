package com.baoyachi.demo.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 日期：16/6/5 21:37
 * <p/>
 * 描述：
 */
public class WrapTextView extends TextView
{
    public WrapTextView(Context context)
    {
        super(context);
    }

    public WrapTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public WrapTextView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WrapTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    SizeChangeListener l;

    public void setSizeChangeListener(SizeChangeListener orlExt) {
        l = orlExt;
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        l.sizeChanged(w, h, oldw, oldh);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public interface SizeChangeListener {
        public void sizeChanged(int w, int h, int oldw, int oldh);
    }
}
