package com.example.app12_flightsearch.data

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
    suspend fun insert(flightData: FlightData)

    @Update
    suspend fun update(flightData: FlightData)

    @Delete
    suspend fun delete(flightData: FlightData)

    @Query("SELECT * FROM flight_data WHERE id = :id")
    fun getItem(id: Int): Flow<FlightData>

    @Query("SELECT * from flight_data ORDER BY id ASC")
    fun getAllItems(): Flow<List<FlightData>>

    @Query("SELECT * FROM flight_data WHERE LOWER(fromAirportName) LIKE LOWER(:fromAirportName)")
    fun getSearchItem(fromAirportName: String): Flow<List<FlightData>>

    @Query("SELECT * FROM flight_data WHERE LOWER(fromAirportName) = LOWER(:fromAirportName)")
    fun getRelatedItem(fromAirportName: String): Flow<List<FlightData>>
}