package biz.osvit.android.osvitblogspot.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.base.BaseFragment;

/**
 * Created by spenko
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {

    //Ui widgets
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mRetypePasswordEditText;
    private EditText mNickEditText;
    private RadioGroup mGenderRadioGroup;
    private Button mRegisterBtn;
    private TextView mTermsAndConditionsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mEmailEditText = (EditText) layoutView.findViewById(R.id.email);
        mPasswordEditText = (EditText) layoutView.findViewById(R.id.password);
        mRetypePasswordEditText = (EditText) layoutView.findViewById(R.id.retype_password);
        mNickEditText = (EditText) layoutView.findViewById(R.id.nick);
        mGenderRadioGroup = (RadioGroup) layoutView.findViewById(R.id.gender);
        mRegisterBtn = (Button) layoutView.findViewById(R.id.register);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    protected void prepareData() {

    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterBtn) {
            handleRegisterBtnClick();
        }
    }

    private void handleRegisterBtnClick() {
        boolean errorFound = false;

        String email = mEmailEditText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailEditText.setError(getString(R.string.required));
            errorFound = true;
        }

        String password = mPasswordEditText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.setError(getString(R.string.required));
            errorFound = true;
        }

        String retypePassword = mRetypePasswordEditText.getText().toString();
        if (TextUtils.isEmpty(retypePassword)) {
            mRetypePasswordEditText.setError(getString(R.string.required));
            errorFound = true;
        }

        if (!TextUtils.equals(password, retypePassword)) {
            mPasswordEditText.setError(getString(R.string.password_different));
            errorFound = true;
        }

        String nick = mNickEditText.getText().toString();
        if (TextUtils.isEmpty(nick)) {
            mNickEditText.setError(getString(R.string.required));
            errorFound = true;
        }

        if (errorFound) {
            return;
        }

//        startActivity(new Intent());
//          getActivity().finish();
    }
}
