package com.example.app12_flightsearch.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val accessDao: AccessDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<FlightData>> = accessDao.getAllItems()

    override fun getItemStream(id: Int): Flow<FlightData?> = accessDao.getItem(id)

    override suspend fun insertItem(flightData: FlightData) = accessDao.insert(flightData)

    override suspend fun deleteItem(flightData: FlightData) = accessDao.delete(flightData)

    override suspend fun updateItem(flightData: FlightData) = accessDao.update(flightData)

    override fun getSearchItemStream(fromAirportName: String): Flow<List<FlightData>> {
        val formattedName = "%${fromAirportName}%"
        return accessDao.getSearchItem(formattedName)
    }

    override fun getRelatedItemStream(fromAirportName: String): Flow<List<FlightData>> = accessDao.getRelatedItem(fromAirportName)
}