package com.example.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<UserResponse> mItems;

    public UserAdapter() {
        super();
        mItems = new ArrayList<UserResponse>();
    }

    public void addData(UserResponse userResponse) {
        mItems.add(userResponse);
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
        UserResponse userResponse = mItems.get(i);
        viewHolder.login.setText(userResponse.getLogin());
        viewHolder.repos.setText("repos: " + userResponse.getPublicRepos());
        viewHolder.blog.setText("blog: " + userResponse.getBlog());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView repos;
        public TextView blog;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
        }
    }
}