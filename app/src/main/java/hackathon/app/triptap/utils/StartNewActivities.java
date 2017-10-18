package hackathon.app.triptap.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class StartNewActivities {

    public static void start(Activity currentActivity, Class<? extends Activity> newTopActivityClass) {
        Intent intent = new Intent(currentActivity, newTopActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        currentActivity.startActivity(intent);
        currentActivity.finish();
    }

}
