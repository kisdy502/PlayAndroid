package cn.fm.playandroid.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;

public abstract class BaseActivity extends AppCompatActivity {

    private ImmersionBar immersionBar;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initImmersionBar();
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    protected abstract @LayoutRes
    int setLayoutId();

    protected abstract void cancelRequest();

    @Override
    public void finish() {
        if (!isFinishing()) {
            super.finish();
            hideKeyBoard();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        immersionBar.destroy();
        //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，
        //在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        cancelRequest();
    }

    void hideKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    void initImmersionBar() {
        //在BaseActivity里初始化
        immersionBar = ImmersionBar.with(this);
        immersionBar.init();
    }


}
