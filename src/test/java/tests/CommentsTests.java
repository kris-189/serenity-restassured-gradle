package tests;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.CommentsSteps;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayName("REST API tests for comments endpoints")
public class CommentsTests extends BaseTest {
    @Steps
    CommentsSteps commentsSteps;

    @Test
    @DisplayName("Fetch comments")
    public void getComments() {
        Response response = commentsSteps.getComments();
        commentsSteps.verifyStatusCode(response, 200);
        commentsSteps.commentsResponseIsNotEmpty(response);
        commentsSteps.verifyEveryCommentHasEmail(response);
    }
}
