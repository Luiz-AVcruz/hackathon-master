package br.com.lince.singe.singecore.packinglist

import org.jetbrains.exposed.sql.Table

/**
 * The exposed definition of the table used to store Packinglist
 */
object PackinglistTable : Table("Packinglist") {
    val uuid = varchar("uuid", 36)
    val boxNumber = integer("boxNumber")
    val color = varchar("color", 15)
    val article = varchar("article", 10)
    val quantity = integer("quantity")
    val netWeight = integer("netWeight")
    val grossWeight = integer("grossWeight")
    val batch = integer("batch")
    override val primaryKey = PrimaryKey(uuid)
}