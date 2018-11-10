package alayacare.testapp.utils

import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "MMMM dd, yyyy - HH:mm"
fun getFormattedDate(milliseconds: Long, dateFormat: String): String {
    val formatter = SimpleDateFormat(dateFormat)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = milliseconds
    return formatter.format(calendar.time)
}