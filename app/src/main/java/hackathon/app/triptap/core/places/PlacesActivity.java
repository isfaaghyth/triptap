package hackathon.app.triptap.core.places;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import hackathon.app.triptap.R;
import hackathon.app.triptap.base.BaseActivity;
import hackathon.app.triptap.holder.PlaceHolder;
import hackathon.app.triptap.models.PlaceModel;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class PlacesActivity extends BaseActivity<PlacesPresenter> implements PlacesView {

    @BindView(R.id.txt_title_toolbar) TextView txtTitleToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.lst_places) RecyclerView lstPlaces;
    @BindView(R.id.txt_not_found) TextView txtNotFound;

    FirebaseDatabase mFirebaseDb;
    DatabaseReference mDbRef;
    FirebaseRecyclerAdapter<PlaceModel, PlaceHolder> adapter;

    @Override protected PlacesPresenter createPresenter() {
        return new PlacesPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_places);
        lstPlaces.setLayoutManager(new GridLayoutManager(this, 2));
        txtTitleToolbar.setText("Search: "+getIntent().getStringExtra("query"));
        getData(getIntent().getStringExtra("query"));
    }

    private void getData(String query) {
        mFirebaseDb = FirebaseDatabase.getInstance();
        mDbRef = mFirebaseDb.getReference();
        adapter = new FirebaseRecyclerAdapter<PlaceModel, PlaceHolder>(
                PlaceModel.class, R.layout.cardview_item, PlaceHolder.class,
                mDbRef.child("places")) {
            @Override protected void populateViewHolder(PlaceHolder holder, PlaceModel model, int position) {
                Glide.with(PlacesActivity.this)
                        .load(model.getImage())
                        .centerCrop()
                        .into(holder.imgPlaces);
                holder.txtPlacesName.setText(model.getName());
                holder.ratingPlaces.setRating(model.getRating());
            }
        };
        lstPlaces.setAdapter(adapter);
    }

}