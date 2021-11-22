package com.artesanoskuad.consumos.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemsDao {
    @Query("SELECT * FROM items")
    fun getAll(): List<Items>

    @Insert
    fun insertAll(vararg items: Items)

    @Update
    fun updateAll(vararg items: Items)
}