package cn.fm.playandroid.model;

import cn.fm.playandroid.presenter.HomePresenter;

/**
 * Created by Administrator on 2018/9/23.
 */

public interface HomeModel {

    void getHomeList(HomePresenter.OnHomeListListener onHomeListListener, int page);

    void cancelHomeListRequest();

    void getTypeTreeList(HomePresenter.OnTypeTreeListListener onTypeTreeListListener);

    void cancelTypeTreeRequest();

    void getFriendList(HomePresenter.OnFriendListListener onFriendListListener);

    void cancelFriendRequest();

    void getBanner(HomePresenter.OnBannerListener onBannerListener);

    void cancelBannerRequest();
}
