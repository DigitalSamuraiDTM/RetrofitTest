package com.example.retrofittesting.ui.albums;

import androidx.annotation.NonNull;

import com.example.retrofittesting.BasePresenterInterface;

class AlbumsPresenter implements BasePresenterInterface {
    private AlbumsInterface view;
    AlbumsPresenter(@NonNull AlbumsInterface albumsFragment){
        view = albumsFragment;

    }
    @Override
    public void showData(){

    }
}
