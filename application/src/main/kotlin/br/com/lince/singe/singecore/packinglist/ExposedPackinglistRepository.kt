package br.com.lince.singe.singecore.packinglist

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
open class ExposedPackinglistRepository : PackinglistRepository {
     override fun createPackinglist(Packinglist: Packinglist): Packinglist {
        return transaction {
            PackinglistTable.insert {
                it[uuid] = Packinglist.uuid!!
                it[boxNumber] = Packinglist.boxNumber
                it[color] = Packinglist.color
                it[article] = Packinglist.article
                it[quantity] = Packinglist.quantity
                it[netWeight] = Packinglist.netWeight
                it[grossWeight] = Packinglist.grossWeight
                it[batch] = Packinglist.batch
            }
            Packinglist
        }
    }

     fun createPackinglist(): Packinglist {
        TODO("Not yet implemented")
    }

    override fun updatePackinglist(Packinglist: Packinglist): Packinglist {
        return transaction {
            PackinglistTable.update({ PackinglistTable.uuid eq Packinglist.uuid!! }) {
                it[boxNumber] = Packinglist.boxNumber
                it[color] = Packinglist.color
                it[article] = Packinglist.article
                it[quantity] = Packinglist.quantity
                it[netWeight] = Packinglist.netWeight
                it[grossWeight] = Packinglist.grossWeight
                it[batch] = Packinglist.batch
            }
            Packinglist
        }
    }

    override fun readAllPackinglists(): List<Packinglist> {
        return transaction {
            PackinglistTable.selectAll().map {
                Packinglist(
                    it[PackinglistTable.uuid],
                    it[PackinglistTable.boxNumber],
                    it[PackinglistTable.color],
                    it[PackinglistTable.article],
                    it[PackinglistTable.quantity],
                    it[PackinglistTable.netWeight],
                    it[PackinglistTable.grossWeight],
                    it[PackinglistTable.batch]
                )
            }
        }
    }

    override fun readPackinglistByUUID(uuid: String): Packinglist? {
        return transaction {
            PackinglistTable.select { PackinglistTable.uuid eq uuid }.firstOrNull()?.let {
                Packinglist(
                    it[PackinglistTable.uuid],
                    it[PackinglistTable.boxNumber],
                    it[PackinglistTable.color],
                    it[PackinglistTable.article],
                    it[PackinglistTable.quantity],
                    it[PackinglistTable.netWeight],
                    it[PackinglistTable.grossWeight],
                    it[PackinglistTable.batch]

                )
            }
        }
    }

    override fun deletePackinglistByUUID(uuid: String) {
        return transaction {
            PackinglistTable.deleteWhere { PackinglistTable.uuid eq uuid }
        }
    }
}