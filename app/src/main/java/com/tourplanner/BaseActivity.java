package com.tourplanner;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.os.Bundle;
import java.lang.reflect.Constructor;


public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    protected FrameLayout mContentFrame;
    protected int selectedNavItmId;

    protected void setUpToolbar() {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(R.drawable.ic_drawer);
            setSupportActionBar(mToolbar);
        }
    }

    protected void setUpNavDrawer() {
        if (mToolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
    }

   // protected abstract void setupNavMenu();


    protected void setupNavMenu() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Intent i = null;
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.navigation_main : {
                        i = new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("selectedMenu",R.id.navigation_main);
                        startActivity(i);
                        break;
                    }
                    case R.id.navigation_tours : {
                        i = new Intent(getApplicationContext(),TourActivity.class);
                        i.putExtra("selectedMenu",R.id.navigation_tours);
                        startActivity(i);
                        break;
                    }
                    case R.id.navigation_settings :{
                        i = new Intent(getApplicationContext(),SettingsActivity.class);
                        i.putExtra("selectedMenu",R.id.navigation_settings);
                        startActivity(i);
                        break;
                    }
                    case R.id.navigation_attractions: {
                        i = new Intent(getApplicationContext(), AttractionsActivity.class);
                        i.putExtra("selectedMenu", R.id.navigation_attractions);
                        startActivity(i);
                        break;
                    }
                    default : {
                        break;
                    }
                }
                return true;
            }});
    }


    protected void setSelectedNavItmId(int defaultNavItmId){
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null && bundle.containsKey("selectedMenu"))
            selectedNavItmId = bundle.getInt("selectedMenu");
        else
            selectedNavItmId = defaultNavItmId;

        if(mNavigationView.getMenu().findItem(selectedNavItmId) != null)
            mNavigationView.getMenu().findItem(selectedNavItmId).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
