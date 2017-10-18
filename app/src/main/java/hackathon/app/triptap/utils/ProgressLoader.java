package hackathon.app.triptap.utils;

import android.app.ProgressDialog;
import android.content.Context;

import hackathon.app.triptap.R;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class ProgressLoader {
    private ProgressDialog mProgressDialog;
    private Context context;

    public ProgressLoader(Context context) {
        this.context = context;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(context.getString(R.string.loading)+"...");
    }

    public void show(){
        mProgressDialog.show();
    }

    public void hide(){
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }
}
