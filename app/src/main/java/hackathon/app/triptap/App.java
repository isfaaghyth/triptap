package hackathon.app.triptap;

import android.app.Application;
import android.content.Context;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class App extends Application {

    private static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
