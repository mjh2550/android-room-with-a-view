package com.example.android.roomwordssample.book.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataModule {


    @Provides
    fun testString () : String{
        return "testString "
    }
}