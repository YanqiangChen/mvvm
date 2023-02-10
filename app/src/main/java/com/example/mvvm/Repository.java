package com.example.mvvm;

import android.os.Handler;

//网络请求数据、本地数据库数据等，model层
public class Repository {

    interface DataCallback{
        void onResult(Model model);
    }

    //模拟获取用户的数据信息
    public void getUserInfo(DataCallback dataCallback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                model.setPwd("123456");
                model.setUsername("jack");
                dataCallback.onResult(model);

            }
        },3000);



    }
}
