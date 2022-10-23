package br.com.lince.singe.singecore.foo

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
open class ExposedFooRepository : FooRepository {
    override fun createFoo(foo: Foo): Foo {
        return transaction {
            FooTable.insert {
                it[uuid] = foo.uuid!!
                it[bar] = foo.bar
                it[bas] = foo.bas
            }
            foo
        }
    }

    override fun updateFoo(foo: Foo): Foo {
        return transaction {
            FooTable.update({ FooTable.uuid eq foo.uuid!! }) {
                it[bar] = foo.bar
                it[bas] = foo.bas
            }
            foo
        }
    }

    override fun readAllFoos(): List<Foo> {
        return transaction {
            FooTable.selectAll().map {
                Foo(
                    it[FooTable.uuid],
                    it[FooTable.bar],
                    it[FooTable.bas],
                )
            }
        }
    }

    override fun readFooByUUID(uuid: String): Foo? {
        return transaction {
            FooTable.select { FooTable.uuid eq uuid }.firstOrNull()?.let {
                Foo(
                    it[FooTable.uuid],
                    it[FooTable.bar],
                    it[FooTable.bas],
                )
            }
        }
    }

    override fun deleteFooByUUID(uuid: String) {
        return transaction {
            FooTable.deleteWhere { FooTable.uuid eq uuid }
        }
    }
}