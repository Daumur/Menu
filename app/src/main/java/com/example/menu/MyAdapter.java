package com.example.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Chiens> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtage;
        public TextView txtrace;
        public ImageView txtImage;

        public ViewHolder(View v) {
            super(v);
            txtImage = v.findViewById(R.id.item_image);
            txtHeader = v.findViewById(R.id.item_titre);
            txtage = v.findViewById(R.id.item_age);
            txtrace = v.findViewById(R.id.item_race);
        }
    }

    public void add(int position, Chiens item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<Chiens> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Chiens chien = values.get(position);
        Picasso.get().load(chien.getImgURL()).into(holder.txtImage);
        holder.txtHeader.setText("Nom : " +chien.getName());
        holder.txtage.setText("Age : " +chien.getage());
        holder.txtrace.setText("Race : " +chien.getrace());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}