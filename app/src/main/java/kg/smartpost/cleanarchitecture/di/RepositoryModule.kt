package kg.smartpost.cleanarchitecture.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kg.smartpost.cleanarchitecture.data.network.students.repository.StudentRepositoryImpl
import kg.smartpost.cleanarchitecture.domain.students.repository.StudentRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindStudentRepository(scheduleRepositoryImpl: StudentRepositoryImpl): StudentRepository
}