package kg.smartpost.cleanarchitecture.data.network.students.source.network

import kg.smartpost.cleanarchitecture.data.network.api.ApiService
import kg.smartpost.cleanarchitecture.data.network.students.mapper.StudentsResponseMapper.toPraySchedules
import kg.smartpost.cleanarchitecture.data.network.students.source.StudentsEntityData
import kg.smartpost.cleanarchitecture.domain.students.model.Students
import javax.inject.Inject

class NetworkStudentsEntityData @Inject constructor(
    private val apiService: ApiService
) : StudentsEntityData {

//    override suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
//        return prayApi.getPraySchedule(prayScheduleRequest.city, prayScheduleRequest.date)
//            .toPraySchedules()
//    }
//
//    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
//        //no op
//    }

    override suspend fun getStudents(): List<Students> {
        return apiService.getStudents()
            .toPraySchedules()
    }
}