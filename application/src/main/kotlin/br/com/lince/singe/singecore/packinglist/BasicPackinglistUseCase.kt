package br.com.lince.singe.singecore.packinglist

import com.github.f4b6a3.uuid.UuidCreator
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
open class BasicPackinglistUseCase(
    private val PackinglistRepository: PackinglistRepository,
) : PackinglistUseCase {
    override fun listAllPackinglists(): List<Packinglist> = PackinglistRepository.readAllPackinglists()

    override fun savePackinglist(Packinglist: Packinglist): Packinglist {
        return if (Packinglist.uuid == null) {
            // Here we generate a new sequential uuid based in the time
            val generateUUID = UuidCreator.getTimeOrdered().toString()
            PackinglistRepository.createPackinglist(Packinglist.copy(uuid = generateUUID))
        } else {
            PackinglistRepository.updatePackinglist(Packinglist)
        }
    }

    override fun deletePackinglistByUUID(uuid: String): Packinglist? {
        return try {
            val Packinglist = getPackinglistByUUID(uuid) ?: return null

            PackinglistRepository.deletePackinglistByUUID(uuid)

            Packinglist
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getPackinglistByUUID(uuid: String): Packinglist? = PackinglistRepository.readPackinglistByUUID(uuid)
}