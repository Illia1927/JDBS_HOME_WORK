package jdbspractise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "userId")
public class User {
    private Long userId;
    private String name;
    private String login;
    private String password;
    private String email;
    private String token;
    private Role roles;

    public User(String login, String name, String email,  String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String getToken(){
        return token;
    }
}
