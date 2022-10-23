package br.com.lince.singe.singecore.warehouse

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
open class ExposedWarehouseRepository : WarehouseRepository {
     override fun createWarehouse(Warehouse: Warehouse): Warehouse {
        return transaction {
            WarehouseTable.insert {
                it[uuid] = Warehouse.uuid!!
                it[name] = Warehouse.name
                it[address] = Warehouse.address
                it[cnpj] = Warehouse.cnpj
            }
            Warehouse
        }
    }

     fun createWarehouse(): Warehouse {
        TODO("Not yet implemented")
    }

    override fun updateWarehouse(Warehouse: Warehouse): Warehouse {
        return transaction {
            WarehouseTable.update({ WarehouseTable.uuid eq Warehouse.uuid!! }) {
                it[name] = Warehouse.name
                it[cnpj] = Warehouse.cnpj
                it[address] = Warehouse.address
            }
            Warehouse
        }
    }

    override fun readAllWarehouses(): List<Warehouse> {
        return transaction {
            WarehouseTable.selectAll().map {
                Warehouse(
                    it[WarehouseTable.uuid],
                    it[WarehouseTable.name],
                    it[WarehouseTable.address],
                    it[WarehouseTable.cnpj]
                )
            }
        }
    }

    override fun readWarehouseByUUID(uuid: String): Warehouse? {
        return transaction {
            WarehouseTable.select { WarehouseTable.uuid eq uuid }.firstOrNull()?.let {
                Warehouse(
                    it[WarehouseTable.uuid],
                    it[WarehouseTable.name],
                    it[WarehouseTable.address],
                    it[WarehouseTable.cnpj]
                )
            }
        }
    }

    override fun deleteWarehouseByUUID(uuid: String) {
        return transaction {
            WarehouseTable.deleteWhere { WarehouseTable.uuid eq uuid }
        }
    }
}