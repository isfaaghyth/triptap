package hackathon.app.triptap.core.register;

import android.app.Activity;
import android.content.Context;

import com.google.firebase.auth.FirebaseUser;

import hackathon.app.triptap.base.BasePresenter;
import hackathon.app.triptap.core.main.MainActivity;
import hackathon.app.triptap.utils.CacheManager;
import hackathon.app.triptap.utils.StartNewActivities;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class RegisterPresenter extends BasePresenter<RegisterView> {

    public RegisterPresenter(RegisterView view) {
        super.attachView(view);
    }

    public void userisLogin(FirebaseUser user) {
        CacheManager.save("uuid", user.getUid());
        CacheManager.save("name", user.getDisplayName());
        CacheManager.save("email", user.getEmail());
        CacheManager.save("login", true);
    }

}