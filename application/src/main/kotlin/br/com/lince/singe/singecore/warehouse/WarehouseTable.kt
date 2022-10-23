package br.com.lince.singe.singecore.warehouse

import org.jetbrains.exposed.sql.Table

/**
 * The exposed definition of the table used to store Warehouse
 */
object WarehouseTable : Table("Warehouse") {
    val uuid = varchar("uuid", 36)
    val name = varchar("name", 60)
    val address = varchar("address", 60)
    val cnpj = integer("cnpj")

    override val primaryKey = PrimaryKey(uuid)
}