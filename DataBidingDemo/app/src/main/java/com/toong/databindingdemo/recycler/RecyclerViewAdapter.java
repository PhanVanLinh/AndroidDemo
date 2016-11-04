package com.toong.databindingdemo.recycler;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.toong.databindingdemo.BR;
import com.toong.databindingdemo.R;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private ArrayList<User> mUserList;
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;
        public ItemViewHolder(View v) {
            super(v);
            mBinding = DataBindingUtil.bind(v);
        }
        public ViewDataBinding getBinding() {
            return mBinding;
        }
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public RecyclerViewAdapter(ArrayList<User> userList) {
        mUserList = userList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        User user = mUserList.get(position);

        holder.getBinding().setVariable(BR.user, user);
        holder.getBinding().executePendingBindings();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(final ImageView view, final String url) {
        view.setImageResource(R.mipmap.ic_launcher);
    }
}
