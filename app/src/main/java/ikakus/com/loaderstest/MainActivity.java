package ikakus.com.loaderstest;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<PresenterImpl>,
        MainView {


    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        presenter.onViewDetached();
        super.onStop();
    }

    @Override
    public Loader<PresenterImpl> onCreateLoader(int i, Bundle bundle) {
        return new PresenterLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<PresenterImpl> loader, PresenterImpl presenter) {
        this.presenter = presenter;
        // Ready to use presenter
        presenter.onViewAttached(this);

    }

    @Override
    public void onLoaderReset(Loader<PresenterImpl> loader) {
        this.presenter = null;
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
