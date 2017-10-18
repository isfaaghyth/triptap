package hackathon.app.triptap.core.intro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;
import hackathon.app.triptap.core.login.LoginActivity;
import hackathon.app.triptap.core.register.RegisterActivity;
import hackathon.app.triptap.utils.CustomViewPager;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class IntroActivity extends BaseActivity<IntroPresenter> implements IntroView {

    @BindView(R.id.viewpager_intro) CustomViewPager viewpagerIntro;
    @BindView(R.id.layoutDots) LinearLayout layoutDots;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.btn_register) TextView btnRegister;

    @Override protected IntroPresenter createPresenter() {
        return new IntroPresenter(this, this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_intro);
        presenter.setupViewPager(layoutDots, viewpagerIntro);
        presenter.isLogin(this);
    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btn_register)
    public void onBtnRegisterClicked() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

}