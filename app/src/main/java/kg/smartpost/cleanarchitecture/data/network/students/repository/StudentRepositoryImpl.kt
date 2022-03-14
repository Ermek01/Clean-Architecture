package kg.smartpost.cleanarchitecture.data.network.students.repository


import kg.smartpost.cleanarchitecture.domain.students.repository.StudentRepository
import kg.smartpost.cleanarchitecture.data.network.students.factory.StudentsFactory
import kg.smartpost.cleanarchitecture.domain.students.model.Students
import kg.smartpost.cleanarchitecture.util.Source
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentsFactory: StudentsFactory
) : StudentRepository {

//    override suspend fun getPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
//        return studentsFactory.create(Source.NETWORK).getPraySchedule(prayScheduleRequest)
//    }
//
//    override suspend fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
//        return scheduleFactory.create(Source.LOCAL).getPraySchedule(prayScheduleRequest)
//    }
//
//    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
//        scheduleFactory.create(Source.LOCAL).addPraySchedules(praySchedules)
//    }

    override suspend fun getStudents(): List<Students> {
        return studentsFactory.create(Source.NETWORK)!!.getStudents()
    }
}