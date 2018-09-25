package cn.fm.playandroid.model;

import cn.fm.playandroid.presenter.UserPresenter;

/**
 * Created by Administrator on 2018/9/21.
 */

public interface UserModel {
    /**
     * login
     *
     * @param onLoginListener HomePresenter.OnLoginListener
     * @param username        username
     * @param password        password
     */
    void loginWanAndroid(
            UserPresenter.OnLoginListener onLoginListener,
            String username,
            String password
    );

    /**
     * cancel login Request
     */
    void cancelLoginRequest();

    /**
     * register
     *
     * @param onRegisterListener HomePresenter.OnRegisterListener
     * @param username           username
     * @param password           password
     * @param repassword         repassword
     */
    void registerWanAndroid(
            UserPresenter.OnRegisterListener onRegisterListener,
            String username,
            String password,
            String repassword
    );

    /**
     * cancel register Request
     */
    void cancelRegisterRequest();


    void registerAutoLogin(UserPresenter.OnLoginListener onLoginListener,
                           UserPresenter.OnRegisterListener onRegisterListener,
                           String username,
                           String password,
                           String repassword);

}
