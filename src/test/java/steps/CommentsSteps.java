package steps;

import io.restassured.response.Response;
import models.Comments;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommentsSteps extends BaseSteps {
    @Step("Fetch all comments")
    public Response getComments() {
        return SerenityRest
                .when()
                .get("/posts/1/comments");
    }

    @Step("Verify if comments response list is not empty")
    public void commentsResponseIsNotEmpty(Response response) {
        List<Comments> comments = response.jsonPath().getList(".", Comments.class);
        assertFalse(comments.isEmpty());
    }

    @Step("Verify each comment has email and if email is valid")
    public void verifyEveryCommentHasEmail(Response response) {
        List<Comments> comments = response.jsonPath().getList(".", Comments.class);

        comments.forEach(comment -> {
            assertNotNull(comment.getEmail());
            assertTrue(comment.getEmail().contains("@"));
        });
    }
}
