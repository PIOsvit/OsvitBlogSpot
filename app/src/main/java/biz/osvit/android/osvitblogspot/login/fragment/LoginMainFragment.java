package biz.osvit.android.osvitblogspot.login.fragment;

        import android.content.Intent;
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
        import biz.osvit.android.osvitblogspot.main.activity.MainActivity;

/**
 * Created by Boris on 21.2.2015..
 */
public class LoginMainFragment extends BaseFragment implements View.OnClickListener {

    private Button mLoginBtn;
    private Button mRegisterBtn;
    private TextView mGhostmodeTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mLoginBtn = (Button) layoutView.findViewById(R.id.login);
        mRegisterBtn = (Button) layoutView.findViewById(R.id.register);
        mGhostmodeTextView = (TextView) layoutView.findViewById(R.id.skip_login);

        mLoginBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
        mGhostmodeTextView.setOnClickListener(this);
    }

    @Override
    protected void prepareData() {
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn) {
            replaceFragment(R.id.fragment_container, new LoginFragment(), true);
        } else if (v == mRegisterBtn) {
            //todo handle registration
        } else if (v == mGhostmodeTextView) {
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        }
    }
}