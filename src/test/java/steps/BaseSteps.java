package steps;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps {
    @Step("Verify status code is {1}")
    public void verifyStatusCode(Response response, int expectedCode) {
        assertEquals(response.getStatusCode(), expectedCode);
    }
}
