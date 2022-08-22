package modulos.produto;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes  de API Rest do modulo de Produto")
public class ProdutoTest {
    private String token;

        @BeforeEach
        public void beforeEach(){
            baseURI = "https://serverest.dev";
            //baseURI = "http://localhost";
            //port = 3000;

        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.usuarioLogin("paula@qa.com.br", "teste"))
        .when()
                .post("/login")
        .then()
                .extract()
                .path("authorization");
    }

    @Test
    @DisplayName("Validar cadastro de produto com sucesso")
    public void testCadastroDeProdutoComSucesso(){
        given()
            .contentType(ContentType.JSON)
            .header("authorization", this.token)
            .body(ProdutoDataFactory.cadastrarProduto("Iphone 13 Pro Max", 11500.5, "Celular", 4))
        .when()
            .post("/produtos")
        .then()
            .assertThat()
            .body("success", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);

    }

    @Test
    @DisplayName("Validar cadastro de produto já existente")
    public void testCadastroDeProdutoExistente(){
        given()
            .contentType(ContentType.JSON)
            .header("authorization", this.token)
            .body(ProdutoDataFactory.cadastrarProduto("Iphone 13 Pro Max", 6477, "Celular", 7))
        .when()
            .post("/produtos")
        .then()
            .assertThat()
            .body("message", equalTo("Já existe produto com esse nome"))
            .statusCode(400);

    }

    @Test
    @DisplayName("Validar cadastro de produto sem token")
    public void testCadastroDeProdutoSemToken(){
        this.token = "";
        given()
            .contentType(ContentType.JSON)
            .header("authorization", this.token)
            .body(ProdutoDataFactory.cadastrarProduto("LG 55 polegadas", 4000, "TV", 15))
        .when()
            .post("/produtos")
        .then()
            .assertThat()
            .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
            .statusCode(401);

    }
    @Test
    @DisplayName("Validar cadastro de produto com rota exclusiva para adms")
    public void testCadastroDeProdutoComRotaExclusivaParaAdm(){
        this.token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVkdWFyZGFzaWx2YUBxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNjYxMTI5MDc0LCJleHAiOjE2NjExMjk2NzR9.kKQnUKB1KGYol6CQfYe9Rtoq-0VdcOchPEpN_A5vuWg"; // token de usuario que nao eh adm
        given()
            .contentType(ContentType.JSON)
            .header("authorization", this.token)
            .body(ProdutoDataFactory.cadastrarProduto("DELL", 5500, "PC", 1))
        .when()
            .post("/produtos")
        .then()
            .assertThat()
            .body("message", equalTo("Rota exclusiva para administradores"))
            .statusCode(403);

    }

}
