package br.com.lince.singe.singecore.foo

import org.jetbrains.exposed.sql.Table

/**
 * The exposed definition of the table used to store foo
 */
object FooTable : Table("foo") {
    val uuid = varchar("uuid", 36)
    val bar = varchar("bar", 60)
    val bas = integer("bas")

    override val primaryKey = PrimaryKey(uuid)
}