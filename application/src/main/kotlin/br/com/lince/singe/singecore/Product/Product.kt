package br.com.lince.singe.singecore.Product


data class Product(
    val uuid: String?,
    val name: String,
    val color: String,
    val colorCode: Int,
    val productCode: Int,
    val quantity : Int,
    val netWeight: Int,
    val grossWeight: Int,
    val price: Double
)

data class ProductCreateResponse(
    val Product: Product? = null,
    val errorMessage: String? = null,
)

data class ProductDeleteResponse(
    val Product: Product? = null,
    val errorMessage: String? = null,
)

data class ListProductResponse(
    val Products: List<Product>? = null,
    val errorMessage: String? = null,
)