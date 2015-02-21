package biz.osvit.android.osvitblogspot.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Boris on 21.2.2015..
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void prepareUI(@NonNull View layoutView);

    protected abstract void prepareData();
}
