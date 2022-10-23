package br.com.lince.singe.singecore.Product

import com.github.f4b6a3.uuid.UuidCreator
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
open class BasicProductUseCase(
    private val ProductRepository: ProductRepository,
) : ProductUseCase {
    override fun listAllProducts(): List<Product> = ProductRepository.readAllProducts()

    override fun saveProduct(Product: Product): Product {
        return if (Product.uuid == null) {
            // Here we generate a new sequential uuid based in the time
            val generateUUID = UuidCreator.getTimeOrdered().toString()
            ProductRepository.createProduct(Product.copy(uuid = generateUUID))
        } else {
            ProductRepository.updateProduct(Product)
        }
    }

    override fun deleteProductByUUID(uuid: String): Product? {
        return try {
            val Product = getProductByUUID(uuid) ?: return null

            ProductRepository.deleteProductByUUID(uuid)

            Product
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getProductByUUID(uuid: String): Product? = ProductRepository.readProductByUUID(uuid)
}