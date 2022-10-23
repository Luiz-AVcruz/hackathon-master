package br.com.lince.singe.singecore.foo

/**
 * The actions allowed to be performed with foo
 */
interface FooUseCase {
    /**
     * Returns all foos in the system
     */
    fun listAllFoos(): List<Foo>

    /**
     * Save the foo data in the application
     */
    fun saveFoo(foo: Foo): Foo

    /**
     * Delete the foo with the provided UUID
     */
    fun deleteFooByUUID(uuid: String): Foo?

    /**
     * Returns the foo with the provided UUID
     */
    fun getFooByUUID(uuid: String): Foo?
}