package com.example.app11_busshedule.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AccessDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(busEntity: BusEntity)

    @Update
    suspend fun update(busEntity: BusEntity)

    @Delete
    suspend fun delete(busEntity: BusEntity)

    @Query("SELECT * FROM bus_detail WHERE id = :id")
    fun getItem(id: Int): Flow<BusEntity>

    @Query("SELECT * from bus_detail ORDER BY busTime ASC")
    fun getAllItems(): Flow<List<BusEntity>>
}