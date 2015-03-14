package biz.osvit.android.osvitblogspot.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by spenko
 */
public class PostWrapperModel {

    /*
    * {
    "status": "ok",
    "count": 12,
    "count_total": 12,
    "pages": 1,
    "posts": []
        }
    * */

    private String status;
    private long count;
    @SerializedName("count_total")
    private long totalCount;
    private long pages;
    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public long getCount() {
        return count;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getPages() {
        return pages;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
