package jdbspractise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "user_id")
public class User {
    private Long user_id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String tokken;

    public User(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getToken(){
        return tokken;
    }
}
