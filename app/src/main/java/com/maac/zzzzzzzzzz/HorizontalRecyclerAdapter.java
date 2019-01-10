package com.maac.zzzzzzzzzz;


import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Jeffrey Liu on 3/21/16.
 */
public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Integer> mList;
    private OnItemClickListener mItemClickListener;

    public HorizontalRecyclerAdapter() {
    }


//    USE THIS METHOD IF YOU WANT TO GET THE DATA U WANT TO DISPLAY FROM THE PRIMARY OR VERTICAL ADAPTER
//    public void updateList(ArrayList<Integer> list) {
//        this.mList = list;
//        notifyDataSetChanged();
//    }


    private class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView textView;
        private ImageView imageView;

        public CellViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.cardTextView);
            imageView = itemView.findViewById(R.id.cardImageView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemLongClick(view, getLayoutPosition());
                return true;
            }
            return false;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            default: {
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row_item, viewGroup, false);
                return new CellViewHolder(v1);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;

        switch (position) {
            case 0:
                cellViewHolder.textView.setText("Avengers");
                cellViewHolder.imageView.setImageResource(R.drawable.ic_avengers);

                break;

            case 1:
                cellViewHolder.textView.setText("Avengers");
                cellViewHolder.imageView.setImageResource(R.drawable.ic_avengers);

                break;
            case 2:
                cellViewHolder.textView.setText("Avengers");
                cellViewHolder.imageView.setImageResource(R.drawable.ic_avengers);

                break;
            case 3:
                cellViewHolder.textView.setText("Avengers");
                cellViewHolder.imageView.setImageResource(R.drawable.ic_avengers);

                break;
            default: {
//                CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;
                cellViewHolder.textView.setText("Avengers");
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
//        if (mList == null)
//            return 0;
        return 20;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    // for both short and long click
    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}