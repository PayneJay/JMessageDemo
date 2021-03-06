package jack.jmessage.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage.widget
 * author: PayneJay
 * date: 2018/7/20.
 */

public class ImgBrowserViewPager extends ViewPager {
    public ImgBrowserViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
