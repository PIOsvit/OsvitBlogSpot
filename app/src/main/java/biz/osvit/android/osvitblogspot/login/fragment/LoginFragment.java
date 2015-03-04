package biz.osvit.android.osvitblogspot.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
        View layoutView = inflater.inflate(R.layout.fragment_login, container, false);
        prepareUI(layoutView);
        return layoutView;
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mEmailEditText = (EditText) layoutView.findViewById(R.id.email);
        mPasswordEditText = (EditText) layoutView.findViewById(R.id.password);
        mLoginBtn = (Button) layoutView.findViewById(R.id.login);
        mLoginBtn.setOnClickListener(this);
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

        boolean errorFound = false;

        String email = mEmailEditText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            errorFound = true;
            mEmailEditText.setError(getString(R.string.required));
        }

        String password = mPasswordEditText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            errorFound = true;
            mPasswordEditText.setError(getString(R.string.required));
        }

        if (errorFound) {
            return;
        }

//        startActivity(new Intent());
//        getActivity().finish();
        //todo add backend callbacks
    }
}
