package com.example.imagesearchapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imagesearchapp.models.Data


@Dao
interface ImageDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(data: Data)

    @Query("SELECT * FROM data WHERE account_id = :accountId ")
    fun getComment(accountId : Integer) : Data
}