package br.com.lince.singe.singecore.Product

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
open class ExposedProductRepository : ProductRepository {
     override fun createProduct(Product: Product): Product {
        return transaction {
            ProductTable.insert {
                it[uuid] = Product.uuid!!
                it[name] = Product.name
                it[productCode] = Product.productCode
                it[color] = Product.color
                it[colorCode] = Product.colorCode
                it[quantity] = Product.quantity
                it[netWeight] = Product.netWeight
                it[grossWeight] = Product.grossWeight
                it[price] = Product.price
            }
            Product
        }
    }

     fun createProduct(): Product {
        TODO("Not yet implemented")
    }

    override fun updateProduct(Product: Product): Product {
        return transaction {
            ProductTable.update({ ProductTable.uuid eq Product.uuid!! }) {
                it[name] = Product.name
                it[color] = Product.color
                it[productCode] = Product.productCode
                it[colorCode] = Product.colorCode
                it[quantity] = Product.quantity
                it[netWeight] = Product.netWeight
                it[grossWeight] = Product.grossWeight
                it[price] = Product.price
            }
            Product
        }
    }

    override fun readAllProducts(): List<Product> {
        return transaction {
            ProductTable.selectAll().map {
                Product(
                    it[ProductTable.uuid],
                    it[ProductTable.name],
                    it[ProductTable.color],
                    it[ProductTable.colorCode],
                    it[ProductTable.productCode],
                    it[ProductTable.quantity],
                    it[ProductTable.netWeight],
                    it[ProductTable.grossWeight],
                    it[ProductTable.price]
                )
            }
        }
    }

    override fun readProductByUUID(uuid: String): Product? {
        return transaction {
            ProductTable.select { ProductTable.uuid eq uuid }.firstOrNull()?.let {
                Product(
                    it[ProductTable.uuid],
                    it[ProductTable.name],
                    it[ProductTable.color],
                    it[ProductTable.colorCode],
                    it[ProductTable.productCode],
                    it[ProductTable.quantity],
                    it[ProductTable.netWeight],
                    it[ProductTable.grossWeight],
                    it[ProductTable.price]
                )
            }
        }
    }

    override fun deleteProductByUUID(uuid: String) {
        return transaction {
            ProductTable.deleteWhere { ProductTable.uuid eq uuid }
        }
    }
}