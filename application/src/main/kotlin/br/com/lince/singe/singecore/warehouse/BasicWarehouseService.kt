package br.com.lince.singe.singecore.warehouse

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@RestController
@RequestMapping("/Warehouse")
open class BasicWarehouseService(
    private val WarehouseUseCase: WarehouseUseCase
) : WarehouseService {
    @GetMapping("/all")
    override fun listAllWarehouses(): ListWarehouseResponse {
        return try {
            ListWarehouseResponse(WarehouseUseCase.listAllWarehouses())
        } catch (e: Exception) {
            ListWarehouseResponse(null, e.message)
        }
    }

    @PostMapping("/manage")
    override fun createOrUpdateWarehouse(@RequestBody Warehouse: Warehouse): WarehouseCreateResponse {
        return try {
            WarehouseCreateResponse(WarehouseUseCase.saveWarehouse(Warehouse))
        } catch (e: Exception) {
            WarehouseCreateResponse(errorMessage = e.message)
        }
    }

    @DeleteMapping("/{uuid}")
    override fun deleteWarehouseByUUID(@PathVariable("uuid") uuid: String): WarehouseDeleteResponse {
        return try {
            WarehouseDeleteResponse(WarehouseUseCase.deleteWarehouseByUUID(uuid))
        } catch (e: Exception) {
            WarehouseDeleteResponse(errorMessage = e.message)
        }
    }
    @Configuration
    class WebConfiguration : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**").allowedMethods("*")
        }
    }

}