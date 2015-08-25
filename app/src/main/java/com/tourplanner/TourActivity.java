package com.tourplanner;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;


public class TourActivity extends BaseActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Tour Activity");
        setUpToolbar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mContentFrame = (FrameLayout) findViewById(R.id.nav_contentframe);
        textView = (TextView)mContentFrame.findViewById(R.id.enterprise_name);

        setupNavMenu();

        setUpNavDrawer();
        setSelectedNavItmId(R.id.navigation_tours);
    }//onCreate

    @Override
    protected void onResume() {
        super.onResume();
        setSelectedNavItmId(R.id.navigation_tours);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tour, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
