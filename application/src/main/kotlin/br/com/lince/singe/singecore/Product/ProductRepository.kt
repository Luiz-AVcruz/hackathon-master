package br.com.lince.singe.singecore.Product

/**
 * Defines the CRUD operations
 */
interface ProductRepository {

    fun createProduct(Product: Product): Product

    fun updateProduct(Product: Product): Product

    fun readAllProducts(): List<Product>

    fun readProductByUUID(uuid: String): Product?

    fun deleteProductByUUID(uuid: String)
}