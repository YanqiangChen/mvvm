package com.example.mvvm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

//VM层，主要是数据的处理业务逻辑的相关操作，使用livedata通知View层数据的变化/databing与view层进行数据的绑定
public class ViewModel extends AndroidViewModel {
    public static MutableLiveData<Model> modelMutableLiveData=new MutableLiveData<>();

    public Repository repository;



    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public void getUserInfo(){
        repository.getUserInfo(new Repository.DataCallback() {
            @Override
            public void onResult(Model model) {
                modelMutableLiveData.setValue(model);
            }
        });
    }

    public void updateUserInfo(View view){
        Model model = new Model();
        model.setPwd("123456");
        model.setUsername("lili");
        modelMutableLiveData.setValue(model);

    }

}
