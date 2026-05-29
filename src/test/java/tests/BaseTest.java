package tests;

import io.restassured.http.ContentType;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void setUp() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseURI = env.getProperty("restassured.baseURI");

        io.restassured.RestAssured.requestSpecification = new io.restassured.builder.RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseURI)
                .build();
    }
}
