package com.maac.zzzzzzzzzz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragmentPanelHolder extends Fragment {

    View view;
    View coloredBackgroundView;

    private static final String ARGUMENT_POSITION = "argument_position";

    public static HomeFragmentPanelHolder newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        HomeFragmentPanelHolder fragment = new HomeFragmentPanelHolder();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.suppose_activity_main, container, false);
        setupRecyclerView();

        return view;
    }


    @SuppressLint("SetTextI18n")
    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TextView tvDashBoard = view.findViewById(R.id.tv_dashboard);

        int position = getArguments().getInt(ARGUMENT_POSITION, -1);
        if (position == 0) {
//            tvDashBoard.setText(R.string.do_not_stop_believing);

        } else if (position == 1) {
//            tvDashBoard.setText(R.string.life_is_a_very_funny_proposition_after_all);
        } else if (position == 2) {
//            tvDashBoard.setText("Movies");
        } else if (position == 3) {
//            tvDashBoard.setText("Action");
        } else if (position == 4) {
//            tvDashBoard.setText("african");
        } else if (position == 5) {
//            tvDashBoard.setText("drama");
        } else if (position == 6) {
//            tvDashBoard.setText("korean");
        } else if (position == 7) {
//            tvDashBoard.setText("comedy");
        } else if (position == 8) {
//            tvDashBoard.setText("Nollywood");
        } else if (position == 9) {
//            tvDashBoard.setText("documentary");
        }


//        tvDashBoard.setText(position == 0 ? R.string.do_not_stop_believing : R.string.life_is_a_very_funny_proposition_after_all);
    }


    @SuppressLint("NewApi")
    private void setupRecyclerView() {
//        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);



        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalRecyclerAdapter adapter = new VerticalRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new HorizontalRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "click " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CategoryClick.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(), "long click " + position, Toast.LENGTH_SHORT).show();
            }
        });

//        PrimaryAdapter adapter = new PrimaryAdapter();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
//        // Let's use a grid with 2 columns.
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        populateRecyclerView(recyclerView);


//        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerviewforOverLapping);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
//        populateRecyclerView(recyclerView1);
//
//        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerviewforSecondRow);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//
//        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerviewforThirdRow);
//        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//
//        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerviewforFourthRow);
//        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));



//        View tabBar = view.findViewById(R.id.fake_tab);
        coloredBackgroundView = view.findViewById(R.id.colored_background_view);
//        View toolbarContainer = view.findViewById(R.id.toolbar_container);
        View toolbar = view.findViewById(R.id.toolbar);
//  todo
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                scrollColoredViewParallax(dy);
//            }
//
//
//        });
    }

    private void scrollColoredViewParallax(int dy) {
        if (coloredBackgroundView != null) {
            int absoluteTranslationY = (int) (coloredBackgroundView.getTranslationY() - dy * 0.2f);
            coloredBackgroundView.setTranslationY(Math.min(absoluteTranslationY, 0));

        }
    }

}












//    private void populateRecyclerView(RecyclerView recyclerView) {
//        recyclerView.setAdapter(new RecyclerView.Adapter() {
//
//            private final static int DUMMY_ITEM_COUNT = 1;
//
//            @Override
//            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
//                View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
//                return new TextHolder(itemView);
//            }
//
//            @Override
//            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
//                // We are too lazy for this by now ;-)
//            }
//
//            @Override
//            public int getItemCount() {
//                return DUMMY_ITEM_COUNT;
//            }
//
//
//            class TextHolder extends RecyclerView.ViewHolder {
//
//                public TextHolder(View itemView) {
//                    super(itemView);
//                }
//            }
//        });
//    }


