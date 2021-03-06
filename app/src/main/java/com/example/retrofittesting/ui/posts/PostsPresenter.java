package com.example.retrofittesting.ui.posts;

import android.util.Log;

import com.example.retrofittesting.BasePresenterInterface;
import mechanics.InternetAccess;
import mechanics.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofitPojoClasses.PojoPostData;

class PostsPresenter implements BasePresenterInterface {
    PostsInterface view;
    PostsPresenter(PostsInterface view){
        this.view = view;
    }

    @Override
    public void showData() {
        view.showLoading();
        if (InternetAccess.isConnected()) {
            RetrofitService.getInstance().getJSONApi().getPosts().enqueue(new Callback<List<PojoPostData>>() {
                @Override
                public void onResponse(Call<List<PojoPostData>> call, Response<List<PojoPostData>> response) {
                    ArrayList<PojoPostData> data = (ArrayList<PojoPostData>) response.body();
                    for (int i = 0; i < data.size(); i++) {
                        Log.d("TAG", data.get(i).getTitle());
                    }
                    view.hideLoading();
                    view.showData(data);
                }

                @Override
                public void onFailure(Call<List<PojoPostData>> call, Throwable t) {
                    view.showError(0);
                }
            });
        } else{
            //todo не работает показ
            view.showError(1);
        }
    }
}
