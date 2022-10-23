package br.com.lince.singe.singecore.packinglist

/**
 * The actions allowed to be performed with Packinglist
 */
interface PackinglistUseCase {
    /**
     * Returns all Packinglists in the system
     */
    fun listAllPackinglists(): List<Packinglist>

    /**
     * Save the Packinglist data in the application
     */
    fun savePackinglist(Packinglist: Packinglist): Packinglist

    /**
     * Delete the Packinglist with the provided UUID
     */
    fun deletePackinglistByUUID(uuid: String): Packinglist?

    /**
     * Returns the Packinglist with the provided UUID
     */
    fun getPackinglistByUUID(uuid: String): Packinglist?
}