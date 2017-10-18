package hackathon.app.triptap.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hackathon.app.triptap.R;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class PlaceHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_item) public LinearLayout cardItem;
    @BindView(R.id.img_places) public ImageView imgPlaces;
    @BindView(R.id.txt_places_name) public TextView txtPlacesName;
    @BindView(R.id.rating_places) public RatingBar ratingPlaces;

    public PlaceHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
