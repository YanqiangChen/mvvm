package com.example.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.Observable;

//model层,只关心数据本身，没有任何行为
public class Model extends BaseObservable {
    public String username;
    public String pwd;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
