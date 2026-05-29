package tests;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.PostsSteps;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayName("REST API tests for posts endpoints")
public class PostTests extends BaseTest {
    @Steps
    PostsSteps postsSteps;

    @Test
    @DisplayName("Fetch all posts and verify status code, number of posts and required fields")
    public void getAllPosts() {
        Response response = postsSteps.getAllPosts();
        postsSteps.verifyStatusCode(response, 200);
        postsSteps.verifyPostCount(response, 100);
        postsSteps.verifyPostsHaveRequiredFields(response);
    }

    @Test
    @DisplayName("Fetch single post and verify status code, post ID and if title is not null")
    public void getSinglePost() {
        Response response = postsSteps.getPostById(1);
        postsSteps.verifyStatusCode(response, 200);
        postsSteps.verifyPostId(response, 1);
        postsSteps.verifyPostTitleNotNull(response);
    }

    @Test
    @DisplayName("Try to fetch non-existent post and verify status code")
    public void getNonExistentPost() {
        Response response = postsSteps.getPostById(9999);
        postsSteps.verifyStatusCode(response, 404);
    }

    @Test
    @DisplayName("Create new post and verify status code, title")
    public void createNewPost() {
        Response response = postsSteps.createNewPost();
        postsSteps.verifyStatusCode(response, 201);
        postsSteps.verifyPostIdNotNull(response);
        postsSteps.verifyPostTitleText(response, "Test Post");
    }

    @Test
    @DisplayName("Update existing post")
    public void updatePost() {
        Response response = postsSteps.putToExistingPost();
        postsSteps.verifyStatusCode(response, 200);
        postsSteps.verifyPostTitleText(response, "Updated Title");
    }

    @Test
    @DisplayName("Partial update to existing post")
    public void partialUpdatePost() {
        Response response = postsSteps.patchExistingPost();
        postsSteps.verifyStatusCode(response, 200);
        postsSteps.verifyPostTitleText(response, "Patched Title");
    }

    @Test
    @DisplayName("Delete existing post")
    public void deletePost() {
        Response response = postsSteps.deleteExistingPost();
        postsSteps.verifyStatusCode(response, 200);
    }
}
