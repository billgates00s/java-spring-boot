package com.tma.bookmanagement.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tma.bookmanagement.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into employee(name_employee,identity_card,address) values (:name_employee,:identity_card,:address)")
    void insertEmployee(@Param("name_employee") String name_employee,
                        @Param("identity_card") String identity_card,
                        @Param("address") String address);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Employee SET name_employee=:name_employee, identity_card=:identity_card, address=:address WHERE id=:id")
    void updateEmployee(@Param("id") Long id,
                        @Param("name_employee") String name_employee,
                        @Param("identity_card") String identity_card,
                        @Param("address") String address);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from Employee where employee_id=:id")
    void deletedEmployee(@Param("id") Long id);
    @Query(nativeQuery = true, value = "select * from employee e where e.name_employee=:name_employee")
    List<Employee> findByName(@Param("name_employee") String name_employee);

}
