package com.example.retrofittesting.ui.posts;

import com.example.retrofittesting.BaseActivityInterface;

import java.util.ArrayList;

import retrofitPojoClasses.PojoPostData;

public interface PostsInterface extends BaseActivityInterface {
    void showData(ArrayList<PojoPostData> data);
}
