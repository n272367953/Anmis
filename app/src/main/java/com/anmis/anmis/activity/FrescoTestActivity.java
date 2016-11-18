package com.anmis.anmis.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.anmis.anmis.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by nsw on 2016/11/18 14:53 .
 */

public class FrescoTestActivity extends Activity {


    private String imgUrl = "http://f.hiphotos.baidu.com/image/pic/item/203fb80e7bec54e753da379aba389b504fc26a7b.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_test);
        loadImage();
    }

    private void loadImage() {
        SimpleDraweeView sdv = (SimpleDraweeView) findViewById(R.id.imageView1);
        sdv.setImageURI(Uri.parse(imgUrl));
    }

}
