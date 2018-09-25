package cn.fm.playandroid.presenter;

import cn.fm.playandroid.bean.LoginResponse;

/**
 * Created by Administrator on 2018/9/21.
 */

public interface UserPresenter {
    /**
     * login Listener
     */
    interface OnLoginListener {
        /**
         * login
         * @param username username
         * @param password password
         */
        void loginWanAndroid(String username ,String password );

        /**
         * login success
         * @param result LoginResponse
         */
        void loginSuccess(LoginResponse result);

        /**
         * login failed
         * @param errorMessage error message
         */
        void loginFailed(String errorMessage);
    }

    /**
     * register Listener
     */
    interface OnRegisterListener {
        /**
         * register
         * @param username username
         * @param password password
         * @param repassword repassword
         */
        void registerWanAndroid(String username,String password,String repassword);

        /**
         * register success
         * @param result LoginResponse
         */
        void registerSuccess(LoginResponse result);

        /**
         * register failed
         * @param errorMessage error message
         */
        void registerFailed(String errorMessage);
    }
}
