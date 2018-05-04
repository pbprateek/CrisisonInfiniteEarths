package com.aikya.rnsit.crisisoninfiniteearths;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter  extends RecyclerView.Adapter<ImageViewHolder> {

    private List<CodeAndImage> list = new ArrayList<>();
    private Callback callback;



    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_gallery, parent, false);
        return new ImageViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.itemView.setClickable(true);
        holder.bindData(getItemByPosition(position));
    }

    public CodeAndImage getItemByPosition(int position) {
        return list.get(position);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setList(List<CodeAndImage> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public interface Callback {
        void onItemClick(View view, int position);
    }
}
