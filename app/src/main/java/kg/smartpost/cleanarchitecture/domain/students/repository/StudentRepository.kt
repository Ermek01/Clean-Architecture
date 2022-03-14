package kg.smartpost.cleanarchitecture.domain.students.repository

import kg.smartpost.cleanarchitecture.domain.students.model.Students

interface StudentRepository {

    suspend fun getStudents(): List<Students>

//    suspend fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>
//
//    suspend fun addPraySchedules(praySchedules: List<PraySchedule>)
}