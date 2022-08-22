package modulos.usuario;

import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Testes  de API Rest do modulo de Usuario")
public class UsuarioTest {

    @BeforeEach
    public void beforeEach() {
        baseURI = "http://localhost";
        port = 3000;
    }

    @Test
    @DisplayName("Validar cadastro com sucesso de usuario")
    public void testCadastroDeUsuarioComSucesso(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Eduarda Pereira", "eduarda@qa.com.br", "teste", false))
        .when()
            .post("/usuarios")
        .then()
            .assertThat()
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);
    }

    @Test
    @DisplayName("Validar cadastro de usuario com email ja utilizado")
    public void testCadastroDeUsuarioComEmailJaUtilizado(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Eduarda Silva", "fulano@qa.com", "teste", false))
        .when()
            .post("/usuarios")
        .then()
            .assertThat()
            .body("message", equalTo("Este email já está sendo usado"))
            .statusCode(400);
    }

    @Test
    @DisplayName("Validar dados de login de todos os usuarios")
    public void testDadosDeLoginDeTodosOsUsuarios(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/usuarios")
        .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    @DisplayName("Validar dados de login de um usuario")
    public void testDadosDeLoginDeUmUsuario(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/usuarios/0uxuPY0cbmQhpEz1")
        .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    @DisplayName("Validar edicao dos dados de login de um usuario com sucesso")
    public void testEdicaoDeDadosDeLoginDeUmUsuarioComSucesso(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Fernanda", "fesilva@qa.com.br", "teste", true))
        .when()
            .put("/usuarios/0uxuPY0cbmQhpEz1")
        .then()
            .assertThat()
            .body("message", equalTo("Registro alterado com sucesso"))
            .statusCode(200);
    }

    @Test
    @DisplayName("Validar edicao do email de um usuario para um email já cadastrado")
    public void testEdicaoDeEmailParaEmailJaCadastrado(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Fernanda Rodrigues", "fulano@qa.com", "1234", true))
        .when()
            .put("/usuarios/0uxuPY0cbmQhpEz1")
        .then()
            .assertThat()
            .body("message", equalTo("Este email já está sendo usado"))
            .statusCode(400);
    }

    @Test
    @DisplayName("Validar edicao de um usuario com ID inexistente")
    public void testEdicaoDeUsuarioComIdInexistente(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Fernanda", "fernanda@qa.com.br", "teste", true))
        .when()
            .put("/usuarios/0uz1")
        .then()
            .assertThat()
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);
    }

    @Test
    @DisplayName("Validar edicao de um usuario com ID inexistente e com email já existente")
    public void testEdicaoDeUsuarioComIdInexistenteEComEmailExistente(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.cadastrarUsuario("Fernanda", "fulano@qa.com", "teste", true))
        .when()
            .put("/usuarios/0z1")
        .then()
            .assertThat()
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .statusCode(201);
    }

    @Test
    @DisplayName("Validar remocao de um usuario com sucesso")
    public void testRemocaoDeUsuarioComSucesso(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .delete("/usuarios/0uxuPY0cbmQhpEz1")
        .then()
            .assertThat()
            .body("message", equalTo("Registro excluído com sucesso"))
            .statusCode(200);
    }

    @Test
    @DisplayName("Validar remocao de um usuario que possui carrinho cadastrado")
    public void testRemocaoDeUsuarioComCarrinhoCadastrado(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .delete("/usuarios/oUb7aGkMtSEPf6BZ")
        .then()
            .assertThat()
            .body("message", equalTo("Não é permitido excluir usuário com carrinho cadastrado"))
            .statusCode(400);
    }
}
