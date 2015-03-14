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
import biz.osvit.android.osvitblogspot.main.adapter.SideMenuAdapter;
import biz.osvit.android.osvitblogspot.main.model.PostWrapperModel;

/**
 * Created by spenko
 */
public class SideMenuFragment extends BaseFragment {

    //Ui widgets
    private ListView mSideMenuListView;
    private SideMenuAdapter mSideMenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_side_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mSideMenuListView = (ListView) layoutView.findViewById(R.id.adapter_view);
        mSideMenuAdapter = new SideMenuAdapter(getActivity());
        mSideMenuListView.setAdapter(mSideMenuAdapter);
    }

    @Override
    protected void prepareData() {
    }
}
