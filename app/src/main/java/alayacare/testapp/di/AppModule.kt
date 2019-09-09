package alayacare.testapp.di

import alayacare.testapp.data.remote.NoteRemoteDataSource
import alayacare.testapp.data.repository.NoteRepository
import alayacare.testapp.home.vm.HomeViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { NoteRemoteDataSource() }

    // single instance of HelloRepository
    factory { NoteRepository(get()) }

    // MyViewModel ViewModel}
//    viewModel { HomeViewModel(get())
    viewModel<HomeViewModel>()
}