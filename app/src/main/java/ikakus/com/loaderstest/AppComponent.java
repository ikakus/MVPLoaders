package ikakus.com.loaderstest;

/**
 * Created by ikakus on 9/21/17.
 */

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
interface AppComponent {
    void inject(PresenterLoader tPresenterLoader);
}
