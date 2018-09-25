package cn.fm.playandroid.base;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2018/9/21.
 */

public abstract class BaseFragment extends Fragment {
    protected boolean isFirst = true;

    /**
     * cancel request
     */
    protected abstract void cancelRequest();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cancelRequest();
    }
}
