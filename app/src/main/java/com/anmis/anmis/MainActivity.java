package com.anmis.anmis;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.anmis.anmis.activity.ClickEnentManager;
import com.anmis.anmis.adapter.MyRecyclerViewAdaptes;
import com.anmis.anmis.util.DataTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView indicator;
    private RecyclerView recycleView;
    private int offset;
    private String[] buttonNames = {
            "上下滑入滑出", "可选择复制的TextView", "可滑动渐变的header",
            "下拉测试", "DataBinderTest", "PinnedHeaderExpandableListView",
            "SurfaceViewTest", "RrtroFit Demo", "Rxjava",
            "Fresco", "GreenDao Test", "12",
            "13", "14", "15",
            "16", "17", "18",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ClickEnentManager.init(this);
    }

    private void initView() {

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        indicator = (ImageView) findViewById(R.id.indicator);
        int width = getApplication().getResources().getDisplayMetrics().widthPixels / 3;
        recycleView = (RecyclerView) findViewById(R.id.recyclerView);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new MyRecyclerViewAdaptes(this, buttonNames);
        recycleView.setAdapter(adapter);
        offset = width;
        Bitmap bitmap = Bitmap.createBitmap(width, DataTools.dip2px(this, 5.0f), Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(getResources().getSystem().getColor(android.R.color.holo_green_dark));
        indicator.setImageBitmap(bitmap);


//        indicator.setBackground(BitmapDrawable.createFromStream(bitmap.));

    }

    private int currentIndex;

    @Override
    public void onClick(View v) {
        Animation animation = null;
        switch (v.getId()) {
            case R.id.button1:
                animation = getAnimation(currentIndex, 0);
                currentIndex = 0;
                break;
            case R.id.button2:
                animation = getAnimation(currentIndex, 1);
                currentIndex = 1;
                break;
            case R.id.button3:
                animation = getAnimation(currentIndex, 2);
                currentIndex = 2;
                break;
        }

        if (animation != null) {
            animation.setFillAfter(true);
            animation.setDuration(300);
            indicator.startAnimation(animation);
        }
    }

    private Animation getAnimation(int oldIndex, int newIndex) {
        if (oldIndex == newIndex) {
            return null;
        }
        TranslateAnimation animation = new TranslateAnimation(oldIndex * offset, newIndex * offset, 0, 0);
        return animation;
    }
}
