package com.example.retrofittesting;

public interface BaseActivityInterface {
    void showLoading();
    void hideLoading();
    void showData();
    void showError(int errorStatus);
}
