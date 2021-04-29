package com.suningstudio.DisableSwipingLTRViewPager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    LockableViewPager lockableViewPager;
    MyPagerAdapter myPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lockableViewPager = findViewById(R.id.lookable_viewpager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        lockableViewPager.setAdapter(myPagerAdapter);
        lockableViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position == 1){
                    lockableViewPager.setAllowedSwipeDirection(LockableViewPager.SwipeDirection.RIGHT);
                }else if (position > 1){
                    lockableViewPager.setAllowedSwipeDirection(LockableViewPager.SwipeDirection.BOTH);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}