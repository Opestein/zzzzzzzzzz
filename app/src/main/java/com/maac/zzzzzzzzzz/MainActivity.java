package com.maac.zzzzzzzzzz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    private DrawerLayout drawer;
    private ViewPager viewPager;
//    private BottomNavigationView navigation;
    private Toolbar toolbar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snack_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_show_snack_bar:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.view_pager);
//        This Adapter Class is at the bottom of this Class
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);


        bindNavigationDrawer();
    }


    private void bindNavigationDrawer() {


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    viewPager.setCurrentItem(0);
                } else if (id == R.id.navigation_feed) {
                    viewPager.setCurrentItem(1);
                } else if (id == R.id.navigation_live) {
                    viewPager.setCurrentItem(2);
                } else if (id == R.id.navigation_kids) {
                    viewPager.setCurrentItem(3);
                }
                else if (id == R.id.navigation_more) {
                    viewPager.setCurrentItem(4);
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }


        });
    }





















    private static class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HomeFragment.newInstance();
                case 1:
                    return FeedsFragment.newInstance();
                case 2:
                    return LiveFragment.newInstance();
                case 3:
                    return KidsFragment.newInstance();
                case 4:
                    return MoreFragment.newInstance();


            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
