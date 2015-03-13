package biz.osvit.android.osvitblogspot.commons.volley;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import biz.osvit.android.osvitblogspot.commons.utils.Utils;

public class GsonRequest<T> extends Request<T> {

    private static final String PROTOCOL_CHARSET = "UTF8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    private final Gson gson;
    private final Response.Listener<T> mListener;
    private final String mRequestBody;
    private Class<T> mClazz;

    public GsonRequest(String url, Class<T> clazz, String jsonRequestBody,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(jsonRequestBody == null ? Method.GET : Method.POST,
                url,
                jsonRequestBody,
                listener,
                errorListener);
        this.mClazz = clazz;
    }

    private GsonRequest(int method, String url, String jsonRequestBody,
                        Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);

        setShouldCache(true);

        mListener = listener;
        mRequestBody = jsonRequestBody;
        gson = GsonUtils.createGsonInstance();
        setRetryPolicy(new DefaultRetryPolicy(10000, 2, 1f));
    }

    @Override
    protected void deliverResponse(T response) {
        if (mListener != null) {
            mListener.onResponse(response);
        }
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, PROTOCOL_CHARSET);
            Utils.doLog(json);
            return Response.success(gson.fromJson(json, mClazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Allow-Null", "1");
        return headers;
    }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override
    public byte[] getBody() {
        try {
            return mRequestBody == null ? null : mRequestBody.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Utils.doLogException(e);
        }
        return null;
    }
}