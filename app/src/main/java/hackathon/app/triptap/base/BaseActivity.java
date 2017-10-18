package hackathon.app.triptap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import hackathon.app.triptap.R;
import hackathon.app.triptap.interfaces.AlertConfirmListener;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P createPresenter();
    private AlertDialog.Builder alert;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void binding(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        presenter = createPresenter();
        alert = new AlertDialog.Builder(this);
    }

    protected void setToolbar(Toolbar toolbar, boolean isHomeButton) {
        setSupportActionBar(toolbar);
        if (isHomeButton) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }

    public void showPopup(String message) {
        alert.setTitle(getString(R.string.app_name));
        alert.setMessage(message);
        alert.setNegativeButton(getString(R.string.close), (dialog, which) -> {});
        alert.show();
    }

    public void showPopup(String message, AlertConfirmListener listener) {
        alert.setTitle(getString(R.string.app_name));
        alert.setMessage(message);
        alert.setNegativeButton(getString(R.string.close), (dialog, which) -> listener.no());
        alert.setPositiveButton(getString(R.string.yes), (dialog, which) -> listener.yes());
        alert.show();
    }
}
