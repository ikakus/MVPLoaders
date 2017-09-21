package ikakus.com.loaderstest;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 9/21/17.
 */

@Module
public class AppModule {
    private Context mApp;

    public AppModule(@NonNull Context app) {
        this.mApp = app;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return mApp;
    }

    @Singleton
    @Provides
    public PresenterImpl providePresenter(){
        return new PresenterImpl();
    }
}
