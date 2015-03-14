package biz.osvit.android.osvitblogspot.main.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by spenko
 */
public class Post {

    /*
    *  {
            "id": 259,
            "url": "http://dev.osvit.biz/objava-sa-slikom/",
            "title": "Objava sa slikom",
            "content": "<p>Ovo je objava koja sadrži istaknutu sliku i
            "comment_count": 0,
            "thumbnail": "http://dev.osvit.biz/wp-content/uploads/2014/12/favd5.png",
            }
    * */

    private long id;
    private String url;
    private String title;
    private String content;
    @SerializedName("comment_count")
    private long commentCount;
    private String thumbnail;

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
