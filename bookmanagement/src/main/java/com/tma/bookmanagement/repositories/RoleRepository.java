package com.tma.bookmanagement.repositories;

import com.tma.bookmanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(nativeQuery = true, value = "select r.role_name from role r join user_role ur on ur.role_id = r.role_id where ur.user_id=:userId")
    List<String> getRoleNames(@Param("userId") Long userID);

}
