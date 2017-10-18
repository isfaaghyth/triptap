package hackathon.app.triptap.utils;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;

import hackathon.app.triptap.R;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class EditTextPassword extends EditText {

    private boolean isToggle = false;

    public EditTextPassword(Context context) {
        super(context);
    }

    public EditTextPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextPassword(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setToggle(boolean toggle) {
        isToggle = toggle;
    }

    public void passwordToggle(ImageView imgToogle) {
        imgToogle.setOnClickListener(view -> {
            if (isToggle) {
                setToggle(false);
                imgToogle.setImageResource(R.mipmap.ic_password_show);
                this.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                this.setSelection(this.length());
            } else {
                setToggle(true);
                imgToogle.setImageResource(R.mipmap.ic_password_hide);
                this.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                this.setSelection(this.length());
            }
        });
    }
}