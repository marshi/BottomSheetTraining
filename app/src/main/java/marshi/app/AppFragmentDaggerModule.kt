package marshi.app

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.app.domain.PlusInterface

@Module
interface AppFragmentDaggerModule {

    @ContributesAndroidInjector(modules = [PlusModule::class])
    fun contributeAppFragment(): AppFragment
}

@Module
interface PlusModule {
    @Binds
    fun bindsPlus(plus: Plus): PlusInterface
}
