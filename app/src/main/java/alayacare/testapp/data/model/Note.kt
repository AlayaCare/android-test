package alayacare.testapp.data.model

import androidx.room.Entity
import java.util.*

@Entity
data class Note(val time: Date, val text: String)