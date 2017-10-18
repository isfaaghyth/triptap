package hackathon.app.triptap.core.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
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
import hackathon.app.triptap.interfaces.AlertConfirmListener;
import hackathon.app.triptap.utils.EditTextPassword;
import hackathon.app.triptap.utils.StartNewActivities;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

    @BindView(R.id.edt_full_name) EditText edtFullName;
    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.txt_input_email) TextInputLayout txtInputEmail;
    @BindView(R.id.edt_phone_number) EditText edtPhoneNumber;
    @BindView(R.id.edt_password) EditTextPassword edtPassword;
    @BindView(R.id.txt_input_password) TextInputLayout txtInputPassword;
    @BindView(R.id.img_password_icon) ImageView imgPasswordIcon;
    @BindView(R.id.txt_title_toolbar) TextView txtTitleToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private FirebaseAuth mAuth;

    @Override protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_register);
        setToolbar(toolbar, true);
        mAuth = FirebaseAuth.getInstance();
        edtPassword.passwordToggle(imgPasswordIcon);
    }

    @Override protected void onStart() {
        super.onStart();
    }

    @OnClick(R.id.btn_register)
    public void onBtnRegisterClicked() {
        String name = edtFullName.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        UserProfileChangeRequest profile = new UserProfileChangeRequest
                                                                .Builder()
                                                                .setDisplayName(name)
                                                                .build();
                        user.updateProfile(profile);
                        showPopup(getString(R.string.successfully), new AlertConfirmListener() {
                            @Override public void yes() {
                                StartNewActivities.start(RegisterActivity.this, MainActivity.class);
                            }
                            @Override public void no() {}
                        });
                        presenter.userisLogin(user);
                    } else {
                        showPopup(getString(R.string.cannot_register));
                    }
                });
    }

    @OnClick(R.id.txt_login)
    public void onTxtLoginClicked() {

    }
}