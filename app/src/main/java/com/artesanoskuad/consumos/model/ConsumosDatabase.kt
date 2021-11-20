package com.artesanoskuad.consumos.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Items::class], version = 1)
abstract class ConsumosDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao
}