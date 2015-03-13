package biz.osvit.android.osvitblogspot.commons.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;


/**
 * Copyright (c) 2014
 *
 * @author Josip Jurisic
 * @version 1.0.0
 */

public final class NetworkUtils {

    private NetworkUtils(){}

    public static boolean hasActiveInternetConnection(@NonNull Context context) {
        ConnectivityManager connectionManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        return ((networkInfo != null) && networkInfo.isConnected());
    }
}