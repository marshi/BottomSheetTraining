package marshi.app

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatcher: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder()
            .app(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatcher
    }

}
