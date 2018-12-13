package com.secondwork.redrock.lv2demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tl;
    private ViewPager vp;
    private List<String> tabs;
    private List<Fragment>  fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        initDatas();
        initViewPager();
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(MainActivity.this,"这是第"+(i+1)+"个页面",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        initTablayout();
    }

    private void initDatas(){
        tabs = new ArrayList<>();
        for(int i=1;i<=30;i++)
            tabs.add("第"+i+"页");
        fragments = new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++) {
            Context context = getBaseContext();
            int id = context.getResources().getIdentifier("a"+(i+1),"drawable", context.getPackageName());
            fragments.add(TabFragment.newInstance(i,id));
        }

    }

    private void initViewPager(){
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void initTablayout(){
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setupWithViewPager(vp);
        for(int i=0;i<tabs.size();i++){
            TabLayout.Tab tab = tl.getTabAt(i);
            TextView tv =(TextView) LayoutInflater.from(this).inflate(R.layout.tab_view,tl,false);
            tv.setText(tabs.get(i));
            assert tab != null;
            tab.setCustomView(tv);
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
