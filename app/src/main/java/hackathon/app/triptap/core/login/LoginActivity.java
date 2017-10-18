package hackathon.app.triptap.core.login;

import android.os.Bundle;
import android.widget.TextView;

import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;
import hackathon.app.triptap.utils.ProgressLoader;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @Override protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
    }

}