package hackathon.app.triptap.core.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.OnClick;
import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edt_username) EditText edtUsername;
    @BindView(R.id.edt_password) EditText edtPassword;
    @BindView(R.id.txt_help) TextView txtHelp;
    @BindView(R.id.txt_title_toolbar) TextView txtTitleToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private FirebaseAuth mAuth;

    @Override protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
        setToolbar(toolbar, true);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @OnClick(R.id.btn_login) public void onViewClicked() {
    }
}