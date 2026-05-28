package tests;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.UsersSteps;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayName("REST API tests for users endpoints")
public class UsersTests extends BaseTest {
    @Steps
    UsersSteps usersSteps;

    @Test
    @DisplayName("Fetch users")
    public void getUsers() {
        Response response = usersSteps.getUsers();
        usersSteps.verifyStatusCode(response, 200);
        usersSteps.verifyEveryUserHasAddressWithCity(response);
    }

    @Test
    @DisplayName("Fetch user by parameter")
    public void filterUsers() {
        Response response = usersSteps.getUserByQueryParam();
        usersSteps.verifyStatusCode(response, 200);
        usersSteps.usersResponseHasOneUser(response);
        usersSteps.verifyUsername(response, "Bret");

    }
}
