package api;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.FileUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostTest extends BaseTest {

    @Test
    public void deveRetornarPosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", hasSize(100))
                .body("[0].id", equalTo(1))
                .body("[0].title", notNullValue());

    }

    @Test
    public void deveCriarNovoPost() throws Exception {

        String body = FileUtils.readFile("src/test/resources/payloads/post.json");

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", equalTo("Meu post de teste"))
                .body("body", equalTo("Conteudo criado no teste"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }
    @Test
    public void deveValidarEstruturaDoPostRetornado() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("userId", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue());
    }
}