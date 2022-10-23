package br.com.lince.singe.singecore.packinglist

/**
 * Defines the actions available for Packinglist in the system
 */
interface PackinglistService {
    /**
     * Returns all the Packinglists in the system
     */
    fun listAllPackinglists(): ListPackinglistResponse

    /**
     * Creates or updates Packinglist in the system
     */
    fun createOrUpdatePackinglist(Packinglist: Packinglist): PackinglistCreateResponse

    /**
     * Deletes the Packinglist
     */
    fun deletePackinglistByUUID(uuid: String): PackinglistDeleteResponse
}