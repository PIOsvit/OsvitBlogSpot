package biz.osvit.android.osvitblogspot.commons.volley;

public interface ResponseListener<T> {

    public void onResponse(T data);

    public void onError(Object error);

}