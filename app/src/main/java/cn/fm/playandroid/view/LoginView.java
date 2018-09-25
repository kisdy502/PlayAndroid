package cn.fm.playandroid.view;

import cn.fm.playandroid.bean.LoginResponse;

/**
 * Created by Administrator on 2018/9/21.
 */

public interface LoginView {

    /**
     * login success
     *
     * @param result LoginResponse
     */
    void loginSuccess(LoginResponse result);

    /**
     * login failed
     *
     * @param errorMessage error message
     */
    void loginFailed(String errorMessage);

    /**
     * register success
     *
     * @param result LoginResponse
     */
    void registerSuccess(LoginResponse result);

    /**
     * register failed
     *
     * @param errorMessage error message
     */
    void registerFailed(String errorMessage);

    /**
     * login or register success after operation
     *
     * @param result LoginResponse
     */
    void loginRegisterAfter(LoginResponse result);
}
