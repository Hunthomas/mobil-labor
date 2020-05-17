package aut.bme.hu.boredapp.ui.list;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aut.bme.hu.boredapp.R;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.ui.details.DetailsActivity;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    private ListScreen screen;
    private List<BoredActivity> dataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ActivityViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public int key;
        public TextView activityNameTv;
        public TextView activityTypeTv;
        public ActivityViewHolder(View row) {
            super(row);
            this.activityNameTv = row.findViewById(R.id.activityListRowTitleTv);
            this.activityTypeTv = row.findViewById(R.id.activityListRowTypeTv);

            itemView.setOnClickListener(v -> {
                screen.showDetails(key);
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActivityAdapter(ListScreen screen, List<BoredActivity> activities) {
        dataset = activities;
        this.screen = screen;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActivityAdapter.ActivityViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_row, parent, false);
        ActivityViewHolder vh = new ActivityViewHolder(row);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        BoredActivity item = dataset.get(position);
        holder.key = item.getKey();
        holder.activityNameTv.setText(item.getActivity());
        holder.activityTypeTv.setText(item.getType());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void deleteItem(int position){
        screen.deleteActivity(dataset.get(position).getKey());
        dataset.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
