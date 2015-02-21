package biz.osvit.android.osvitblogspot.base;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;


public class BaseActivity extends ActionBarActivity{

    protected void replaceFragment(int layoutId, @NonNull BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        transaction.commit();
    }
}
