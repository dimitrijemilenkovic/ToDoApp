package rs.metropolitan.todoapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.metropolitan.todoapp.data.network.ApiService
import rs.metropolitan.todoapp.data.repository.TaskRepository
import javax.inject.Singleton
import rs.metropolitan.todoapp.data.util.Constants.BASE_URL


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTaskRepository(api:ApiService) = TaskRepository(api)

    @Singleton
    @Provides
    fun provideTaskApi():ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }



}