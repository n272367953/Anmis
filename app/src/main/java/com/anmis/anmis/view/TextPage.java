package com.anmis.anmis.view;

/**
 * Created by niushuowen on 2016/5/25.
 */

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Layout;
import android.text.Selection;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * @author chroya
 */
public class TextPage extends EditText {
    private int off; //字符串的偏移值

    public TextPage(Context context) {
        super(context);
        initialize();
    }

    public TextPage(Context context, AttributeSet attr) {
        super(context, attr);
    }

    private void initialize() {
        setGravity(Gravity.TOP);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        //不做任何处理，为了阻止长按的时候弹出上下文菜单
    }

    @Override
    public boolean getDefaultEditable() {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        Layout layout = getLayout();
        int line = 0;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                line = layout.getLineForVertical(getScrollY() + (int) event.getY());
                off = layout.getOffsetForHorizontal(line, (int) event.getX());
                Selection.setSelection(getEditableText(), off);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                line = layout.getLineForVertical(getScrollY() + (int) event.getY());
                int curOff = layout.getOffsetForHorizontal(line, (int) event.getX());
                Selection.setSelection(getEditableText(), off, curOff);
                break;
        }
        return true;
    }


    private String fromHtml(String html) {
       Spanned str =  Html.fromHtml("<a href=\"www.baidu.com\">" + html + "</a>");
       return  str.toString();
    }


    @Override
    public void setText(CharSequence text, BufferType type) {

        char[] c = String.valueOf(text).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        text = String.valueOf(c);
        super.setText(fromHtml(text.toString()), type);
    }
}
