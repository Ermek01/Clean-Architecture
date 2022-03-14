package kg.smartpost.cleanarchitecture.data.network.students.factory

import kg.smartpost.cleanarchitecture.data.network.students.source.StudentsEntityData
import kg.smartpost.cleanarchitecture.data.network.students.source.network.NetworkStudentsEntityData
import kg.smartpost.cleanarchitecture.util.Source
import javax.inject.Inject

class StudentsFactory @Inject constructor(
    private val networkStudentsEntityData: NetworkStudentsEntityData,
    //private val localScheduleEntityData: LocalScheduleEntityData
) {

    fun create(source: Source): StudentsEntityData? {
        if (source == Source.NETWORK) {
            return networkStudentsEntityData
        }
        else {
            return null
        }
//        return when (source) {
//            Source.NETWORK -> networkStudentsEntityData
//            else -> localScheduleEntityData
//        }
    }
}