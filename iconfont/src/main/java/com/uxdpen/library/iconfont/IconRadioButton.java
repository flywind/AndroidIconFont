package com.uxdpen.library.iconfont;

import android.content.Context;
import android.util.AttributeSet;
/**
 * Created by Flywind on 2017/12/28.
 * http://www.uxdpen.com
 */

public class IconRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    /**
     * @param context context passed
     */
    public IconRadioButton(Context context) {
        super(context);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     */
    public IconRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(IconFont.getTypeface(context));
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     * @param defStyleAttr style attributes
     */
    public IconRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(IconFont.getTypeface(context));
    }

}
