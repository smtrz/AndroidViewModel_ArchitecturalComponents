package com.highbryds.shoppinglistforromania_mvvm.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.highbryds.shoppinglistforromania_mvvm.R;
import com.highbryds.shoppinglistforromania_mvvm.Room.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<ShoppingItem> mData= new ArrayList<>();
   // private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    public ShoppingListAdapter(Context context, List<ShoppingItem> data) {
       // this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }
    public void loadItems(List<ShoppingItem> newItems ) {
        mData = newItems;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shoppinglist_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShoppingItem item = mData.get(position);
        holder.item_name.setText(item.getProductName());
        holder.cat.setText(item.getCategoryName());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_name;
        TextView cat;
        ViewHolder(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item);
            cat = itemView.findViewById(R.id.cat);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ShoppingItem getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}