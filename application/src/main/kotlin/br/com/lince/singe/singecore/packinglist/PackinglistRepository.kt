package br.com.lince.singe.singecore.packinglist

/**
 * Defines the CRUD operations
 */
interface PackinglistRepository {

    fun createPackinglist(Packinglist: Packinglist): Packinglist

    fun updatePackinglist(Packinglist: Packinglist): Packinglist

    fun readAllPackinglists(): List<Packinglist>

    fun readPackinglistByUUID(uuid: String): Packinglist?

    fun deletePackinglistByUUID(uuid: String)
}