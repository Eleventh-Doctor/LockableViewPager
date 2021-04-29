package com.suningstudio.DisableSwipingLTRViewPager2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class LockableViewPager extends ViewPager {

    float initialXValue = 0f;
    // Hướng vuốt
    SwipeDirection direction;

    public LockableViewPager(@NonNull Context context) {
        super(context);
        direction = SwipeDirection.BOTH;
    }

    public LockableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        direction = SwipeDirection.BOTH;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isSwipeAllowed(ev)) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isSwipeAllowed(ev)) {
          return super.onTouchEvent(ev);
        }
        return false; // Không xử lý sự kiện vuốt
    }

    enum SwipeDirection {
        // Vuốt theo cả hai hướng
        BOTH,
        // Bên trái (từ phải sang trái)
        LEFT,
        // Bên phải (từ trái sang phải)
        RIGHT,
        // Không hướng nào cả
        NONE
    }

    // Kiểm tra hướng vuốt
    private boolean isSwipeAllowed(MotionEvent event) {
        if (direction == SwipeDirection.BOTH) {
            return true;
        } else if (direction == SwipeDirection.NONE) {
            return false;
        }
        // Khi người dùng chạm tay xuống
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initialXValue = event.getX();
            return true;
        }
        // Khi người dùng tiến hành di chuyển
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            try {
                float displacement = event.getX() - initialXValue;
                if (displacement > 0 && direction == SwipeDirection.RIGHT) {
                    // Người dùng đang vuốt từ trái sang phải
                    return false;
                } else if (displacement < 0 && direction == SwipeDirection.LEFT) {
                    // Người dùng đang vuốt từ phải sang trái
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    // Set hướng vuốt muốn cho phép
    public void setAllowedSwipeDirection(SwipeDirection swipeDirection) {
        this.direction = swipeDirection;
    }
}
