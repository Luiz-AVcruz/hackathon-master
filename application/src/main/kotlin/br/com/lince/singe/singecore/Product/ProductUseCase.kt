package br.com.lince.singe.singecore.Product

/**
 * The actions allowed to be performed with Product
 */
interface ProductUseCase {
    /**
     * Returns all Products in the system
     */
    fun listAllProducts(): List<Product>

    /**
     * Save the Product data in the application
     */
    fun saveProduct(Product: Product): Product

    /**
     * Delete the Product with the provided UUID
     */
    fun deleteProductByUUID(uuid: String): Product?

    /**
     * Returns the Product with the provided UUID
     */
    fun getProductByUUID(uuid: String): Product?
}