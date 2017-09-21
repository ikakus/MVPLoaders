package ikakus.com.loaderstest;

import android.util.Log;

/**
 * Created by ikakus on 9/21/17.
 */

public class PresenterImpl implements Presenter<MainView> {
    int counter = 0;
    public PresenterImpl() {
        Log.d("Presenter", "Constructor call");
    }

    @Override
    public void onViewAttached(MainView view) {
        if(counter == 0) {
            view.showToast("Hello");
        }else {
            view.showToast(Integer.toString(counter));
        }
        counter++;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}
