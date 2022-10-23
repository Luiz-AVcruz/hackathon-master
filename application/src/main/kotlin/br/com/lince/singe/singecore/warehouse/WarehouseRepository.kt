package br.com.lince.singe.singecore.warehouse

/**
 * Defines the CRUD operations
 */
interface WarehouseRepository {

    fun createWarehouse(Warehouse: Warehouse): Warehouse

    fun updateWarehouse(Warehouse: Warehouse): Warehouse

    fun readAllWarehouses(): List<Warehouse>

    fun readWarehouseByUUID(uuid: String): Warehouse?

    fun deleteWarehouseByUUID(uuid: String)
}