package br.com.lince.singe.singecore.foo

/**
 * Defines the CRUD operations
 */
interface FooRepository {
    /**
     * Stores a new foo
     */
    fun createFoo(foo: Foo): Foo

    /**
     * Updates an existing foo
     */
    fun updateFoo(foo: Foo): Foo

    /**
     * Returns all the foos
     */
    fun readAllFoos(): List<Foo>

    /**
     * Returns the foo matching the provided uuid
     */
    fun readFooByUUID(uuid: String): Foo?

    /**
     * Deletes the foo matching the provided uuid
     */
    fun deleteFooByUUID(uuid: String)
}