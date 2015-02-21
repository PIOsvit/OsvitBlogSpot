package biz.osvit.android.osvitblogspot.splash.activity;

import biz.osvit.android.osvitblogspot.base.BaseActivity;
import biz.osvit.android.osvitblogspot.login.activity.LoginActivity;
import biz.osvit.android.osvitblogspot.splash.activity.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import biz.osvit.android.osvitblogspot.R;


public class SplashActivity extends BaseActivity {

    private final int SPLASH_DURATION = 2000;

    private final Handler mHandler = new Handler();

    private final Runnable mNextActivityRunnable = new Runnable() {
        @Override
        public void run() {
            startNextActivity();
        }
    };

    private void startNextActivity() {

        Intent intent = new Intent(this, LoginActivity.class); //todo napraviti
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mHandler.postDelayed(mNextActivityRunnable, SPLASH_DURATION);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mNextActivityRunnable); //izbjegne crashanje aplikacije kod izlaska za vrijeme splasha
    }
}
