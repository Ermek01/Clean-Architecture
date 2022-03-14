package kg.smartpost.cleanarchitecture.domain.students.usecase

import kg.smartpost.cleanarchitecture.domain.students.model.Students
import kg.smartpost.cleanarchitecture.domain.students.repository.StudentRepository
import javax.inject.Inject

class GetStudents @Inject constructor(
    private val studentRepository: StudentRepository
) {

    suspend fun execute(): List<Students> {
        return getStudents()
//        return getPrayScheduleFromLocal(request).ifEmpty {
//            val praySchedulesMonthly = getPraySchedulesFromNetwork(request)
//
//            scheduleRepository.addPraySchedules(praySchedulesMonthly)
//            getPrayScheduleFromLocal(request)
//        }
    }
//
//    private suspend fun getPrayScheduleFromLocal(param: PrayScheduleRequest): List<PraySchedule> {
//        return scheduleRepository.getPrayScheduleFromLocal(param)
//    }

    private suspend fun getStudents(): List<Students> {
        return studentRepository.getStudents()
    }
}