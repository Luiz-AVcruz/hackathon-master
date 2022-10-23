package br.com.lince.singe.singecore.Product

import org.jetbrains.exposed.sql.Table

/**
 * The exposed definition of the table used to store Product
 */
object ProductTable : Table("Product") {
    val uuid = varchar("uuid", 36)
    val productCode = integer("productCode")
    val name = varchar("name", 60)
    val colorCode = integer("colorCode")
    val color = varchar("color", 15)
    val quantity = integer("quantity")
    val netWeight = integer("netWeight")
    val grossWeight = integer("grossWeight")
    val price = double("price")
    override val primaryKey = PrimaryKey(uuid)
}