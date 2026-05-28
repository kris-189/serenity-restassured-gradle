package steps;

import io.restassured.response.Response;
import models.Post;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostsSteps extends BaseSteps{
    @Step("Request all posts")
    public Response getAllPosts() {
        return SerenityRest
                .when()
                .get("/posts");
    }

    @Step("Verify response contains {1} posts")
    public void verifyPostCount(Response response, int expectedCount) {
        List<Post> posts = response.jsonPath().getList(".", Post.class);
        assertEquals(posts.size(), expectedCount);
    }

    @Step("Verify each post has required fields (id, userId, title, body)")
    public void verifyPostsHaveRequiredFields(Response response) {
        List<Post> posts = response.jsonPath().getList(".", Post.class);
        posts.forEach(post -> {
            assertNotNull(post.getId());
            assertNotNull(post.getUserId());
            assertNotNull(post.getTitle());
            assertNotNull(post.getBody());
        });
    }

    @Step("Request post with id {0}")
    public Response getPostById(int postId) {
        return SerenityRest
                .when()
                .get("/posts/" + postId);
    }

    @Step("Verify response body matches post id {1}")
    public void verifyPostId(Response response, int expectedId) {
        Post post = response.as(Post.class);
        assertEquals(post.getId(),expectedId);
    }


    @Step("Verify post title is not null")
    public void verifyPostTitleNotNull(Response response) {
        Post post = response.as(Post.class);
        assertNotNull(post.getTitle());
    }

    @Step("Create new post")
    public Response createNewPost() {
        File jsonData = new File("src/test/resources/testsData/addPost.json");

        return SerenityRest
                .given()
                .body(jsonData)
                .when()
                .post("/posts/");
    }

    @Step("Verify response ID is not null")
    public void verifyPostIdNotNull(Response response) {
        Post post = response.as(Post.class);
        assertNotNull(post.getId());
        assertTrue(post.getId() > 0);
    }

    @Step("Verify post title text")
    public void verifyPostTitleText(Response response, String expectedTitle) {
        String actualTitle = response.jsonPath().getString("title");
        assertEquals(expectedTitle, actualTitle);
    }

    @Step("Update to existing post")
    public Response putToExistingPost() {
        File jsonData = new File("src/test/resources/testsData/updatePost.json");

        return SerenityRest
                .given()
                .body(jsonData)
                .when()
                .put("/posts/1");
    }

    @Step("Partial update existing post")
    public Response patchExistingPost() {
        File jsonData = new File("src/test/resources/testsData/updatePostPartially.json");

        return SerenityRest
                .given()
                .body(jsonData)
                .when()
                .patch("/posts/1");
    }

    @Step("Delete existing post")
    public Response deleteExistingPost() {
        return SerenityRest
                .when()
                .delete("/posts/1");
    }
}
