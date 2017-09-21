package ikakus.com.loaderstest;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<PresenterImpl>,
        MainView {

    @Inject
    PresenterImpl presenter;
    private AppComponent mAppComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Ready to use presenter
        presenter.onViewAttached(this);
    }

    @Override
    protected void onStop() {
        presenter.onViewDetached();
        super.onStop();
    }

    @Override
    public Loader<PresenterImpl> onCreateLoader(int i, Bundle bundle) {
        return new PresenterLoader<>(this, presenter);
    }

    @Override
    public void onLoadFinished(Loader<PresenterImpl> loader, PresenterImpl presenter) {
        this.presenter = presenter;

    }

    @Override
    public void onLoaderReset(Loader<PresenterImpl> loader) {
        this.presenter = null;
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}
