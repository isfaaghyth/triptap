package hackathon.app.triptap.core.register;

import android.os.Bundle;

import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

    @Override protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_register);
    }

}