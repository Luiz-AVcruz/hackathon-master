package br.com.lince.singe.singecore.packinglist

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@RestController
@RequestMapping("/Packinglist")
open class BasicPackinglistService(
    private val PackinglistUseCase: PackinglistUseCase
) : PackinglistService {
    @GetMapping("/all")
    override fun listAllPackinglists(): ListPackinglistResponse {
        return try {
            ListPackinglistResponse(PackinglistUseCase.listAllPackinglists())
        } catch (e: Exception) {
            ListPackinglistResponse(null, e.message)
        }
    }

    @PostMapping("/manage")
    override fun createOrUpdatePackinglist(@RequestBody Packinglist: Packinglist): PackinglistCreateResponse {
        return try {
            PackinglistCreateResponse(PackinglistUseCase.savePackinglist(Packinglist))
        } catch (e: Exception) {
            PackinglistCreateResponse(errorMessage = e.message)
        }
    }

    @DeleteMapping("/{uuid}")
    override fun deletePackinglistByUUID(@PathVariable("uuid") uuid: String): PackinglistDeleteResponse {
        return try {
            PackinglistDeleteResponse(PackinglistUseCase.deletePackinglistByUUID(uuid))
        } catch (e: Exception) {
            PackinglistDeleteResponse(errorMessage = e.message)
        }
    }
    @Configuration
    class WebConfiguration : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**").allowedMethods("*")
        }
    }

}