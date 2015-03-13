package biz.osvit.android.osvitblogspot.commons.volley;

import java.util.List;

public interface ResponseArrayListener<T> {

    public void onResponse(List<T> data);

    public void onError(Object error);

}