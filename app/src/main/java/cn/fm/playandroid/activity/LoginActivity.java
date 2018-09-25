package cn.fm.playandroid.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.fm.playandroid.R;
import cn.fm.playandroid.base.BaseActivity;
import cn.fm.playandroid.bean.LoginResponse;
import cn.fm.playandroid.log.ELog;
import cn.fm.playandroid.presenter.UserPresenterImpl;
import cn.fm.playandroid.view.LoginView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private Button btnRegister, btnLogin;
    private EditText edtUserName, edtPassword;

    private UserPresenterImpl loginPresenter;

    private SweetAlertDialog sweetAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new UserPresenterImpl(this);
        initUI();
    }

    private void initUI() {
        btnRegister = findViewById(R.id.register);
        btnLogin = findViewById(R.id.login);
        edtUserName = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void cancelRequest() {
        ELog.d("cancelRequest");
        loginPresenter.cancalRequest();
    }

    @Override
    public void loginSuccess(LoginResponse result) {
        ELog.d("loginSuccess");
    }

    @Override
    public void loginFailed(String errorMessage) {
        ELog.d("loginFailed:");
    }

    @Override
    public void registerSuccess(LoginResponse result) {
        ELog.d("registerSuccess:");
    }

    @Override
    public void registerFailed(String errorMessage) {
        ELog.d("registerFailed:");
    }

    @Override
    public void loginRegisterAfter(LoginResponse result) {
        ELog.d("loginRegisterAfter:");
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.register) {
            register();
        } else if (id == R.id.login) {
            login();
        }
    }


    private void login() {
        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("用户名或密码不能为空...");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.show();
        }
        loginPresenter.loginWanAndroid(username, password);
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("正在登录...");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    private void register() {
        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("用户名或密码不能为空...");
            sweetAlertDialog.setCancelable(true);
            sweetAlertDialog.show();
        }
        loginPresenter.registerAutoLogin(username, password, password);
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("正在注册...");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }
}
