package com.anmis.anmis.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.anmis.anmis.R;
import com.anmis.anmis.databinding.ActivityDatabindingTestBinding;
import com.anmis.anmis.mode.User;

/**
 * Created by Administrator on 2016/11/10.
 */

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_test);
        User user = new User("小明", 25, 0);
        binding.setUser(user);
    }
}
