package com.example.prm392.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prm392.R;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder> {

    private List<Object> imageSources;  // Sửa thành Object để chứa cả String và Integer
    private Context context;

    public ImageSliderAdapter(Context context, List<Object> imageSources) {
        this.context = context;
        this.imageSources = imageSources;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Object source = imageSources.get(position);

        if (source instanceof String) {
            Glide.with(context)
                    .load((String) source)
                    .placeholder(R.drawable.product_default)
                    .into(holder.imageView);
        } else if (source instanceof Integer) {
            Glide.with(context)
                    .load((Integer) source)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return imageSources.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
