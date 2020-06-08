package com.example.drawerandrecyclerview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.drawerandrecyclerview.R;
import com.example.drawerandrecyclerview.ui.slideshow.SlideshowFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerview;
    private String[] items = {"tem", "tem1", "tem2", "tem3", "tem4", "tem5", "tem6", "tem7", "tem", "tem1", "tem2", "tem3", "tem4", "tem5", "tem6", "tem7", "tem", "tem1", "tem2", "tem3", "tem4", "tem5", "tem6", "tem7", "tem"};
    private String[] circleImages = {
            "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"
    };
    private int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);


            }
        });
        recyclerview = root.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
        recyclerview.setAdapter(new Adapter(getContext(), items, images, circleImages));
        return root;
    }

}
