package ikakus.com.loaderstest;

import android.content.Context;
import android.content.Loader;

import javax.inject.Inject;

/**
 * Created by ikakus on 9/21/17.
 */

public class PresenterLoader extends Loader<PresenterImpl> {
    @Inject
    PresenterImpl presenter;
    private AppComponent mAppComponent;

    public PresenterLoader(Context context) {
        super(context);
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        mAppComponent.inject(this);
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
