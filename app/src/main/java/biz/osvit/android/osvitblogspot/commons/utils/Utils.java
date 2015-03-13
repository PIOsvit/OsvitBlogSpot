package biz.osvit.android.osvitblogspot.commons.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.BuildConfig;
import android.util.Log;
import android.widget.Toast;

public class Utils {

    private static final String TAG = "OsvitBlogSpot";

    public static void doLog(@NonNull Object o) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, o.toString());
        }
    }

    public static void doLogException(@NonNull Exception e) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "Exception", e);
        }
    }

    public static void doToast(@NonNull Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void doToast(@NonNull Context context, int stringResId) {
        Toast.makeText(context, stringResId, Toast.LENGTH_LONG).show();
    }

    public static void doToast(@NonNull Context context, Object o) {
        Toast.makeText(context, o.toString(), Toast.LENGTH_LONG).show();
    }
}