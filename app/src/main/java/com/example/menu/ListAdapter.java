package com.example.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter{


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Data.title.length;
    }

    private class ListViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mItemText;
        private ImageView mImageView;

        public ListViewHolder(View itemView) {

            super(itemView);
            mItemText = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position) {
            mItemText.setText(Data.title[position]);
            mImageView.setImageResource(Data.picturePath[position]);
        }

        public void onClick (View view) {

        }
    }
}
