package alayacare.testapp.di

import alayacare.testapp.data.local.AppDatabase
import androidx.room.Room
import org.koin.dsl.module

val localModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "NoteApp.db").build() }
    factory { get<AppDatabase>().noteDao() }
}
