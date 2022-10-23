package br.com.lince.singe.singecore.foo

/**
 * Represents a foo in the system
 */
data class Foo(
    /**
     * The Universally Unique IDentifier of this foo
     */
    val uuid: String?,

    /**
     * The bar value of foo
     */
    val bar: String,

    /**
     * The bas value of foo
     */
    val bas: Int,
)

/**
 * Entity returned when trying to create a new foo
 */
data class FooCreateResponse(
    /**
     * The foo created in the request, if the request was sucessful
     */
    val foo: Foo? = null,

    /**
     * A description of the error that stopped foo a from being created
     */
    val errorMessage: String? = null,
)

/**
 * Entity returned when trying to deleta a foo
 */
data class FooDeleteResponse(
    /**
     * The foo that was just deleted if the request was successful
     */
    val foo: Foo? = null,

    /**
     * A description of the error that stopped foo a from being deleted
     */
    val errorMessage: String? = null,
)

/**
 * Entity returned whe listing foos
 */
data class ListFooResponse(
    /**
     * The list of foos in the system
     */
    val foos: List<Foo>? = null,

    /**
     * A description of the error that stopped foos a from being listed
     */
    val errorMessage: String? = null,
)