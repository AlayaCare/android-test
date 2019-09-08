package alayacare.testapp.di


import org.koin.dsl.module

val localModule = module {
    //    single(DATABASE) { ArchAppDatabase.buildDatabase(androidContext()) }
//    factory { (get(DATABASE) as ArchAppDatabase).userDao() }
}
