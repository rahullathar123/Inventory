package com.example.rahul.inventory;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rahul on 2017-12-26.
 */

public class InventorAdapter extends RecyclerView.Adapter<InventorAdapter.ViewHolder> {

    private ArrayList<Inventory> inventories;
    private LayoutInflater  mInFlater;


    public InventorAdapter(Context context, ArrayList<Inventory> inventories1) {
       this.mInFlater = LayoutInflater.from(context);
        this.inventories = inventories1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Inventory inventory = inventories.get(position);
        holder.price.setText((int) inventory.getPrice());
        holder.productName.setText(inventory.getName());
        holder.quantity.setText((int) inventory.getQuantity());
    }

    @Override
    public int getItemCount() {
        return inventories != null ? inventories.size(): 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView productName,price,quantity;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.displayproduct);
            price = itemView.findViewById(R.id.displayprice);
            quantity = itemView.findViewById(R.id.displayQuantity);
        }
    }

}
