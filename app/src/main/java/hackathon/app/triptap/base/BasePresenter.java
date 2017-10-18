package hackathon.app.triptap.base;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {
    public V view;
    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;

    public void attachView(V view) {
        this.view = view;
    }

    public void dettachView() {
        this.view = null;
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
            Log.e("Base Presenter", "onUnsubscribe: ");
            stop();
        }
    }

    protected void addSubscribe(Observable observable, Subscriber subscriber) {
        this.subscriber = subscriber;

        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        try {
            compositeSubscription.add(observable
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber));
        } catch (Exception ignored) {}
    }

    protected void stop() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}
