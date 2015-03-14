package biz.osvit.android.osvitblogspot.commons.requests;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import biz.osvit.android.osvitblogspot.commons.volley.GsonRequest;
import biz.osvit.android.osvitblogspot.commons.volley.ResponseListener;
import biz.osvit.android.osvitblogspot.main.model.PostWrapperModel;

/**
 * Created by spenko
 */
public class BackendRequest {

    private static BackendRequest sInstance;

    public synchronized static BackendRequest getInstance(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = new BackendRequest(context);
        }
        return sInstance;
    }

    private final Context mContext;
    private final RequestQueue mRequestQueue;

    private BackendRequest(@NonNull Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }


    public void requestPosts(@NonNull final ResponseListener<PostWrapperModel> listener) {
        String url = "http://dev.osvit.biz/api/?json=get_posts";

        GsonRequest<PostWrapperModel> request = new GsonRequest<>
                (url, PostWrapperModel.class, null, new Response.Listener<PostWrapperModel>() {
                    @Override
                    public void onResponse(PostWrapperModel response) {
                        listener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                });

        mRequestQueue.add(request);
    }
}













