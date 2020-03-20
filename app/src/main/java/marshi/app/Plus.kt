package marshi.app

import marshi.app.domain.PlusInterface
import javax.inject.Inject

class Plus @Inject constructor() : PlusInterface {
    override fun exec(a: Int, b: Int) = a + b
}