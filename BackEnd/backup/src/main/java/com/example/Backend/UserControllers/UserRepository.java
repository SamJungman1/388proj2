package com.example.Backend.UserControllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Procedure(procedureName ="Store_New_User")
    void storeNewUser(String email, String username,String password,String tag,String firstName,String lastName,String address,String city,String zipCode,String state,String country,String picturePointer);

    @Query (value = "call Check_Login(:email,:password)",nativeQuery = true)
    int checkLogin(@Param("email") String email, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE From user where email = :email",nativeQuery = true)
    void deleteUser(@Param("email") String email);



    @Query (value = "call Check_Tag(:username,:tag)",nativeQuery = true)
    int checkTag(@Param("username") String username, @Param("tag") String tag);

    @Query(value = "SELECT * FROM User WHERE Email = :email",nativeQuery = true)
    User getUser(@Param("email") String email);

    @Query(value = "SELECT * from User where username like %:username%", nativeQuery = true)
    List<User> searchUsers(@Param("username") String username);
}
