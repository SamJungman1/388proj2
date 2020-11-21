package iastate.edu.ecommerce.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Procedure(procedureName ="Store_New_User")
    void storeNewUser(String email, String username,String password,String firstName,String lastName,String address,String city,String zipCode,String state,String country,String picturePointer);
    @Procedure(procedureName ="Check_Login")
    int checkLogin(String email, String password);
    @Query("SELECT Email, FROM User WHERE Email = :email")
    User getPassword(@Param("email") String email);
}
