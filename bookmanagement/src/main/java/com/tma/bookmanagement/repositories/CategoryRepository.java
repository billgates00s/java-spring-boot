package com.tma.bookmanagement.repositories;

import com.tma.bookmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into category(name_category) values (:name)")
    void insertCategory(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE category SET name_category=:name_category WHERE id=:id")
    void updateCategory(@Param("id") Long id,
                        @Param("name_category") String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM category WHERE category_id=:id")
    void deletedCategory(@Param("id") Long id);
}
