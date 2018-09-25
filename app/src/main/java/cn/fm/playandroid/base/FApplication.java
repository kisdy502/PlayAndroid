package cn.fm.playandroid.base;

import android.app.Application;
import android.content.ComponentCallbacks2;

import com.bumptech.glide.Glide;
import com.squareup.leakcanary.LeakCanary;

import cn.fm.playandroid.BuildConfig;

/**
 * Created by Administrator on 2018/9/21.
 */

public class FApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }
}
