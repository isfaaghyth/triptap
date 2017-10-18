package hackathon.app.triptap.core.main;

import android.os.Bundle;

import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main_gambar);
    }

}