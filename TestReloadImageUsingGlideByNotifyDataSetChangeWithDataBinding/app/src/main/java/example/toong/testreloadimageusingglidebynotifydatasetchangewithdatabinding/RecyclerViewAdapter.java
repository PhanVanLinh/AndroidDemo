package example.toong.testreloadimageusingglidebynotifydatasetchangewithdatabinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import example.toong.testreloadimageusingglidebynotifydatasetchangewithdatabinding.databinding.ItemBinding;
import java.util.List;

/**
 * Created by phanvanlinh on 06/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> list;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemBinding mBinding;
        public MyViewHolder(ItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            mBinding.setViewHolder(this);
        }

        public int getSrc(){
            return R.drawable.ic_launcher;
        }
    }
    public RecyclerViewAdapter(Context context, List<String> moviesList) {
        this.mContext = context;
        this.list = moviesList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item,
                        parent, false);
        return new MyViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @BindingAdapter({ "src" })
    public static void setImageSrc(ImageView view, int src) {
        if (src != -1) view.setImageResource(src);
    }

}