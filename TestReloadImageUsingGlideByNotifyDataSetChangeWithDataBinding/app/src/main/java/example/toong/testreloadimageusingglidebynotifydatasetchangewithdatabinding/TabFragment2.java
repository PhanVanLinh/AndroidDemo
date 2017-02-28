package example.toong.testreloadimageusingglidebynotifydatasetchangewithdatabinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabFragment2 extends Fragment {

    List<String> moviesList = new ArrayList<>();
    RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerViewAdapter(getActivity(), moviesList);
        recyclerView.setAdapter(adapter);

        if(getUserVisibleHint()){
            setAdapter();
        }

        return rootView;
    }

    public void setAdapter(){
        for(int i = 0; i< 50; i++){
            moviesList.add(""+i);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // reload data every time fragment visible
        if(isVisibleToUser && isResumed()){
            setAdapter();
        }
    }
}