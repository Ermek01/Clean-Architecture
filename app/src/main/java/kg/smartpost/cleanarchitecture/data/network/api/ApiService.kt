package kg.smartpost.cleanarchitecture.data.network.api

import kg.smartpost.cleanarchitecture.data.network.students.model.ModelStudents
import retrofit2.http.GET

interface ApiService {

    @GET("api/characters/students")
    suspend fun getStudents(
    ): ModelStudents
}