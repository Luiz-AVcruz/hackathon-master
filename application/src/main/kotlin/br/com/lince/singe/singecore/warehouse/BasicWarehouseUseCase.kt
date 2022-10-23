package br.com.lince.singe.singecore.warehouse

import com.github.f4b6a3.uuid.UuidCreator
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
open class BasicWarehouseUseCase(
    private val WarehouseRepository: WarehouseRepository,
) : WarehouseUseCase {
    override fun listAllWarehouses(): List<Warehouse> = WarehouseRepository.readAllWarehouses()

    override fun saveWarehouse(Warehouse: Warehouse): Warehouse {
        return if (Warehouse.uuid == null) {
            // Here we generate a new sequential uuid based in the time
            val generateUUID = UuidCreator.getTimeOrdered().toString()
            WarehouseRepository.createWarehouse(Warehouse.copy(uuid = generateUUID))
        } else {
            WarehouseRepository.updateWarehouse(Warehouse)
        }
    }

    override fun deleteWarehouseByUUID(uuid: String): Warehouse? {
        return try {
            val Warehouse = getWarehouseByUUID(uuid) ?: return null

            WarehouseRepository.deleteWarehouseByUUID(uuid)

            Warehouse
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getWarehouseByUUID(uuid: String): Warehouse? = WarehouseRepository.readWarehouseByUUID(uuid)
}