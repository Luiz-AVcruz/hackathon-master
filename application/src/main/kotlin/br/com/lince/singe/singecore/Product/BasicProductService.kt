package br.com.lince.singe.singecore.Product

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@RestController
@RequestMapping("/Product")
open class BasicProductService(
    private val ProductUseCase: ProductUseCase
) : ProductService {
    @GetMapping("/all")
    override fun listAllProducts(): ListProductResponse {
        return try {
            ListProductResponse(ProductUseCase.listAllProducts())
        } catch (e: Exception) {
            ListProductResponse(null, e.message)
        }
    }

    @PostMapping("/manage")
    override fun createOrUpdateProduct(@RequestBody Product: Product): ProductCreateResponse {
        return try {
            ProductCreateResponse(ProductUseCase.saveProduct(Product))
        } catch (e: Exception) {
            ProductCreateResponse(errorMessage = e.message)
        }
    }

    @DeleteMapping("/{uuid}")
    override fun deleteProductByUUID(@PathVariable("uuid") uuid: String): ProductDeleteResponse {
        return try {
            ProductDeleteResponse(ProductUseCase.deleteProductByUUID(uuid))
        } catch (e: Exception) {
            ProductDeleteResponse(errorMessage = e.message)
        }
    }
    @Configuration
    class WebConfiguration : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**").allowedMethods("*")
        }
    }

}