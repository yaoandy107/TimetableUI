package me.yaoandy107.ntut_timetable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;

/**
 * Created by blackmaple on 2017/5/9.
 */

public class CourseBlock extends AppCompatTextView {

    public CourseBlock(Context context) {
        super(context);
        setTextColor(Color.BLACK);
        setGravity(Gravity.CENTER);
        setPadding(2, 0, 2, 0);
    }

    @Override
    public void setBackgroundColor(int color) {
        StateListDrawable background_drawable = new StateListDrawable();
        background_drawable.addState(
                new int[]{android.R.attr.state_pressed}, new ColorDrawable(
                        getResources().getColor(R.color.silver)));
        background_drawable.addState(
                new int[]{android.R.attr.state_enabled}, new ColorDrawable(
                        color));
        setBackgroundDrawable(background_drawable);
        setTextColor(pickTextColorBasedOnBgColorSimple(color, Color.WHITE, Color.BLACK));
    }

    public void resetBlock() {
        setText(null);
        setTag(null);
        super.setBackgroundColor(Color.TRANSPARENT);
        setOnClickListener(null);
    }

    public static int pickTextColorBasedOnBgColorSimple(int bgColor, int lightColor, int darkColor) {
        String color = String.format("#%06X", (0xFFFFFF & bgColor));
        color = color.substring(1, 7);
        int r = Integer.parseInt(color.substring(0, 2), 16); // hexToR
        int g = Integer.parseInt(color.substring(2, 4), 16); // hexToG
        int b = Integer.parseInt(color.substring(4, 6), 16); // hexToB
        return (((r * 0.299) + (g * 0.587) + (b * 0.114)) > 186) ?
                darkColor : lightColor;
    }
}
