package iastate.edu.ecommerce.Project;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Tokens {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private int tokenId;

    @Column(name = "val")
    @NotFound(action = NotFoundAction.IGNORE)
    private String val;

    @Column(name = "expires")
    @NotFound(action = NotFoundAction.IGNORE)
    private long expires;

    @Column(name = "Email")
    @NotFound(action = NotFoundAction.IGNORE)
    private String email;

    public void setUserId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getUserId() {
        return tokenId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setVal(String token) {
        this.val = token;
    }

    public String getVal() {
        return val;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }
}
