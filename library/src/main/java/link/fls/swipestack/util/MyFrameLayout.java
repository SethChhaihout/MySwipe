package link.fls.swipestack.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MyFrameLayout extends FrameLayout {
    float initY=0;
    float intX=0;
    float distanceX=0;
    float distanceY=0;

    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                intX = ev.getRawX();
                initY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                distanceX = Math.abs(ev.getRawX()-intX);
                distanceY = Math.abs(ev.getRawY()-initY);
                Log.d("Swipe", "onInterceptTouchEvent: "+distanceX+","+distanceY);

                if(distanceY>distanceX/2){
                    return false;
                }if(distanceX > distanceY *2){
                    return true;
                }
        }
        return false;
    }
}
