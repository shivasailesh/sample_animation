package com.example.animation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    int[] images;

    public MainAdapter(int[] images) {
        this.images = images;

    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);
    return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.imageView.setBackgroundResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class viewHolder  extends RecyclerView.ViewHolder{

          ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_view);
        }
    }
}
