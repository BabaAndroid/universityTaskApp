package com.university.app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.university.app.data.model.UniversityItem

@Database(entities = [UniversityItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUniversityDao(): UniversityDAO

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "UniversityDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}
