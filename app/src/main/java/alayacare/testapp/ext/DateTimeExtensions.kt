package alayacare.testapp.ext

import java.util.*

fun Long.randomSecondsFromNow(): Date {
    val seedDate: Date= Calendar.getInstance().time
    val random: Long = -this +
            (Math.random() * (this * 2)).toLong()
    return Date(seedDate.time + random)
}