package com.example.app12_flightsearch.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<FlightData>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<FlightData?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(flightData: FlightData)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(flightData: FlightData)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(flightData: FlightData)

//    Search only specific items
    fun getSearchItemStream(fromAirportName: String): Flow<List<FlightData>>

    //    Return only specific items
    fun getRelatedItemStream(fromAirportName: String): Flow<List<FlightData>>
}
