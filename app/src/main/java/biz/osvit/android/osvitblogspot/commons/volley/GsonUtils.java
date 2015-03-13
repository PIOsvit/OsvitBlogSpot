package biz.osvit.android.osvitblogspot.commons.volley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GsonUtils {

    private static final String DATE_FORMAT = "yyyy-mm-dd";

    public static Gson createGsonInstance() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, createDateSerializer())
                .registerTypeAdapter(Date.class, createDateDeserializer());
        return gsonBuilder.create();
    }

    private static final SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    private static JsonSerializer<Date> createDateSerializer() {
        return new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                if (src == null) {
                    return null;
                }

                return new JsonPrimitive(formatter.format(src));
            }
        };
    }

    private static JsonDeserializer<Date> createDateDeserializer() {
        return new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                if (json == null) {
                    return null;
                }

                try {
                    return formatter.parse(json.getAsString());
                } catch (ParseException e) {
                    return null;
                }
            }
        };
    }

}
