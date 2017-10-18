package hackathon.app.triptap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P createPresenter();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void binding(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        presenter = createPresenter();
    }

    protected void setToolbar(Toolbar toolbar, boolean isHomeButton) {
        setSupportActionBar(toolbar);
        if (isHomeButton) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}
