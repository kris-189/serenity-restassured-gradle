package tests;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void setUp() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseURI = env.getProperty("restassured.baseURI");
        SerenityRest.setDefaultBasePath("");
        io.restassured.RestAssured.baseURI = baseURI;

        io.restassured.RestAssured.requestSpecification = new io.restassured.builder.RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
