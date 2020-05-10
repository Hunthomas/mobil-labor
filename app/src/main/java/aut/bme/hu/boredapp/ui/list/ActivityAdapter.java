package aut.bme.hu.boredapp.ui.list;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aut.bme.hu.boredapp.R;
import aut.bme.hu.boredapp.model.BoredActivity;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    private List<BoredActivity> dataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView activityNameTv;
        public TextView activityTypeTv;
        public ActivityViewHolder(View row) {
            super(row);
            this.activityNameTv = row.findViewById(R.id.activityListRowTitleTv);
            this.activityTypeTv = row.findViewById(R.id.activityListRowTypeTv);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActivityAdapter(List<BoredActivity> activities) {
        dataset = activities;
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
        holder.activityNameTv.setText(item.getActivity());
        holder.activityTypeTv.setText(item.getType());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
