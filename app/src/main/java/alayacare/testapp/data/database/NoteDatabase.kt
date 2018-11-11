package alayacare.testapp.data.database

import alayacare.testapp.data.model.Note
import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(applicationContext: Application): NoteDatabase {
            if (INSTANCE == null) {
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(applicationContext,
                            NoteDatabase::class.java, "notes.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}