package cn.fm.playandroid.model;

import cn.fm.playandroid.bean.LoginResponse;
import cn.fm.playandroid.log.ELog;
import cn.fm.playandroid.net.RetrofitHelper;
import cn.fm.playandroid.presenter.UserPresenter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/9/21.
 */

public class UserModelImpl implements UserModel {

    @Override
    public void loginWanAndroid(final UserPresenter.OnLoginListener onLoginListener, String username, String password) {
        RetrofitHelper.getRetrofitService().loginWanAndroid(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        ELog.d("onSubscribe");
                    }

                    @Override
                    public void onNext(LoginResponse value) {
                        ELog.d("onNext");
                        if (onLoginListener != null) {
                            onLoginListener.loginSuccess(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ELog.d("onError");
                        if (onLoginListener != null) {
                            onLoginListener.loginFailed(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        ELog.d("onComplete");
                    }
                });
    }

    @Override
    public void cancelLoginRequest() {

    }

    @Override
    public void registerWanAndroid(final UserPresenter.OnRegisterListener onRegisterListener,
                                   String username, String password, String repassword) {
        RetrofitHelper.getRetrofitService().registerWanAndroid(username, password, repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        ELog.d("onSubscribe");
                    }

                    @Override
                    public void onNext(LoginResponse value) {
                        ELog.d("onNext");
                        if (onRegisterListener != null) {
                            onRegisterListener.registerSuccess(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ELog.d("onError");
                        if (onRegisterListener != null) {
                            onRegisterListener.registerFailed(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        ELog.d("onComplete");
                    }
                });
    }

    @Override
    public void cancelRegisterRequest() {

    }

    @Override
    public void registerAutoLogin(final UserPresenter.OnLoginListener onLoginListener, final UserPresenter.OnRegisterListener onRegisterListener, String username, String password, String repassword) {
        Observable<LoginResponse> registerObservable = RetrofitHelper.getRetrofitService()
                .registerWanAndroid(username, password, repassword);
        final Observable<LoginResponse> loginResponseObservable = RetrofitHelper.getRetrofitService
                ().loginWanAndroid(username, password);

        registerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        ELog.d("第一次网络请求成功");
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<LoginResponse, ObservableSource<LoginResponse>>() {
                    @Override
                    public ObservableSource<LoginResponse> apply(LoginResponse loginResponse) throws Exception {
                        if (loginResponse != null) {
                            int code = loginResponse.getErrorCode();
                            if (code == 0) {
                                onRegisterListener.registerSuccess(loginResponse);
                                return loginResponseObservable;
                            } else {
                                onRegisterListener.registerFailed(loginResponse.getErrorMsg());
                                return loginResponseObservable;
                            }
                        } else {
                            onRegisterListener.registerFailed("注册失败");
                            return null;
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        ELog.d("第二次网络请求成功");
                        if (onLoginListener != null) {
                            onLoginListener.loginSuccess(loginResponse);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable e) throws Exception {
                        ELog.d("登录失败");
                        if (onLoginListener != null) {
                            onLoginListener.loginFailed(e.getMessage());
                        }
                    }
                });

    }
}
