package hackathon.app.triptap.core.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;
import hackathon.app.triptap.core.places.PlacesActivity;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.txt_title_toolbar) TextView txtTitleToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.edt_search) EditText edtSearch;

    @Override protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main);
    }

    @OnClick(R.id.btn_search)
    public void onBtnSearchClicked() {
        String searchQuery = edtSearch.getText().toString();
        Intent search = new Intent(this, PlacesActivity.class);
        search.putExtra("query", searchQuery);
        startActivity(search);
    }

}