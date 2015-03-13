package biz.osvit.android.osvitblogspot.commons.volley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.commons.utils.Utils;


public class VolleyErrorHelper {

    public static void handleErrorWithToast(@NonNull Object error, @NonNull Context context) {
        Toast.makeText(context, getMessage(error, context), Toast.LENGTH_SHORT).show();
    }

    public static String getMessage(@NonNull Object error, @NonNull Context context) {
        boolean is401 = false;

        try {
            is401 = ((NoConnectionError) error).getMessage().contains(context.getResources().getString(R.string.authentication));
        } catch (Exception e) {
            Utils.doLogException(e);
        }
        if (is401) {
            return context.getResources().getString(R.string.error_auth);
        }
        if (error instanceof String) {
            return (String) error;
        } else if (error instanceof TimeoutError) {
            return context.getResources().getString(R.string.error_timeout);
        } else if (isServerProblem(error)) {
            return handleServerError(error, context);
        } else if (isNetworkProblem(error)) {
            return context.getResources().getString(R.string.error_no_internet);
        }
        return context.getResources().getString(R.string.error);
    }

    private static boolean isNetworkProblem(@NonNull Object error) {
        return (error instanceof NetworkError) || (error instanceof NoConnectionError);
    }

    private static boolean isServerProblem(@NonNull Object error) {
        return (error instanceof ServerError) || (error instanceof AuthFailureError);
    }

    private static String handleServerError(@NonNull Object err, @NonNull Context context) {
        VolleyError error = (VolleyError) err;
        NetworkResponse response = error.networkResponse;
        if (response != null) {
            switch (response.statusCode) {
                case 404:
                case 422:
                case 401:
                case 400:
                    //server might return error like this { "error": "Some error occured"}
                    //Use "Gson" to parse the result
                    return new String(response.data);
                // invalid request
                default:
                    return context.getResources().getString(R.string.error);
            }
        }
        return context.getResources().getString(R.string.error);
    }
}