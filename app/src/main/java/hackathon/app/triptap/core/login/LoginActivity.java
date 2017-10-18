package hackathon.app.triptap.core.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import butterknife.BindView;
import butterknife.OnClick;
import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;
import hackathon.app.triptap.core.main.MainActivity;
import hackathon.app.triptap.core.register.RegisterActivity;
import hackathon.app.triptap.interfaces.AlertConfirmListener;
import hackathon.app.triptap.utils.EditTextPassword;
import hackathon.app.triptap.utils.StartNewActivities;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.img_password_icon) ImageView imgPasswordIcon;
    @BindView(R.id.txt_title_toolbar) TextView txtTitleToolbar;
    @BindView(R.id.edt_password) EditTextPassword edtPassword;
    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.txt_help) TextView txtHelp;
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
        edtPassword.passwordToggle(imgPasswordIcon);
    }

    @Override protected void onStart() {
        super.onStart();
    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked() {
        String email = edtEmail.getText().toString();
        String passowrd = edtPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, passowrd)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        showPopup(getString(R.string.successfully), new AlertConfirmListener() {
                            @Override public void yes() {
                                StartNewActivities.start(LoginActivity.this, MainActivity.class);
                            }
                            @Override public void no() {}
                        });
                        presenter.userisLogin(user);
                    } else {
                        showPopup(getString(R.string.cannot_login));
                    }
                });
    }
}