package com.example.imagesearchapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.imagesearchapp.models.Data

@Database(
    entities = [Data::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ImageDatabase : RoomDatabase() {
    abstract fun getImageDao(): ImageDatabaseDao

    companion object {
        @Volatile
        private var instance: ImageDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ImageDatabase::class.java, "image_db.db"
            ).allowMainThreadQueries().build()
    }

}