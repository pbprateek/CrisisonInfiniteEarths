package com.aikya.rnsit.crisisoninfiniteearths;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private  ImageView ImageView;
    private GalleryAdapter.Callback callback;
    private Context context;
    public ImageViewHolder(View itemView, final GalleryAdapter.Callback callback) {
        super(itemView);

        this.callback = callback;
        this.context = itemView.getContext();
        ImageView = itemView.findViewById(R.id.item_image_view);
        if (callback != null) {
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        callback.onItemClick(v, position);
                    }
                }
            });
        }
    }

    public void bindData(CodeAndImage codeAndImage) {
        Picasso.get().load(codeAndImage.getImage()).resize(400,400).into(ImageView);
    }
}
