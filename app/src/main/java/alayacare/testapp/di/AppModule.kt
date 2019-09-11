package alayacare.testapp.di

import alayacare.testapp.data.local.NoteLocalDataSource
import alayacare.testapp.data.remote.FakeApi
import alayacare.testapp.data.remote.NoteRemoteDataSource
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.home.vm.HomeViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { NoteLocalDataSource(get()) }

    factory { NoteRemoteDataSource(get())}
    factory { FakeApi() }

    // single instance of HelloRepository
    factory { NoteRepository(get(), get()) }

    // MyViewModel ViewModel}
//    viewModel { HomeViewModel(get())
    viewModel<HomeViewModel>()
}