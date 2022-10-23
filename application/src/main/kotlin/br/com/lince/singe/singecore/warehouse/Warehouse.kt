package br.com.lince.singe.singecore.warehouse


data class Warehouse(
    val uuid: String?,
    val name: String,
    val address: String,
    val cnpj: Int
)

data class WarehouseCreateResponse(
    val Warehouse: Warehouse? = null,
    val errorMessage: String? = null,
)

data class WarehouseDeleteResponse(
    val Warehouse: Warehouse? = null,
    val errorMessage: String? = null,
)

data class ListWarehouseResponse(
    val Warehouses: List<Warehouse>? = null,
    val errorMessage: String? = null,
)