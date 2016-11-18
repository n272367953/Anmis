package com.anmis.anmis.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niushuowen on 2016/4/29.
 */
public class ClickEnentManager {
    private static List<Button> buttons;
    private static Context context;
    private static int position;

    public static void init(Context ctx) {
        context = ctx;
        if (buttons == null) {
            buttons = new ArrayList<>();
        }
    }

    public static void registerButton(final Button button, int position) {
        button.setTag(position + 1);
        //button.setText(String.valueOf(button.getTag())+"\n"+button.getText()+"\n"+"UpDownOutInActivity");
        button.invalidate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch ((int) v.getTag()) {
                    case 1:
                        intent = getIntent(UpDownOutInActivity.class);
                        break;
                    case 2:
//                        intent =  getIntent(CircleNumProgressBarActivity.class);
                        intent = getIntent(SelectedableTextViewActivity.class);
                        break;
                    case 3:
                        intent = getIntent(ScrollerGradientActivity.class);
                        break;
                    case 4:
                        intent = getIntent(PullToRefreshActivity.class);
                        break;
                    case 5:
                        intent = getIntent(DataBindingActivity.class);
                        break;
                    case 6:
                        intent = getIntent(PinnedHeaderExpandTestActivity.class);
                        break;
                    case 7:
                        intent = getIntent(SurfaceViewTestActivity.class);
                        break;
                    case 8:
                        intent = getIntent(RetroFitTestActivity.class);
                        break;
                    case 9:
                        break;
                    case 10:
                        intent = getIntent(FrescoTestActivity.class);
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                }
                if (intent != null) {
                    context.startActivity(intent);
                }
            }
        });
    }

    private static Intent getIntent(Class clazz) {
        Intent intent = new Intent(context, clazz);
        return intent;
    }
}
