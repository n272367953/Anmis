package com.anmis.anmis.activity;

import android.app.Activity;
import android.os.Bundle;

import com.anmis.anmis.R;

/**
 * Created by niushuowen on 2016/8/15.
 */
public class PullToRefreshActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_to_refresh_layout);
    }
}
