package kg.smartpost.cleanarchitecture.data.network.students.mapper

import kg.smartpost.cleanarchitecture.data.network.students.model.ModelStudents
import kg.smartpost.cleanarchitecture.domain.students.model.Students

object StudentsResponseMapper {

    fun ModelStudents.toPraySchedules(): List<Students> {
        val students = ArrayList<Students>()
        forEach {
            students.add(Students(it.name, it.house, it.image))
        }

//        val city =
//        results?.datetime?.forEach {
//            val dayStr = it?.date?.gregorian ?: "2000-01-01"
//
//            it?.times?.let { times ->
//                praySchedules
//                    .add(PraySchedule(city, "Fajr", TimeUtil.setTime(dayStr, times.Fajr)))
//                praySchedules
//                    .add(PraySchedule(city, "Dhuhr", TimeUtil.setTime(dayStr, times.Dhuhr)))
//                praySchedules
//                    .add(PraySchedule(city, "Asr", TimeUtil.setTime(dayStr, times.Asr)))
//                praySchedules
//                    .add(PraySchedule(city, "Maghrib", TimeUtil.setTime(dayStr, times.Maghrib)))
//                praySchedules
//                    .add(PraySchedule(city, "Isha", TimeUtil.setTime(dayStr, times.Isha)))
//            }
//        }

        return students
    }
}