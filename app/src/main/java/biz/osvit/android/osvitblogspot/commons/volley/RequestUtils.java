package biz.osvit.android.osvitblogspot.commons.volley;


import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    public static Map<String, String> createHeaders() {
        return createHeaders(true);
    }

    public static Map<String, String> createHeaders(boolean includeContentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "");
        if (includeContentType) {
            headers.put("Content-Type", "application/json;");
        }
        return headers;
    }
}