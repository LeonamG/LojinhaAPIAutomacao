## Lojinha API Automação
Esse é um repositorio que contém a automação de alguns testes de API Rest de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto

## Tecnologias Usadas

- Java
  https://www.oracle.com/br/java/technologies/downloads/
- JUnit
  [Maven Repository: org.junit.jupiter » junit-jupiter-engine » 5.10.2 (mvnrepository.com)](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.10.2)
- RestAssured
  [Maven Repository: io.rest-assured » rest-assured » 5.4.0 (mvnrepository.com)](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.4.0)
- Maven
  [Maven – Welcome to Apache Maven](https://maven.apache.org/)

## Testes Automatizados
Testes para validar as partições de equivalencia relacionadas ao valor do produto na Lojinha, que estão veinculadas diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais
- Sempre utilizamos as anotações Before Each para capturar o token que será utiliziado posteriormente nos métodos de testes.
- Armazenamos os dados que são enviados para API através do uso de classes POJO
- Criamos dados inciais através do uso de classe Data Factory, para facilitar a criação e controle dos mesmos
- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes. 