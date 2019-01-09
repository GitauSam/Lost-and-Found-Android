package com.zoatech.lostandfound.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zoatech.lostandfound.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        myViewPager.addFragment("Lost & Found", new LostnFoundFragment());
        myViewPager.addFragment("Profile", new ProfileFragment());
        viewPager.setAdapter(myViewPager);
    }

    public class MyViewPager extends FragmentPagerAdapter {

        ArrayList<String> fragmentTitle = new ArrayList<>();
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        private MyViewPager(FragmentManager fm) {
            super(fm);
        }

        private void addFragment(String title, Fragment fragment) {
            fragmentTitle.add(title);
            fragmentArrayList.add(fragment);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}
