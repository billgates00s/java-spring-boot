package com.tma.bookmanagement.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tma.bookmanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO users(user_name,pass_word,active) " +
                    "VALUES (:username,:password,:active )")
    void insertUser(@Param("username") String username,
                    @Param("password") String password,
                    @Param("active") boolean active);

    @Query(nativeQuery = true, value = "select * from users u where u.user_name=:username")
    User findByUserName(@Param("username") String username);

}
