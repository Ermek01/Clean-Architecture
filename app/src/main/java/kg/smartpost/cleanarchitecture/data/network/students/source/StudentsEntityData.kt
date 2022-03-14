package kg.smartpost.cleanarchitecture.data.network.students.source

import kg.smartpost.cleanarchitecture.domain.students.model.Students

interface StudentsEntityData {

    suspend fun getStudents(): List<Students>

    //suspend fun addPraySchedules(praySchedules: List<PraySchedule>)
}