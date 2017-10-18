package hackathon.app.triptap.core.login;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;

import hackathon.app.triptap.base.BasePresenter;
import hackathon.app.triptap.core.intro.IntroView;
import hackathon.app.triptap.utils.CacheManager;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

    public void userisLogin(FirebaseUser user) {
        CacheManager.save("uuid", user.getUid());
        CacheManager.save("name", user.getDisplayName());
        CacheManager.save("email", user.getEmail());
        CacheManager.save("login", true);
    }

}