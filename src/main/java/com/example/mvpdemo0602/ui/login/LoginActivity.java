package com.example.mvpdemo0602.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.mvpdemo0602.R;
import com.example.mvpdemo0602.ui.login.interactor.LoginInteractorImpl;
import com.example.mvpdemo0602.ui.login.presenter.LoginPresenter;
import com.example.mvpdemo0602.ui.login.presenter.LoginPresenterImpl;
import com.example.mvpdemo0602.ui.login.view.LoginView;
import com.example.mvpdemo0602.ui.main.Main2Activity;
import com.example.mvpdemo0602.ui.register.RegisterActivity;
import com.example.mvpdemo0602.view.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Bind(R.id.pb_login_progress_1)
    ProgressBar pbLoginProgress1;
    @Bind(R.id.et_login_user_name)
    EditText etLoginUserName;
    @Bind(R.id.et_login_user_password)
    EditText etLoginUserPassword;
    @Bind(R.id.sv_login_scroll_form)
    ScrollView svLoginScrollForm;
    @Bind(R.id.activity_login1)
    RelativeLayout activityLogin1;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        ButterKnife.bind(this);
        loginPresenter =new LoginPresenterImpl(this,new LoginInteractorImpl());
    }

    @OnClick({R.id.bn_login_loading, R.id.bn_login_data_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bn_login_loading:
                loginPresenter.validateCredentials(etLoginUserName.getText().toString().trim(),etLoginUserPassword.getText().toString());
                break;
            case R.id.bn_login_data_clear:
                loginPresenter.toRegister();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgressDialog() {
        pbLoginProgress1.setVisibility(View.VISIBLE);
        svLoginScrollForm.setVisibility(View.GONE);
    }

    @Override
    public void hindeProgressDialog() {
        pbLoginProgress1.setVisibility(View.GONE);
        svLoginScrollForm.setVisibility(View.VISIBLE);
    }

    @Override
    public void setUserNameError(int errorCode) {
        etLoginUserName.setError("content is null");
    }

    @Override
    public void setUserPasswordError(int errorCode) {
        etLoginUserPassword.setError("content is null");
    }

    /**
     * 去主页
     */
    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, Main2Activity.class));
    }

    /**
     * 去注册
     */
    @Override
    public void navigateToRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @Override
    public void viewToFinished() {
        this.finish();
    }
}
