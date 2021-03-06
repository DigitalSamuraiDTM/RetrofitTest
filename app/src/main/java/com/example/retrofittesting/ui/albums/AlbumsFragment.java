package com.example.retrofittesting.ui.albums;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//является view в архитектуре mvp, то есть отвечает только за реализацию интерфейса
public class AlbumsFragment extends Fragment implements AlbumsInterface {
    AlbumsPresenter presenter;
    @Override
    public void onAttach(@NonNull Context context) {
        presenter = new AlbumsPresenter(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.showData();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        presenter = null;
        super.onDetach();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void showError(int errorStatus) {

    }
}