package cn.fm.playandroid.presenter;

import cn.fm.playandroid.bean.LoginResponse;
import cn.fm.playandroid.model.UserModel;
import cn.fm.playandroid.model.UserModelImpl;
import cn.fm.playandroid.view.LoginView;

/**
 * Created by Administrator on 2018/9/21.
 */

public class UserPresenterImpl implements UserPresenter.OnLoginListener,
        UserPresenter.OnRegisterListener {

    LoginView loginView;
    UserModel loginModel;

    public UserPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new UserModelImpl();
    }

    @Override
    public void loginWanAndroid(String username, String password) {
        loginModel.loginWanAndroid(this, username, password);
    }

    @Override
    public void loginSuccess(LoginResponse result) {
        if (result.getErrorCode() != 0) {
            loginView.loginFailed(result.getErrorMsg());
        } else {
            loginView.loginSuccess(result);
            loginView.loginRegisterAfter(result);
        }
    }

    @Override
    public void loginFailed(String errorMessage) {
        loginView.loginFailed(errorMessage);
    }

    @Override
    public void registerWanAndroid(String username, String password, String repassword) {
        loginModel.registerWanAndroid(this, username, password, repassword);
    }

    @Override
    public void registerSuccess(LoginResponse result) {
        if (result.getErrorCode() != 0) {
            loginView.registerFailed(result.getErrorMsg());
        } else {
            loginView.registerSuccess(result);
            loginView.loginRegisterAfter(result);
        }
    }

    @Override
    public void registerFailed(String errorMessage) {
        loginView.registerFailed(errorMessage);
    }

    public void cancalRequest() {
        loginModel.cancelLoginRequest();
        loginModel.cancelRegisterRequest();
    }


    public void registerAutoLogin(String username, String password, String repassword){
        loginModel.registerAutoLogin(this,this,username, password, repassword);
    }
}
