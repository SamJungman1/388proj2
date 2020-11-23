package com.example.Backend.UserControllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokensRepository extends JpaRepository<Tokens,String> {

    @Modifying
    @Query(value = "DELETE From Tokens where token = :token",nativeQuery = true)
    void deleteTokens(@Param("token") String token);


    @Query(value = "select * from Tokens where Tokens.token = :inp",nativeQuery = true)
    Tokens checkToken(@Param("inp") String token);


}
