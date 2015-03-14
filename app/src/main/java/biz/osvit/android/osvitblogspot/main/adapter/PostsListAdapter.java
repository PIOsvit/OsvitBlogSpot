package biz.osvit.android.osvitblogspot.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.main.model.Post;

/**
 * Created by spenko
 */
public class PostsListAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Post> mPosts = new ArrayList<>();

    public PostsListAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setPosts(@NonNull List<Post> posts) {
        mPosts.clear();
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Post getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mPosts.get(position).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_post, parent, false);
            holder = new ViewHolder();
            holder.mTitleTextView = (TextView) convertView.findViewById(R.id.content_title);
            holder.mPostImageView = (ImageView) convertView.findViewById(R.id.content_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Post item = getItem(position);
        holder.mTitleTextView.setText(item.getTitle());

        String thumbUrl = item.getThumbnail();
        if (!TextUtils.isEmpty(thumbUrl)) {
            Picasso.with(mContext).load(thumbUrl).into(holder.mPostImageView);
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView mTitleTextView;
        private ImageView mPostImageView;
    }
}