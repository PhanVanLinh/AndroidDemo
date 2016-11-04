package com.toong.databindingdemo.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.toong.databindingdemo.R;
import java.util.ArrayList;


public class DataBindingRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<User> movieList = new ArrayList<>();
    RecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_recycler_view);

        User movie = new User("Linh", "Phan", "");
        movieList.add(movie);
        User movie2 = new User("Abc", "Def", "");
        movieList.add(movie2);
        User movie3 = new User("Hello", "ZZZ", "");
        movieList.add(movie3);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new RecyclerViewAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
