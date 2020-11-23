package iastate.edu.ecommerce.Project;

import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends Repository {
    int returnVal(String token1,int expire);
    void deleteToken(String token1);
    void deleteUserToken(String email1);
    String returnEmail(String token1);
    void save(Tokens token);
}
