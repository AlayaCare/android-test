package alayacare.testapp.data.local

import alayacare.testapp.data.local.dao.NoteDao
import alayacare.testapp.data.model.Note
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    // DAO
    abstract fun noteDao(): NoteDao
}