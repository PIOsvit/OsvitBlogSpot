package biz.osvit.android.osvitblogspot.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import biz.osvit.android.osvitblogspot.R;
import biz.osvit.android.osvitblogspot.base.BaseFragment;

/**
 * Created by Boris on 21.2.2015..
 */
public class LoginMainFragment extends BaseFragment implements View.OnClickListener{

    private Button mLoginBtn;
    private Button mRegisterBtn;
    private TextView mGhostmodeTxtView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_login_main, container, false);
        prepareUI(layoutView);
        return layoutView;
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mLoginBtn = (Button) layoutView.findViewById(R.id.login);
        mRegisterBtn = (Button) layoutView.findViewById(R.id.register);
        mGhostmodeTxtView = (TextView) layoutView.findViewById(R.id.skip_login);

        mLoginBtn.setOnClickListener(mOnClickListener);
        mRegisterBtn.setOnClickListener(mOnClickListener);
        mGhostmodeTxtView.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void prepareData() {

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.login:
                    break;
                case R.id.register:
                    break;
                case R.id.skip_login:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        if(v==mLoginBtn){

        }
    }
}
