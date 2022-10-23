package br.com.lince.singe.singecore.Product

/**
 * Defines the actions available for Product in the system
 */
interface ProductService {
    /**
     * Returns all the Products in the system
     */
    fun listAllProducts(): ListProductResponse

    /**
     * Creates or updates Product in the system
     */
    fun createOrUpdateProduct(Product: Product): ProductCreateResponse

    /**
     * Deletes the Product
     */
    fun deleteProductByUUID(uuid: String): ProductDeleteResponse
}