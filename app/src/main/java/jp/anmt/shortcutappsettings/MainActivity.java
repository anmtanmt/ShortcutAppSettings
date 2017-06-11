package jp.anmt.shortcutappsettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 透過アクティビティのためタイトルバーも非表示にする
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        // 設定のアプリケーション一覧を明示的インテント起動
        Intent intent = null;
        intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.applications.ManageApplications");
//        intent.setClassName("com.android.settings", "com.android.settings.applications.ManageApplicationsActivity");

        startActivity(intent);
    }
    @Override
    public void onDestroy() {
        if (Param.D) Log.d(TAG, "onDestroy()");

        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (Param.D) Log.d(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        if (Param.D) Log.d(TAG, "onStop()");

        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Param.D) Log.d(TAG, "onResume() Build.Version:" + Build.VERSION.SDK_INT);

        // アクティビティ終了要求を出す
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            finish();
//            android.os.Process.killProcess(android.os.Process.myPid());
//        } else {
//            finishAndRemoveTask();
//        }
    }

    @Override
    protected void onPause() {
        if (Param.D) Log.d(TAG, "onPause()");

        super.onPause();
    }

}
