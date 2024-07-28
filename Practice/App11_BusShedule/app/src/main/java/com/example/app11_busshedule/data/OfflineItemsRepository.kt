package com.example.app11_busshedule.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val accessDao: AccessDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<BusEntity>> = accessDao.getAllItems()

    override fun getItemStream(id: Int): Flow<BusEntity?> = accessDao.getItem(id)

    override suspend fun insertItem(busEntity: BusEntity) = accessDao.insert(busEntity)

    override suspend fun deleteItem(busEntity: BusEntity) = accessDao.delete(busEntity)

    override suspend fun updateItem(busEntity: BusEntity) = accessDao.update(busEntity)
}
