package biz.osvit.android.osvitblogspot.commons.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biz.osvit.android.osvitblogspot.commons.utils.Utils;

public class GsonArrayRequest<T> extends Request<List<T>> {

    private static final String PROTOCOL_CHARSET = "UTF-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    private final Gson gson;
    private final Class<T> mClazz;
    private final Listener<List<T>> mListener;
    private final String mRequestBody;

    public GsonArrayRequest(String url, Class<T> clazz, JsonObject jsonRequest, Listener<List<T>> listener, ErrorListener errorListener) {
        this(jsonRequest == null ? Method.GET : Method.POST, url, clazz, jsonRequest, listener, errorListener);
    }

    public GsonArrayRequest(int method, String url, Class<T> clazz, JsonObject jsonRequest, Listener<List<T>> listener, ErrorListener errorListener) {
        super(method, url, errorListener);

        setShouldCache(true);

        mListener = listener;
        mRequestBody = jsonRequest == null ? null : jsonRequest.toString();
        mClazz = clazz;
        gson = GsonUtils.createGsonInstance();
        setRetryPolicy(new DefaultRetryPolicy(10000, 2, 1f));
    }

    @Override
    protected void deliverResponse(List<T> response) {
        if (mListener != null) {
            mListener.onResponse(response);
        }

    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Response<List<T>> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, PROTOCOL_CHARSET);
            Utils.doLog(json);
            Type clazzListType = new TypeToken<List<T>>() {
            }.getType();
            List<Map> tempList = gson.fromJson(json, clazzListType);
            List<T> result = new ArrayList<>(tempList.size());

            for (Map map : tempList) {
                String tmpJson = gson.toJson(map);
                result.add(gson.fromJson(tmpJson, mClazz));
            }
            return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
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
    public byte[] getBody() {
        try {
            return mRequestBody == null ? null : mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }
}