package br.com.lince.singe.singecore.foo

import com.github.f4b6a3.uuid.UuidCreator
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
open class BasicFooUseCase(
    private val fooRepository: FooRepository,
) : FooUseCase {
    override fun listAllFoos(): List<Foo> = fooRepository.readAllFoos()

    override fun saveFoo(foo: Foo): Foo {
        return if (foo.uuid == null) {
            // Here we generate a new sequential uuid based in the time
            val generateUUID = UuidCreator.getTimeOrdered().toString()
            fooRepository.createFoo(foo.copy(uuid = generateUUID))
        } else {
            fooRepository.updateFoo(foo)
        }
    }

    override fun deleteFooByUUID(uuid: String): Foo? {
        return try {
            val foo = getFooByUUID(uuid) ?: return null

            fooRepository.deleteFooByUUID(uuid)

            foo
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getFooByUUID(uuid: String): Foo? = fooRepository.readFooByUUID(uuid)
}