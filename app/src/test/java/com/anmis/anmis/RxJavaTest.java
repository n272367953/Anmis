package com.anmis.anmis;

import android.provider.Settings;
import android.util.Log;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Administrator on 2016/11/3.
 */

public class RxJavaTest {

    @Test
    public void rxJavaTest() {
        String[] array = {"1", "2", "3"};
        Observable.from(array)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + "=====";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                })
        ;

    }

    @Test
    public void add() {
        System.out.println(2 + 3);
    }
}
