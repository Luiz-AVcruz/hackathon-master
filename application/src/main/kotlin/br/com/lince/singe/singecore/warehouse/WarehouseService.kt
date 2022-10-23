package br.com.lince.singe.singecore.warehouse

/**
 * Defines the actions available for Warehouse in the system
 */
interface WarehouseService {
    /**
     * Returns all the Warehouses in the system
     */
    fun listAllWarehouses(): ListWarehouseResponse

    /**
     * Creates or updates Warehouse in the system
     */
    fun createOrUpdateWarehouse(Warehouse: Warehouse): WarehouseCreateResponse

    /**
     * Deletes the Warehouse
     */
    fun deleteWarehouseByUUID(uuid: String): WarehouseDeleteResponse
}