package com.artesanoskuad.consumos.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemsDao {
    @Query("SELECT * FROM items")
    suspend fun getAll(): List<Items>

    @Insert
    suspend fun insertAll(vararg items: Items)

    @Update
    suspend fun updateAll(vararg items: Items)
}