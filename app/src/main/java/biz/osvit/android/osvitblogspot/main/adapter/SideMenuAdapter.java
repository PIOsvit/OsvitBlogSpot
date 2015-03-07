package biz.osvit.android.osvitblogspot.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import biz.osvit.android.osvitblogspot.R;

/**
 * Created by spenko
 */
public class SideMenuAdapter extends BaseAdapter {

    private final Context mContext;
    private final Categories[] mCategories = Categories.values();

    public SideMenuAdapter(@NonNull Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCategories.length;
    }

    @Override
    public Categories getItem(int position) {
        return mCategories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_side_menu, parent, false);
            holder = new ViewHolder();
            holder.mTitleTextView = (TextView) convertView.findViewById(R.id.content_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Categories item = getItem(position);
        holder.mTitleTextView.setText(item.getStringId());
        return convertView;
    }

    private static class ViewHolder {
        private TextView mTitleTextView;
    }


    public enum Categories {
        NEWS(R.string.news),
        MY_NEWS(R.string.my_news),
        CREATE_POST(R.string.create_post),
        EDIT_PROFILE(R.string.edit_profile),
        ABOUT(R.string.about);

        int stringId;

        Categories(int stringId) {
            this.stringId = stringId;
        }

        public int getStringId() {
            return this.stringId;
        }
    }
}