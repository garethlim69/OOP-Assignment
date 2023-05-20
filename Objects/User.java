package Objects;

import java.io.Serializable;
import java.util.UUID;


public class User implements Serializable{
    private UUID userId;
    private String username;
    private String email;
    private String password;

    public User(UUID userID, String username, String email, String password) {
        super();
        this.userId = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
