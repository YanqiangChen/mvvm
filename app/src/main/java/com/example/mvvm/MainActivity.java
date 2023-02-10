package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.example.mvvm.databinding.ActivityMainBinding;

//view层主要的工作负责接收用户输入、发起数据请求及展示结果页面。
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //布局绑定
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //获取ViewModel
        ViewModel vm = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModel.class);
        //ViewModel与DataBinding进行绑定
        binding.setViewModel(vm);
        binding.setLifecycleOwner(this);
        //更新数据
        vm.getUserInfo();
        //liveData数据监听
        vm.modelMutableLiveData.observe(this, new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                Toast.makeText(MainActivity.this,"name: "+model.username, Toast.LENGTH_SHORT).show();
            }
        });

        //数据的双向绑定
        binding.btnChangeViewModel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Model model = vm.modelMutableLiveData.getValue();
                try {
                    Log.e("ViewModel",model.getUsername());
                }catch (Exception e){

                }

            }
        });


    }
}