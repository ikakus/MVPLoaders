package ikakus.com.loaderstest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 9/21/17.
 */

@Module
public class AppModule {


    public AppModule() {
    }

    @Singleton
    @Provides
    public PresenterImpl providePresenter(){
        return new PresenterImpl();
    }
}
