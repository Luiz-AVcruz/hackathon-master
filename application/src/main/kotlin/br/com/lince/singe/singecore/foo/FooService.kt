package br.com.lince.singe.singecore.foo

/**
 * Defines the actions available for foo in the system
 */
interface FooService {
    /**
     * Returns all the foos in the system
     */
    fun listAllFoos(): ListFooResponse

    /**
     * Creates or updates foo in the system
     */
    fun createOrUpdateFoo(foo: Foo): FooCreateResponse

    /**
     * Deletes the foo
     */
    fun deleteFooByUUID(uuid: String): FooDeleteResponse
}