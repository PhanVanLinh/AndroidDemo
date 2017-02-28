package example.toong.testreloadimageusingglidebynotifydatasetchangeinrecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.Random;
import org.w3c.dom.Text;

/**
 * Created by phanvanlinh on 06/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView mTextView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            mTextView = (TextView) view.findViewById(R.id.textView);
        }
    }

    public RecyclerViewAdapter(Context context, List<String> moviesList) {
        this.mContext = context;
        this.list = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(list.get(position))
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .dontAnimate()
                .into(holder.imageView);

        holder.mTextView.setText(""+calculateText());
    }

    public float calculateText(){
        float number = 0;
        for(int i = 0; i < 10; i++){
            number += new Random().nextInt(100);
            number /= new Random().nextInt(10);
            number -= new Random().nextInt(200);
        }
        return number;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}