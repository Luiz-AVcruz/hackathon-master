package br.com.lince.singe.singecore.warehouse

/**
 * The actions allowed to be performed with Warehouse
 */
interface WarehouseUseCase {
    /**
     * Returns all Warehouses in the system
     */
    fun listAllWarehouses(): List<Warehouse>

    /**
     * Save the Warehouse data in the application
     */
    fun saveWarehouse(Warehouse: Warehouse): Warehouse

    /**
     * Delete the Warehouse with the provided UUID
     */
    fun deleteWarehouseByUUID(uuid: String): Warehouse?

    /**
     * Returns the Warehouse with the provided UUID
     */
    fun getWarehouseByUUID(uuid: String): Warehouse?
}