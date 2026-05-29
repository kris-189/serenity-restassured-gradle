package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
