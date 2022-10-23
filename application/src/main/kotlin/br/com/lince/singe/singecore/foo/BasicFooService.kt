package br.com.lince.singe.singecore.foo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/foo")
open class BasicFooService(
    private val fooUseCase: FooUseCase
) : FooService {
    @GetMapping("/all")
    override fun listAllFoos(): ListFooResponse {
        return try {
            ListFooResponse(fooUseCase.listAllFoos())
        } catch (e: Exception) {
            ListFooResponse(null, e.message)
        }
    }

    @PostMapping("/manage")
    override fun createOrUpdateFoo(@RequestBody foo: Foo): FooCreateResponse {
        return try {
            FooCreateResponse(fooUseCase.saveFoo(foo))
        } catch (e: Exception) {
            FooCreateResponse(errorMessage = e.message)
        }
    }

    @DeleteMapping("/{uuid}")
    override fun deleteFooByUUID(@PathVariable("uuid") uuid: String): FooDeleteResponse {
        return try {
            FooDeleteResponse(fooUseCase.deleteFooByUUID(uuid))
        } catch (e: Exception) {
            FooDeleteResponse(errorMessage = e.message)
        }
    }

}