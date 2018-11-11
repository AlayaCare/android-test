package alayacare.testapp.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(val note: String,
                val time: Long,
                @PrimaryKey(autoGenerate = true) var id: Int = 0)