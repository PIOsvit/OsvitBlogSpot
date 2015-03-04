package biz.osvit.android.osvitblogspot.login.activity;

import android.os.Bundle;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.base.BaseActivity;
import biz.osvit.android.osvitblogspot.login.fragment.LoginMainFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        replaceFragment(R.id.fragment_container, new LoginMainFragment(), false);
    }
}