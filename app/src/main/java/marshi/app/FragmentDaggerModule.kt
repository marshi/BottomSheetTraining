package marshi.app

import dagger.Module

@Module(
    includes = [AppFragmentDaggerModule::class]
)
interface FragmentDaggerModule
