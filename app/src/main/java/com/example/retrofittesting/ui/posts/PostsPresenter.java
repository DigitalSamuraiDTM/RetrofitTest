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
    private ArrayList<PojoPostData> data = null;
    PostsPresenter(PostsInterface view){
        this.view = view;
    }

    @Override
    public void showData() {
        if ((data !=null)) {
            if (!data.isEmpty()) {
                view.hideLoading();
                view.showData(data);
                return;
            }
        }
        view.showLoading();
        if (InternetAccess.isConnected()) {
            RetrofitService.getInstance().getJSONApi().getPosts().enqueue(new Callback<List<PojoPostData>>() {
                @Override
                public void onResponse(Call<List<PojoPostData>> call, Response<List<PojoPostData>> response) {
                    data = (ArrayList<PojoPostData>) response.body();
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
