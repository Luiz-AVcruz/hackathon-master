package br.com.lince.singe.singecore.packinglist


data class Packinglist(
    val uuid: String?,
    val boxNumber: Int,
    val color: String,
    val article: String,
    val quantity: Int,
    val netWeight: Int,
    val grossWeight: Int,
    val batch: Int
)

data class PackinglistCreateResponse(
    val Packinglist: Packinglist? = null,
    val errorMessage: String? = null,
)

data class PackinglistDeleteResponse(
    val Packinglist: Packinglist? = null,
    val errorMessage: String? = null,
)

data class ListPackinglistResponse(
    val Packinglists: List<Packinglist>? = null,
    val errorMessage: String? = null,
)