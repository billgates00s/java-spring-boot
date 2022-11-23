package com.tma.bookmanagement.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tma.bookmanagement.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into student(name_student,identity_card,address,birth_date) values (:name_student,:identity_card,:address,:birth_date)")
    void insertStudent(@Param("name_student") String name_student,
                       @Param("identity_card") String identity_card,
                       @Param("address") String address,
                       @Param("birth_date") LocalDate date);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE student SET name_student=:name_student, identity_card=:identity_card, address=:address,birth_date=:birth_date WHERE id=:id")
    void updateStudent(@Param("id") Long id,
                       @Param("name_student") String name_employee,
                       @Param("identity_card") String identity_card,
                       @Param("address") String address,
                       @Param("birth_date") LocalDate birth_date);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM student WHERE student_id=:id")
    void deletedStudent(@Param("id") Long id);
}
