package hackathon.app.triptap.core.login;

import android.content.Context;

import hackathon.app.triptap.base.BasePresenter;
import hackathon.app.triptap.core.intro.IntroView;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

}