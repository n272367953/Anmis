package com.anmis.anmis.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.anmis.anmis.R;
import com.anmis.anmis.retrofit.RequestDemo;
import com.anmis.anmis.retrofit.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/10/28.
 */
public class RetroFitTestActivity extends Activity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofix_test_layout);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void submit(View v) {
        RequestDemo requestDemo = RetrofitManager.getInstance().create(RequestDemo.class);
        Call<String> call = requestDemo.getString("14");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("===============", "response:" + response.body().toString());
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


}
