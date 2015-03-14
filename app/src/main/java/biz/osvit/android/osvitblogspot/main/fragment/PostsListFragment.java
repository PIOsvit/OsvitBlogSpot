package biz.osvit.android.osvitblogspot.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.base.BaseFragment;
import biz.osvit.android.osvitblogspot.commons.requests.BackendRequest;
import biz.osvit.android.osvitblogspot.commons.volley.ResponseListener;
import biz.osvit.android.osvitblogspot.commons.volley.VolleyErrorHelper;
import biz.osvit.android.osvitblogspot.main.adapter.PostsListAdapter;
import biz.osvit.android.osvitblogspot.main.model.PostWrapperModel;

/**
 * Created by spenko
 */
public class PostsListFragment extends BaseFragment {

    private ListView mPostsListView;
    private PostsListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mPostsListView = (ListView) layoutView.findViewById(R.id.adapter_view);
        mAdapter = new PostsListAdapter(getActivity());
        mPostsListView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareData();
    }

    @Override
    protected void prepareData() {
        BackendRequest.getInstance(getActivity()).requestPosts(new ResponseListener<PostWrapperModel>() {
            @Override
            public void onResponse(PostWrapperModel data) {
                mAdapter.setPosts(data.getPosts());
            }

            @Override
            public void onError(Object error) {
                VolleyErrorHelper.handleErrorWithToast(error, getActivity());
            }
        });
    }
}
