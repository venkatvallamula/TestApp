package com.example.testapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.activity.UserDetails;
import com.example.testapp.model.Item;
import com.example.testapp.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> implements View.OnClickListener {
    List<Item> mItems;
    Context context;
    private static final String TAG = UserAdapter.class.getSimpleName();

    public UserAdapter() {
        super();
        mItems = new ArrayList<Item>();
    }

    public void addData(UserResponse userResponse,Context context) {
        mItems = userResponse.getItems();
        this.context = context;
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
        final Item item = mItems.get(i);
        viewHolder.accountId.setText(String.valueOf(item.getReputation()));
        viewHolder.displayName.setText(item.getDisplayName());
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent user = new Intent(context, UserDetails.class);
                user.putExtra("userDetails",item);
                context.startActivity(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View v) {
        Item item = mItems.get(v.getId());
        Log.d(TAG,item.getDisplayName()+"------"+item.getUserType());

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView accountId;
        public TextView displayName;
        public LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            accountId = (TextView) itemView.findViewById(R.id.accountId);
            displayName = (TextView) itemView.findViewById(R.id.txt_display_name);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.parent_laout);
        }
    }

}