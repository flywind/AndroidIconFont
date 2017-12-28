package com.uxdpen.library.iconfont;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
/**
 * Created by Flywind on 2017/12/28.
 * http://www.uxdpen.com
 */
public class IconTextView extends AppCompatTextView {

    /**
     * @param context context passed
     * @param attrs attributes in xml
     */
    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     * @param defStyleAttr style attributes
     */
    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     */
    public IconTextView(Context context) {
        super(context);
        setTypeface(IconFont.getTypeface(context));
    }
}
