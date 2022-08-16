package com.example.smusicplayer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smusicplayer.R;
import com.example.smusicplayer.databinding.FragmentHomeBinding;
import com.example.smusicplayer.ui.RecyclerViewAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;

    RecyclerViewAdapter mAdapter;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ConstraintLayout constraintLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final SearchView searchView = binding.textSearch;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), searchView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView1= view.findViewById(R.id.song_recyclerView);
        recyclerView2= view.findViewById(R.id.artist_recyclerView);
        constraintLayout = view.findViewById(R.id.coordinatorLayout);
        populateRecyclerView();

    }

    private void populateRecyclerView() {

        for (int i=0;i<5;i++) {
            stringArrayList.add("Sandip");
        }
        mAdapter = new RecyclerViewAdapter(stringArrayList);
        recyclerView1.setAdapter(mAdapter);
        recyclerView2.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}