package ikakus.com.loaderstest;

import android.util.Log;

/**
 * Created by ikakus on 9/21/17.
 */

public class PresenterImpl implements Presenter<MainView> {
    public PresenterImpl() {
        Log.d("Presenter", "Constructor call");
    }

    @Override
    public void onViewAttached(MainView view) {
        view.showToast();
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}
