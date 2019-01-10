package com.maac.zzzzzzzzzz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class CategoryClick extends AppCompatActivity {

    private DrawerLayout drawer;
    private ViewPager viewPager;
    //    private BottomNavigationView navigation;
    private Toolbar toolbar;

    RecyclerView mRecyclerView;

    LinearLayoutManager layoutManager;

    HorizontalRecyclerAdapter adapter;

    private HorizontalRecyclerAdapter.OnItemClickListener mItemClickListener;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_click);
        toolbar = findViewById(R.id.toolbarInner);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerviewrecommeded);

        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new HorizontalRecyclerAdapter();
        adapter.SetOnItemClickListener(mItemClickListener);
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snack_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
