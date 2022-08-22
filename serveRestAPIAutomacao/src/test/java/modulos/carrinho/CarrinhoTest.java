package modulos.carrinho;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import dataFactory.CarrinhoDataFactory;
import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.CarrinhoPojo;
import pojo.ProdutoPojo;

@DisplayName("Testes  de API Rest do modulo de Carrinho")
public class CarrinhoTest {
    private String token;
    
            @BeforeEach
            public void beforeEach(){
                baseURI = "http://localhost";
                port = 3000;
    
            this.token = given()
                    .contentType(ContentType.JSON)
                    .body(UsuarioDataFactory.usuarioLogin("anaiza@qa.com.br", "teste"))
            .when()
                    .post("/login")
            .then()
                    .extract()
                    .path("data.authorization");
            }
    @Test
    @DisplayName("Validar cadastro de produto com sucesso")
    public void testCadastroDeProdutoComSucesso(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Fabricio", "fabricio@qa.com.br", "teste", true))
        .when()
            .post("/usuarios")
        .then()
            .assertThat()
            .body("success", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);

        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
            .body(CarrinhoDataFactory.cadastrarCarrinho())
        .when()
            .post("/carrinhos")
        .then()
            .assertThat()
            .body("success", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);

        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
        .when()
            .delete("/carrinhos/concluir-compra")
        .then()
            .assertThat()
            .body("success", equalTo("Registro excluído com sucesso | Não foi encontrado carrinho para esse usuário"))
            .statusCode(200);

        //Assertions.assertEquals(10, );
        //Assertions.assertEquals(3,  );


    }
}
