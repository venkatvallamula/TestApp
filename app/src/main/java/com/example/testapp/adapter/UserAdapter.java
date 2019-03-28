package com.example.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.Item;
import com.example.testapp.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> implements View.OnClickListener {
    List<Item> mItems;

    public UserAdapter() {
        super();
        mItems = new ArrayList<Item>();
    }

    public void addData(UserResponse userResponse) {
        mItems = userResponse.getItems();
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item item = mItems.get(i);
        viewHolder.accountId.setText(String.valueOf(item.getReputation()));
        viewHolder.displayName.setText(item.getDisplayName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View v) {
        Item item = mItems.get(v.getId());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView accountId;
        public TextView displayName;

        public ViewHolder(View itemView) {
            super(itemView);
            accountId = (TextView) itemView.findViewById(R.id.accountId);
            displayName = (TextView) itemView.findViewById(R.id.txt_display_name);

        }
    }

}