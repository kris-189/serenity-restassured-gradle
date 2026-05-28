package steps;

import io.restassured.response.Response;
import models.User;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsersSteps extends BaseSteps {
    @Step("Fetch all users")
    public Response getUsers() {
        return SerenityRest
                .when()
                .get("/users");
    }

    @Step("Verify each user has city in address")
    public void verifyEveryUserHasAddressWithCity(Response response) {
        List<User> users = response.jsonPath().getList(".", User.class);

        users.forEach(user -> assertNotNull(user.getAddress().getCity()));
    }

    @Step("Fetch user by parameter")
    public Response getUserByQueryParam() {
        return SerenityRest
                .when()
                .get("/users?username=Bret");
    }

    @Step("Verify response to have one user")
    public void usersResponseHasOneUser(Response response) {
        List<User> users = response.jsonPath().getList(".", User.class);
        assertEquals(1, users.size());
    }

    @Step("Verify username is {1}")
    public void verifyUsername(Response response, String expectedUsername) {
        List<User> users = response.jsonPath().getList(".", User.class);
        assertEquals(expectedUsername, users.getFirst().getUsername());
    }
}
