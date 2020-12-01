package com.softwaresenitest.repository;

import com.softwaresenitest.entity.Trax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource(exported = false)
public interface TraxRepository extends JpaRepository<Trax, String> {
    @Query("SELECT x FROM Trax x WHERE x.id = ?1")
    Trax findOneById(Long id);

    @Query("SELECT x FROM Trax x WHERE x.type = ?1")
    List<Trax> findByType(String type);

    @Query("SELECT x FROM Trax x WHERE x.parentId = ?1")
    List<Trax> findByParentId(Long parentId);
}
