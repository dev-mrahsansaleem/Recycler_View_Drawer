package com.example.drawerandrecyclerview.ui.gallery;

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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.drawerandrecyclerview.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerview = root.findViewById(R.id.galleryRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,linearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        recyclerview.setAdapter(new Adapter(getContext(), items, circleImages));
        return root;
    }
}
