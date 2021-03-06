package com.example.retrofittesting.ui.posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittesting.R;

import java.util.ArrayList;

import retrofitPojoClasses.PojoPostData;

public class PostsFragment extends Fragment implements PostsInterface {
    PostsPresenter presenter;
    TextView textViewLoadingStatus;
    ConstraintLayout loadingLayout;
    ConstraintLayout dataLayout;
    ProgressBar loadingProgressBar;
    RecyclerView recyclerData;
    ArrayList<PojoPostData> listData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = new PostsPresenter(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        presenter.showData();
        super.onStart();
    }

    @Override
    public void onDetach() {
        presenter = null;
        super.onDetach();
    }

    @Override
    public void showLoading() {
            dataLayout.setVisibility(View.GONE);
            loadingLayout.setVisibility(View.VISIBLE);
            loadingProgressBar.setVisibility(View.VISIBLE);
            textViewLoadingStatus.setVisibility(View.INVISIBLE);

    }

    @Override
    public void hideLoading() {
        dataLayout.setVisibility(View.VISIBLE);
        loadingLayout.setVisibility(View.GONE);
        loadingProgressBar.setVisibility(View.VISIBLE);
        textViewLoadingStatus.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showData(ArrayList<PojoPostData> data) {
        listData.addAll(data);
    }

    @Override
    public void showError(int errorStatus) {
        //if ...
        dataLayout.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.VISIBLE);
        loadingProgressBar.setVisibility(View.GONE);
        textViewLoadingStatus.setVisibility(View.VISIBLE);
        switch (errorStatus){
            case 1:
                textViewLoadingStatus.setText("Internet connection?");
                break;
            case 0:
                textViewLoadingStatus.setText("Connection error :c\n(Click to try to reconnect)");
                break;
        }
    }

    private void initView(){
        textViewLoadingStatus = (TextView) getView().findViewById(R.id.fr_posts_loading_text);
        loadingProgressBar = (ProgressBar) getView().findViewById(R.id.fr_posts_loading_progressBar);
        loadingLayout = (ConstraintLayout) getView().findViewById(R.id.fr_posts_loading_lay);
        dataLayout = (ConstraintLayout) getView().findViewById(R.id.fr_posts_data_lay);
        recyclerData = (RecyclerView) getView().findViewById(R.id.fr_posts_recycler_posts_data);

        listData = new ArrayList<PojoPostData>();

        PostsAdapter adapter = new PostsAdapter(getContext(),listData);
        recyclerData.setAdapter(adapter);

    }
}