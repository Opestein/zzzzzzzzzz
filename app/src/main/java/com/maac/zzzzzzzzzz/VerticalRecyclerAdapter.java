package com.maac.zzzzzzzzzz;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Jeffrey Liu on 3/21/16.
 */
public class VerticalRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//    private ArrayList<ArrayList<Integer>> mList;
    private SparseIntArray listPosition = new SparseIntArray();
    private HorizontalRecyclerAdapter.OnItemClickListener mItemClickListener;
    private Context mContext;

//    public VerticalRecyclerAdapter(ArrayList<ArrayList<Integer>> list) {
//        this.mList = list;
//    }

    public VerticalRecyclerAdapter() {
    }

    private class CellViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        View view;
        private RecyclerView mRecyclerView;
        private HorizontalRecyclerAdapter adapter;
        private LinearLayoutManager layoutManager;

        public CellViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.theOverLappingTextView);

            view = itemView.findViewById(R.id.viewBackground);


            mRecyclerView = itemView.findViewById(R.id.recyclerviewforOverLapping);


            mRecyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(layoutManager);


            adapter = new HorizontalRecyclerAdapter();
            adapter.SetOnItemClickListener(mItemClickListener);
            mRecyclerView.setAdapter(adapter);


            // this is needed if you are working with CollapsingToolbarLayout, I am adding this here just in case I forget.
            mRecyclerView.setNestedScrollingEnabled(false);

            //optional
            StartSnapHelper snapHelper = new StartSnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerView);
        }


    }


    public void setMargins(View view, int left, int top, int right, int bottom){
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams){
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        mContext = viewGroup.getContext();
//        I think the switch statement is not necessary
//        switch (viewType) {
//            default: {
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
                return new CellViewHolder(v1);
//            }
//        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;

        switch (position) {
            case 0:
                cellViewHolder.textView.setText("Popular Movies");
                setMargins(cellViewHolder.view, 0,450,0,0);
                break;
                case 1:
                cellViewHolder.textView.setText("Popular Tv");
//                    cellViewHolder.view.setPadding(0,0,0,0);

                    break;
            case 2:
                cellViewHolder.textView.setText("Popular Comedy");
//                cellViewHolder.view.setPadding(0,0,0,0);

                break;
            case 3:
                cellViewHolder.textView.setText("Popular Cartoon");
//                cellViewHolder.view.setPadding(0,0,0,0);

                break;
            case 4:
                cellViewHolder.textView.setText("Popular Series");
//                cellViewHolder.view.setPadding(0,0,0,0);

                break;
            default: {
//                CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;
//                cellViewHolder.textView.setText("Default");


//         if new item is added to list, it automatically scrolls to the top screen, scrollToPositionWithOffSet
                int lastSeenFirstPosition = listPosition.get(position, 0);
                if (lastSeenFirstPosition >= 0) {
                    cellViewHolder.layoutManager.scrollToPositionWithOffset(lastSeenFirstPosition, 0);
                }
                break;
            }
        }
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        final int position = viewHolder.getAdapterPosition();
        CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;
        int firstVisiblePosition = cellViewHolder.layoutManager.findFirstVisibleItemPosition();
        listPosition.put(position, firstVisiblePosition);

        super.onViewRecycled(viewHolder);
    }


    @Override
    public int getItemCount() {
//        if (mList == null)
//            return 0;
        return 5;
    }


    // for both short and long click
    public void SetOnItemClickListener(final HorizontalRecyclerAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}