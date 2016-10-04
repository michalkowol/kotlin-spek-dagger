package pl.michalkowol

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class Calc {
    fun sum(a: Int, b: Int): Int = a + b
    fun subtract(a: Int, b: Int): Int = a - b
}

interface Foo {
    fun foo(): String
}

class FooBar : Foo {
    override fun foo(): String = "fooBAR"
}

class FooBaz : Foo {
    override fun foo(): String = "FOObaz"
}

class App @Inject constructor(val calc: Calc, val foo: Foo) {
    fun start(): String {
        return "${calc.sum(1, 2)} ${foo.foo()}"
    }
}

@Module
class MyModule {
    @Provides
    fun calc(): Calc = Calc()

    @Singleton
    @Provides
    fun foo(): Foo = FooBar()
}

@Singleton
@Component(
    modules = arrayOf(MyModule::class)
)
interface AppCom {
    fun app(): App
}