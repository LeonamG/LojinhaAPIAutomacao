package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Testes de API REST do modulo de produto")

public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach(){
        // Confgurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";

        basePath = "/lojinha-bugada";

        // Obter Token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.fornecerOsDadosDeLogin("admin","admin"))
            .when()
                .post("/v2/login")

            .then()
                .extract()
                    .path("data.token");
    }


    @Test
    @DisplayName("Validar o do valor do produto igual a 0.00 nao é permitido ")
    public void testValidarLimitesZeradoProibidoValorProduto() {



        // Tentar inserir um produto com valor 0.00 e validae que a mensagem de erro foi apresentada e o
        // Status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))

                .when()
                 .post("/v2/produtos")


                .then()
                    .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);


    }

    @Test
    @DisplayName("Validar o do valor do produto igual a 7000.01 nao é permitido  ")
    public void testValidarLimitesMaiorQueSeteMilProibidoValorProduto() {


        // Tentar inserir um produto com valor 7000.00 e valide que a mensagem de erro foi apresentada e o
        // Status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7000.01))

                .when()
                    .post("/v2/produtos")


                .then()
                    .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);


    }
}
