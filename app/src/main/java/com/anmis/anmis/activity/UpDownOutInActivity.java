package com.anmis.anmis.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;

import com.anmis.anmis.R;

/**
 * Created by niushuowen on 2016/4/29.
 */
public class UpDownOutInActivity extends Activity {


    private boolean isShowing = true;

    private FrameLayout area1;
    private FrameLayout area2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upddownview);
        initView();
    }

    private void initView() {
        area1 = (FrameLayout) findViewById(R.id.top_view);
        area2 = (FrameLayout) findViewById(R.id.bottom_view);
        button = (Button) findViewById(R.id.button);
    }

    public void showAndHideViews(View v){
        if(isShowing){
            hideViews();
            isShowing = false;
            button.setText("显示");
        }else{
            showViews();
            isShowing = true;
            button.setText("隐藏");
        }
    }

    private void hideViews() {
        Animation animation1 = new TranslateAnimation(0,0,0,-area1.getHeight());
        animation1.setDuration(300);
        area1.setVisibility(View.GONE);
        area1.startAnimation(animation1);
        Animation animation2 = new TranslateAnimation(0,0,0,area2.getHeight());
        animation2.setDuration(300);
        area2.setVisibility(View.GONE);
        area2.startAnimation(animation2);
    }

    private void showViews() {
        Animation animation1 = new TranslateAnimation(0,0,-area1.getHeight(),0);
        animation1.setDuration(300);
        area1.setVisibility(View.VISIBLE);
        area1.startAnimation(animation1);
        Animation animation2 = new TranslateAnimation(0,0,area2.getHeight(),0);
        animation2.setDuration(300);
        area2.setVisibility(View.VISIBLE);
        area2.startAnimation(animation2);
    }
}
