package biz.osvit.android.osvitblogspot.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.base.BaseFragment;

/**
 * Created by Josip Jurisic on 04.03.15.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    //Ui widgets
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginBtn;
    private TextView mPrivacyPolicyTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {

    }

    @Override
    protected void prepareData() {

    }


    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            handleLoginBtnClick();
        } else if (v == mPrivacyPolicyTextView) {
            //todo add pp
        }
    }

    private void handleLoginBtnClick() {

    }
}
