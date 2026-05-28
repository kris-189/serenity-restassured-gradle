package models;

public class Comments {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

    public Comments() {}

    public Comments(Integer postId, String name, String body, String email) {
        this.postId = postId;
        this.name = name;
        this.body = body;
        this.email = email;
    }

    public Integer getPostId() {
        return postId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
