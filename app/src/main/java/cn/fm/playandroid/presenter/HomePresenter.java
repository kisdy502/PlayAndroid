package cn.fm.playandroid.presenter;

import cn.fm.playandroid.bean.BannerResponse;
import cn.fm.playandroid.bean.FriendListResponse;
import cn.fm.playandroid.bean.HomeListResponse;
import cn.fm.playandroid.bean.HotKeyResponse;
import cn.fm.playandroid.bean.TreeListResponse;

/**
 * Created by Administrator on 2018/9/23.
 */

public interface HomePresenter {

    interface OnHomeListListener {

        void getHomeList(int page);

        void getHomeListSuccess(HomeListResponse result);

        void getHomeListFailed(String errorMessage);
    }


    interface OnTypeTreeListListener {

        void getTypeTreeList();

        void getTypeTreeListSuccess(TreeListResponse result);

        void getTypeTreeListFailed(String errorMessage);
    }


    interface OnFriendListListener {

        void getFriendList();

        void getFriendListSuccess(
                FriendListResponse bookmarkResult,
                FriendListResponse commonResult,
                HotKeyResponse hotResult
        );

        void getFriendListFailed(String errorMessage);
    }


    interface OnCollectArticleListener {

        void collectArticle(int id, boolean isAdd);

        void collectArticleSuccess(HomeListResponse result, boolean isAdd);

        void collectArticleFailed(String errorMessage, Boolean isAdd);
    }

    interface OnCollectOutsideArticleListener {

        void collectOutSideArticle(String title, String author, String link, boolean isAdd);

        void collectOutsideArticleSuccess(HomeListResponse result, boolean isAdd);

        void collectOutsideArticleFailed(String errorMessage, boolean isAdd);
    }

    interface OnBannerListener {

        void getBanner();

        void getBannerSuccess(BannerResponse result);

        void getBannerFailed(String errorMessage);
    }


    interface OnBookmarkListListener {

        void getFriendList();

        void getFriendListSuccess(FriendListResponse result);

        void getFriendListFailed(String errorMessage);
    }
}
