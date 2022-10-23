# HACKATHON : Projeto base backend

## Estrutura da aplicação:

A estrutura da aplicação é controlada pelo Gradle, onde os modulos do projeto são definidos em "settings.gradle.kts".

```kotlin
// Aqui é definido do projeto
rootProject.name = "singe-multi-module"

// Aqui são definidos os modulos do projeto
include("application") // É nucleo responsavel por inicializar a aplicação
```

# Acesso ao banco de dados

Abrir o arquivo "application.properties" e atualizar as configurações do banco de dados conforme as credenciais do
grupo a que você pertence.

_**Obs.**: Devido às configurações do projeto, os objetos Table() do exposed são criados automaticamente ao executar o
programa, não precisa ser chamado o SchemaUtils#create(...)._

Servidor: **devserver**   
Porta: **5432**

| Grupo | Banco        | Login  | Senha      |
|-------|--------------|--------|------------|
| 1     | hackathon_g1 | grupo1 | passg1_xai |
| 2     | hackathon_g2 | grupo2 | passg2_pyt |
| 3     | hackathon_g3 | grupo3 | passg3_ows |
| 4     | hackathon_g4 | grupo4 | passg4_lqi |

# Regras do código-fonte

1. Todo o código-fonte deve ser em inglês
2. Não podem ser usadas abreviações, os nomes das variáveis/métodos/funções/atributos devem ser descritivo
3. Não utilizar termos redundantes
4. Utilizar as definições padrão do
   Kotlin/Java ([acessar documentação](https://kotlinlang.org/docs/coding-conventions.html))
    1. Constantes: UPPER_CAMEL_CASE
    2. Variáveis: snakeCase
    3. Classes: PascalCase
    4. Abertura de bloco na mesma linha (ver exemplo)
    5. Código-fonte deve ser indentado corretamente (atalho **Ctrl+Alt+L**)

```kotlin
// Exemplo da regra 3 - Certo
data class Person(val name: String, val age: Int)

// Exemplo da regra 3 - Errado
data class Person(val personName: String, val personAge: Int)

// Exemplo da regra 4.iv - Certo
class Example {
    fun test() {
        print("...")
    }
}

// Exemplo da regra 4.iv - Errado
class Example {
    fun test() {
        print("...")
    }
}
```
