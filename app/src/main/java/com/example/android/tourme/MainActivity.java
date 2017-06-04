package com.example.android.tourme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the view pager that allows the user to navigate between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter to display the required fragment on each page.
        TourTypeAdapter typeAdapter = new TourTypeAdapter(this, getSupportFragmentManager());

        // Connect the adapter with the view pager.
        viewPager.setAdapter(typeAdapter);

        // Get the tab layout to show the tabs.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        // Connect the tab layout with the view pager object.
        tabLayout.setupWithViewPager(viewPager);

    }
}

