package com.pokidin.a.demostore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item.Result> mItems;

    public ItemAdapter(List<Item.Result> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item.Result item = mItems.get(position);
        holder.titleItem.setText(item.getTitle());
        holder.imageItem.setBackgroundResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        if (mItems == null) {
            return 0;
        } else {
            return mItems.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageItem;
        TextView titleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.imgItem);
            titleItem = itemView.findViewById(R.id.tvTitle);
        }
    }
}
