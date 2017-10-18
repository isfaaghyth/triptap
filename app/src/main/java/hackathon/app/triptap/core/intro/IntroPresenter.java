package hackathon.app.triptap.core.intro;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import hackathon.app.triptap.R;
import hackathon.app.triptap.adapter.IntroPagerAdapter;
import hackathon.app.triptap.base.BasePresenter;
import hackathon.app.triptap.core.main.MainActivity;
import hackathon.app.triptap.utils.CacheManager;
import hackathon.app.triptap.utils.CustomViewPager;
import hackathon.app.triptap.utils.StartNewActivities;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */
public class IntroPresenter extends BasePresenter<IntroView> {

    private Context context;
    private TextView[] dots;
    private int[] layouts;

    public IntroPresenter(IntroView view, Context context) {
        this.context = context;
        super.attachView(view);
    }

    public void isLogin(Activity activity) {
        if (!CacheManager.checkExist("login")) return;
        if (CacheManager.grabBoolean("login")) {
            StartNewActivities.start(activity, MainActivity.class);
        }
    }

    public void setupViewPager(LinearLayout layoutDots, CustomViewPager vp) {
        layouts = new int[]{
                R.layout.slider_intro_two,
                R.layout.slider_intro_one
        };
        addBottomDots(layoutDots, 0);
        vp.setAdapter(new IntroPagerAdapter(context, layouts));
        int[] finalLayouts = layouts;
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override public void onPageSelected(int position) {
                addBottomDots(layoutDots, position);
            }
            @Override public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override public void onPageScrollStateChanged(int arg0) {}
        });
    }

    private void addBottomDots(LinearLayout layoutDots, int currentPage) {
        dots = new TextView[layouts.length];
        int[] colorsActive = context.getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = context.getResources().getIntArray(R.array.array_dot_inactive);
        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            layoutDots.addView(dots[i]);
        }
        if (dots.length > 0) dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

}