package com.example.proj2;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.proj2.ClickListener;

import java.util.ArrayList;

public class otAdapter extends RecyclerView.Adapter<otAdapter.otViewHolder> {
    private ArrayList<String> mDataset;
    public static ClickListener listener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class otViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        // each data item is just a string in this case
        TextView textView;
        ClickListener clickListener = new ClickListener()
        {
            @Override
            public void onListClick(int adapterPosition, View v) {

            }

            @Override
            public void onListLongClick(int adapterPosition, View v) {

            }
        };
        public otViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.text);
        }

        @Override
        public void onClick(View v) {
            clickListener.onListClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onListLongClick(getAdapterPosition(), v);
            return false;
        }

        /**
         * Sets on click listener
         * @param clickListener
         */
        public void setOnItemClickListener(ClickListener clickListener) {
            this.clickListener = clickListener;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public otAdapter(ArrayList<String> myDataset, ClickListener listener) {
        this.listener = listener;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public otAdapter.otViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_man_item, parent, false);
        otViewHolder ot = new otViewHolder(v);
        ot.setOnItemClickListener(listener);
        return ot;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(otViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

