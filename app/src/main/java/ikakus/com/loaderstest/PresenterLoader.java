package ikakus.com.loaderstest;

import android.content.Context;
import android.content.Loader;

/**
 * Created by ikakus on 9/21/17.
 */

public class PresenterLoader<T extends Presenter> extends Loader<T> {
    private T presenter;


    public PresenterLoader(Context context, T presenter) {
        super(context);
        this.presenter = presenter;
    }

    @Override
    protected void onStartLoading() {
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter.onDestroyed();
        presenter = null;
    }
}
