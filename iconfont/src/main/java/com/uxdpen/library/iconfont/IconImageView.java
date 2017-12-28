package com.uxdpen.library.iconfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Dimension;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
/**
 * Created by Flywind on 2017/12/28.
 * http://www.uxdpen.com
 */

public class IconImageView extends android.support.v7.widget.AppCompatImageView {

    /**
     * @param context context passed
     */
    public IconImageView(Context context) {
        super(context);
        init(context,null,0,0);
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     */
    public IconImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0,0);
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     * @param defStyleAttr style attributes
     */
    public IconImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr,0);
    }

    /**
     * @param context context passed
     * @param attrs attributes in xml
     * @param defStyleAttr style attributes
     * @param defStyleRes style resource
     * init function to avoid repetition
     */
    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconTextDrawable,defStyleAttr,defStyleRes);
        try{
            String text = typedArray.getString(R.styleable.IconTextDrawable_text);
            Float textSize = typedArray.getDimension(R.styleable.IconTextDrawable_textSize,14);
            int textColor = typedArray.getColor(R.styleable.IconTextDrawable_textColor, ContextCompat.getColor(context,R.color.primary_icon_color));
            TextDrawable textDrawable = new TextDrawable(context);
            textDrawable.setText(text);
            if (textColor!=0)
                textDrawable.setTextColor(textColor);
            else
                textDrawable.setTextColor(new TextView(context).getTextColors());
            textDrawable.setTextSize(Dimension.SP,textSize);
            textDrawable.setTypeface(IconFont.getTypeface(context));
            setImageDrawable(textDrawable);
        }finally {
            typedArray.recycle();
        }
    }

    /**
     * @param iconText FontAwesome icon text
     */
    public void setIcon(String iconText){
        setIcon(iconText,0,0);
    }

    /**
     * @param iconText FontAwesome icon text
     * @param iconSizeSP set icon size
     */
    public void setIcon(String iconText, float iconSizeSP){
        setIcon(iconText,iconSizeSP,0);
    }

    /**
     * @param iconText FontAwesome icon text
     * @param iconColorRes set color to icon
     */
    public void setIcon(String iconText, int iconColorRes){
        setIcon(iconText,0,iconColorRes);
    }

    /**
     * @param iconText FontAwesome icon text
     * @param iconColorRes set color to icon
     * @param iconSizeSP set icon size
     */
    public void setIcon(String iconText, float iconSizeSP, int iconColorRes){
        TextDrawable textDrawable = new TextDrawable(getContext());
        textDrawable.setText(iconText);
        if (iconColorRes != 0) {
            textDrawable.setTextColor(iconColorRes);
        }else {
            textDrawable.setTextColor(new TextView(getContext()).getTextColors());
        }
        if (iconSizeSP != 0){
            textDrawable.setTextSize(TypedValue.COMPLEX_UNIT_SP,iconSizeSP);
        }
        textDrawable.setTypeface(IconFont.getTypeface(getContext()));
        setImageDrawable(textDrawable);
    }
}
