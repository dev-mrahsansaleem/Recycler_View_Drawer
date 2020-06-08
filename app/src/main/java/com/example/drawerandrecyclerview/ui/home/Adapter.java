package com.example.drawerandrecyclerview.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drawerandrecyclerview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String[] text;
    int[] images;
    String[] cicleImages;

    public Adapter(Context context, String[] text, int[] images, String[] cicleImages) {
        this.context = context;
        this.text = text;
        this.images = images;
        this.cicleImages = cicleImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(text[position]);
        Glide.with(context).asBitmap().load(cicleImages[position]).into(holder.circleImageView);
        holder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return cicleImages.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CircleImageView circleImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.cicleImage);
        }
    }
}
