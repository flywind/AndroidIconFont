package com.uxdpen.library.iconfont;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
/**
 * Created by Flywind on 2017/12/28.
 * http://www.uxdpen.com
 */

public class IconAutoCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView {

    /**
     * @param context context passed
     */
    public IconAutoCompleteTextView(Context context) {
        super(context);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     */
    public IconAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     * @param defStyleAttr style attributes
     */
    public IconAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(IconFont.getTypeface(context));
    }
}
