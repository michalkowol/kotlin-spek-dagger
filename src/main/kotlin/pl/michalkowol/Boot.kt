package pl.michalkowol

import pl.michalkowol.DaggerAppCom

fun main(args: Array<String>) {
    val appCom = DaggerAppCom.builder().myModule(MyModule()).build()
    println(appCom.app().start())
}