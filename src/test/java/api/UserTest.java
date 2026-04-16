package api;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTest extends BaseTest {

    @Test
    public void deveRetornarListaDeUsuarios() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", hasSize(10))
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].email", notNullValue());
    }

    @Test
    public void deveRetornarUsuarioPorId() {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("username", notNullValue())
                .body("email", notNullValue());
    }

    @Test
    public void deveRetornarUsuarioComCamposEsperados() {
        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(2))
                .body("address", notNullValue())
                .body("company", notNullValue())
                .body("company.name", notNullValue())
                .body("address.city", notNullValue());
    }
    @Test
    public void deveRetornarUsuarioInexistente() {
        given()
                .when()
                .get("/users/999")
                .then()
                .statusCode(404);
    }
}