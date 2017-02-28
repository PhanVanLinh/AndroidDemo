package example.toong.testreloadimageusingglidebynotifydatasetchangeinrecylerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabFragment1 extends Fragment {

    List<String> moviesList = new ArrayList<>();
    RecyclerViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerViewAdapter(getActivity(), moviesList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public void setAdapter(){
        moviesList.addAll(new ArrayList<String>(Arrays.asList(Constant.IMAGES)));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && isResumed()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.i("Linh", "reload 1");
                    setAdapter();
                }
            }, 2000);
        }
    }
}