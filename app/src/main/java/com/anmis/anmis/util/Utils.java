package com.anmis.anmis.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by yuanlei on 15/4/10.
 */
public class Utils {
    public static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {

        }
        return null;
    }

    public static int screenWidth = 0;
    public static int screenHeight = 0;

    public static int getScreenWidth(Context context) {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }

    public static int getScreenheight(Context context){
        int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }



}
